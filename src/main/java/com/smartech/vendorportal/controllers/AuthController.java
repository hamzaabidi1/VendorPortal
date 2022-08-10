package com.smartech.vendorportal.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.security.auth.login.AccountNotFoundException;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartech.vendorportal.entities.ERole;
import com.smartech.vendorportal.entities.EStatus;
import com.smartech.vendorportal.entities.JwtResponse;
import com.smartech.vendorportal.entities.LoginRequest;
import com.smartech.vendorportal.entities.MessageResponse;
import com.smartech.vendorportal.entities.Role;
import com.smartech.vendorportal.entities.SignUpDraft;
import com.smartech.vendorportal.entities.SignUpRequest;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.entities.UserDetailsImpl;
import com.smartech.vendorportal.services.RequestUpdateProfileService;
import com.smartech.vendorportal.services.UserControl;
import com.smartech.vendorportal.services.UserHistoryService;
import com.smartech.vendorportal.services.Utilities;
import com.smartech.vendorportal.services.jwt.JwtUtils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.util.Base64;

import net.bytebuddy.utility.RandomString;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

	Logger logger = LogManager.getLogger(AuthController.class);

	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	UserControl userControlservice;
	@Autowired
	UserHistoryService userHistoryServiceImpl;
	@Autowired
	RequestUpdateProfileService requestUpdateProfileService;
	@Autowired
	Utilities utilities;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		if (Boolean.FALSE.equals(userControlservice.retrieveUserByUserName(loginRequest.getUsername()))) {
			return ResponseEntity.badRequest().body(new MessageResponse("verify your username please ! "));

		} else {
			String originalInput = loginRequest.getUsername() + ":" + loginRequest.getPassword();
			String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());

			try {
				Authentication authentication = authenticationManager
						.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),
								loginRequest.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(authentication);
				String jwt = jwtUtils.generateJwtToken(authentication);
				UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
				List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
						.collect(Collectors.toList());
				return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
						userDetails.getEmail(), roles, userDetails.getStatus(), encodedString,userDetails.getLangue()));
			} catch (Exception e) {
				e.getMessage();
				return ResponseEntity.badRequest().body(new MessageResponse("verify your password please ! "));
			}

		}
	}

	@GetMapping("/existbyusername/{username}")
	public ResponseEntity<?> existbyusername(@Valid @PathVariable("username") String username) {
		if (Boolean.TRUE.equals(userControlservice.retrieveUserByUserName(username)))
			return ResponseEntity.ok().body(true);
		return ResponseEntity.ok().body(false);

	}

	@PostMapping("/signup/{username}")
	public ResponseEntity<?> registerUser(@Valid @PathVariable("username") String username,
			@Valid @RequestBody SignUpRequest signUpRequest) {
		try {
			User userverified = userControlservice.getbyUserName(username);
			User user = new User(userverified.getId(), signUpRequest.getFirstname(), signUpRequest.getLastname(),
					userverified.getUsername(), userverified.getEmail(), signUpRequest.getAddress(),
					signUpRequest.getCity(), signUpRequest.getRegion(), signUpRequest.getPostalcode(),
					signUpRequest.getCountry(), signUpRequest.getPhone(), userverified.isVendor(),
					userverified.isAdmin(), userverified.isEnabled(), userverified.getPassword(),
					userverified.getStatus(), signUpRequest.getTaxregistrationnumber(),
					signUpRequest.getTaxclassificationcode(), signUpRequest.getCompanywebsite(),
					signUpRequest.getRevenu(), signUpRequest.getDateestablished(), userverified.getVerifyAccountToken(),
					userverified.getDateCreation(),signUpRequest.getLangue());
			user.setRoles(userverified.getRoles());
			LocalDate today = LocalDate.now();
			user.setDateCreation(java.sql.Date.valueOf(today));
			user.setStatus(EStatus.Submitted);
			userControlservice.addUser(user);
			userControlservice.saveHistory(user, "", user.getStatus());
			return ResponseEntity.ok(new MessageResponse("Informations of vendor registered successfully!"));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(new MessageResponse("unexpected problems! "));

		}

	}

	@PostMapping("/forgetpassword/{email}")
	public ResponseEntity<?> processForgotPassword(@Valid @PathVariable("email") String email, @RequestBody String url)
			throws AccountNotFoundException, UnsupportedEncodingException {
		String token = RandomString.make(30);
		String encodedValue = StringUtils.chop(URLDecoder.decode(url, "UTF-8"));
		userControlservice.updateResetPasswordToken(token, email);
		String resetPasswordLink = encodedValue + "/passwordsConfirmation?token=" + token;
		String message = "Hello You have requested to reset your password."
				+ "Click the link below to change your password: " + resetPasswordLink
				+ " Change my password Ignore this email if you do remember your password, "
				+ "or you have not made the request.";
		utilities.sendEmail(email, message);
		return ResponseEntity.ok(new MessageResponse("check your mail to reset password!"));
	}

	@PostMapping("/newpassword/{token}/{pwd}")
	public ResponseEntity<?> changePassword(@Valid @PathVariable("token") String token,
			@Valid @PathVariable("pwd") String pwd) {
		userControlservice.updatePassword(pwd, token);
		return ResponseEntity.ok(new MessageResponse("password changed "));
	}

	@PostMapping("/verify/{email}")
	public ResponseEntity<?> requestverifyAccount(@Valid @PathVariable("email") String email, @RequestBody String url)
			throws UnsupportedEncodingException {
		try {
			String token = RandomString.make(30);
			String encodedValue = StringUtils.chop(URLDecoder.decode(url, "UTF-8"));
			String verfyLink = encodedValue + "/signup?token=" + token;
			String message = "Hello You have to verify your account by using this link."
					+ "Click the link below to verify your account: " + verfyLink;
			utilities.sendEmail(email, message);
			userControlservice.updateVerifyAccountToken(token, email);
			return ResponseEntity.ok(new MessageResponse("check your mail to verify account!"));
		} catch (AccountNotFoundException e) {
			return ResponseEntity.badRequest().body(new MessageResponse(e.getMessage()));

		}
	}

	@PostMapping("/verify_account/{token}")
	public void verifyAccount(@Valid @PathVariable("token") String token) {
		User user = userControlservice.getByVerifyAccountToken(token);
		if (user != null)
			userControlservice.verifiedUser(user);

	}

	@PostMapping("/upload")
	public String fileupload(@Valid @RequestParam("file") MultipartFile multipartFile) {
		return String.format("file %s uploaded sccessfully ", multipartFile.getOriginalFilename());

	}

	@PutMapping("/signupdraft/{token}")
	public ResponseEntity<?> registerUserDraftStep(@Valid @PathVariable("token") String token,
			@Valid @RequestBody SignUpDraft signUpRequest) {
		User userverified = userControlservice.getByVerifyAccountToken(token);
		if (userverified == null)
			return ResponseEntity.badRequest().body(new MessageResponse("Error: User doesn't verified!"));
		else {
			if (Boolean.TRUE.equals(userControlservice.retrieveUserByUserName(signUpRequest.getUsername())))
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
			else {
				User user = new User(userverified.getId(), signUpRequest.getUsername(), userverified.getEmail(),
						userverified.getStatus(), encoder.encode(signUpRequest.getPassword()),
						userverified.getVerifyAccountToken(), userverified.isEnabled(), userverified.isAdmin(),
						userverified.isVendor());
				Set<Role> roles = new HashSet<>();
				Role fournisseurRole = userControlservice.retrieveRoleByName(ERole.ROLE_FOURNISSEUR);
				roles.add(fournisseurRole);
				user.setRoles(roles);
				userControlservice.updateUser(user);
				return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
			}
		}
	}

	@GetMapping("/getNumberProfiles")
	public Long getNumberofRequests() {
		return requestUpdateProfileService.numberofRequest();

	}

	@GetMapping("/retrievestatusoneuserbyemail/{email}")
	public String retrieveStatusOneUserByEmail(@Valid @PathVariable("email") String email) {
		return userControlservice.retrieveStatusOneUserByEmail(email);

	}

}
