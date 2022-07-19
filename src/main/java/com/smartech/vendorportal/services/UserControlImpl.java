package com.smartech.vendorportal.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.security.auth.login.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.ERole;
import com.smartech.vendorportal.entities.EStatus;
import com.smartech.vendorportal.entities.MaximoRequest;
import com.smartech.vendorportal.entities.RequestUpdateProfile;
import com.smartech.vendorportal.entities.Role;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.entities.UserHistory;
import com.smartech.vendorportal.repositories.RoleRepository;
import com.smartech.vendorportal.repositories.UserHistoryRepository;
import com.smartech.vendorportal.repositories.UserRepository;
import com.smartech.vendorportal.utils.TaskException;

@Service
public class UserControlImpl implements UserControl {
	@Value("${VendorPortal.app.vendor.org}")
	private String org;

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	Utilities utilities;

	@Autowired
	UserHistoryRepository userHistoryRepository;
	@Autowired
	RequestUpdateProfileService requestUpdateProfileService;

	public List<User> retriveAllUser() {
		return userRepository.findAll();
	}

	public List<User> retriveAllVendor() {
		return userRepository.findAllVendors();
	}

	public void addUser(User user) {
		userRepository.save(user);
	}

	public void deleteUser(Long idUser, String email) {
		if (!userRepository.findById(idUser).isPresent())
			throw new TaskException(HttpStatus.NOT_FOUND, "User Not Found!");
		saveHistory(userRepository.findById(idUser).get(), email, EStatus.Deleted);
		userRepository.deleteById(idUser);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	public User checkUser(String password, String username) {
		return userRepository.checkUser(password, username);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}

	public User retrieveOneUser(Long idUser) {
		if (!userRepository.findById(idUser).isPresent())
			throw new TaskException(HttpStatus.NOT_FOUND, "User Not Found!");
		return userRepository.findById(idUser).get();

	}

	public Role retrieveRoleByName(ERole erole) {
		return roleRepository.findByName(erole).get();
	}

	public Boolean retrieveUserByUserName(String username) {
		return userRepository.existsByUsername(username);
	}

	public Boolean retrieveUserByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	public void updateResetPasswordToken(String token, String email) throws AccountNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user != null) {
			userRepository.delete(user);
			user.setResetPasswordToken(token);
			userRepository.save(user);
		} else {
			throw new AccountNotFoundException("Could not find any user with the email " + email);
		}
	}

	public User getByVerifyAccountToken(String token) {
		return userRepository.findByVerifyAccountToken(token);
	}

	public void updatePassword(String newPassword, String token) {
		User user = userRepository.findByResetPasswordToken(token);
		try {
			if (user != null) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(newPassword);
				user.setPassword(encodedPassword);
				userRepository.save(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void updateUserPassword (String email,String newPassword) {
		User user= userRepository.findByEmail(email);
		
		try {
			if (user != null) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				String encodedPassword = passwordEncoder.encode(newPassword);
				user.setPassword(encodedPassword);
				userRepository.save(user);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

	public void updateVerifyAccountToken(String token, String email) throws AccountNotFoundException {
		User user = userRepository.findByEmail(email);
		Date date = new Date();
		if (user == null) {
			User newUser = new User();
			newUser.setEmail(email);
			newUser.setAdmin(false);
			newUser.setVendor(true);
			newUser.setEnabled(true);
			newUser.setDateCreation(date);
			newUser.setStatus(EStatus.Draft);
			newUser.setVerifyAccountToken(token);
			userRepository.save(newUser);
		} else {
			throw new AccountNotFoundException("user exists with this email " + email);
		}
	}

	public void verifiedUser(User user) {
		user.setEnabled(true);
		userRepository.save(user);
	}

	public User getbyUserName(String username) {
		if (!userRepository.findByUsername(username).isPresent())
			throw new TaskException(HttpStatus.NOT_FOUND, "User Not Found!");
		return userRepository.findByUsername(username).get();
	}

	public User updateUserToInProgress(User user, String email) {
		saveHistory(user, email, EStatus.InProgress);
		user.setStatus(EStatus.InProgress);
		String message = "your Account has been " + EStatus.InProgress;
		utilities.sendEmail(user.getEmail(), message);
		return userRepository.save(user);
	}

	public User updateUserToConfirmed(User user, String email) {
		saveHistory(user, email, EStatus.Confirmed);
		user.setStatus(EStatus.Confirmed);
		String message = "your Account has been " + EStatus.Confirmed;
		utilities.sendEmail(user.getEmail(), message);
		return userRepository.save(user);
	}

	public void saveHistory(User user, String email, EStatus status) {
		User createdBy = userRepository.findByEmail(email);
		Date date = java.sql.Timestamp.valueOf(LocalDateTime.now());
		UserHistory userHistory = new UserHistory(user.getId(), user.getFirstname(), user.getLastname(),
				user.getUsername(), user.getEmail(), user.getAddress(), user.getCity(), user.getRegion(),
				user.getPostalcode(), user.getCountry(), user.getPhone(), status, user.getDateEstablished(),
				user.getCompanywebsite(), user.getRevenu(), user.getTaxregistrationnumber(),
				user.getTaxclassificationcode(), user.isVendor(), user.isAdmin(), user.getPassword(), user.isEnabled(),
				date, createdBy);
		userHistoryRepository.save(userHistory);
	}

	public User updateStatusOfUser(User user, EStatus status, String email) {
		saveHistory(user, email, status);
		user.setStatus(status);
		String message = "your Account has been " + status + "";
		utilities.sendEmail(user.getEmail(), message);
		return userRepository.save(user);
	}

	public List<User> findallUserInprogress() {
		return userRepository.findAllUserInProgress();
	}

	public List<User> findallUserDraft() {
		return userRepository.findAllUserDraft();
	}

	public List<User> findallUserConfirmed() {
		return userRepository.findAllUserConfirmed();
	}

	public List<User> findallUserSubmitted() {
		return userRepository.findAllUserSubmitted();
	}

	public MaximoRequest addUserToMaximo(Long idUser, String email) {
		User createdBy = userRepository.findByEmail(email);
		User u = retrieveOneUser(idUser);
		return new MaximoRequest(u.getUsername(), org, u.getFirstname(), createdBy.getUsername(), u.getPhone(),
				u.getEmail(), u.getCountry(), u.getAddress(), u.getCity(), u.getRegion(), u.getPostalcode(),
				u.getCompanywebsite(), u.getTaxregistrationnumber(), u.getTaxclassificationcode());
	}

	@Override
	public User retrieveOneUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User updateUserfromRequest(String email) {
		User lastUserdetails = retrieveOneUserByEmail(email);
		RequestUpdateProfile requestUpdateProfile = requestUpdateProfileService
				.retrieveRequestUpdateProfileByEmail(email);
		lastUserdetails.setAddress(requestUpdateProfile.getAddress());
		lastUserdetails.setCity(requestUpdateProfile.getCity());
		lastUserdetails.setCompanywebsite(requestUpdateProfile.getCompanywebsite());
		lastUserdetails.setCountry(requestUpdateProfile.getCountry());
		lastUserdetails.setDateEstablished(requestUpdateProfile.getDateEstablished());
		lastUserdetails.setFirstname(requestUpdateProfile.getFirstname());
		lastUserdetails.setLastname(requestUpdateProfile.getLastname());
		lastUserdetails.setPhone(requestUpdateProfile.getPhone());
		lastUserdetails.setPostalcode(requestUpdateProfile.getPostalcode());
		lastUserdetails.setRegion(requestUpdateProfile.getRegion());
		lastUserdetails.setRevenu(requestUpdateProfile.getRevenu());
		lastUserdetails.setTaxclassificationcode(requestUpdateProfile.getTaxclassificationcode());
		lastUserdetails.setTaxregistrationnumber(requestUpdateProfile.getTaxregistrationnumber());
		String message = "your request of Update Account Information has been accepted";
		utilities.sendEmail(email, message);
		return updateUser(lastUserdetails);
	}

	@Override
	@Scheduled(cron = "0 0 0 * * *")
	public void deleteUnconfirmedUser() {
		try {
		List<User> userUnconfirmed = userRepository.findAllUserDraft();
		LocalDate today = LocalDate.now();
		LocalDate newdate = today.minusDays(5);
		for (int i = 0; i < userUnconfirmed.size(); i++) {
			if ((userUnconfirmed.get(i).getStatus().equals(EStatus.Draft)
					&& userUnconfirmed.get(i).getDateCreation().equals(java.sql.Date.valueOf(newdate)))
					|| (userUnconfirmed.get(i).getStatus().equals(EStatus.Submitted)
							&& userUnconfirmed.get(i).getDateCreation().equals(java.sql.Date.valueOf(newdate))))
				userRepository.delete(userUnconfirmed.get(i));
			String message = "your Account has been deleted cause it is not verified";
			utilities.sendEmail(userUnconfirmed.get(i).getEmail(), message);
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public String retrieveStatusOneUserByEmail(String email) {
		User user = userRepository.findByEmail(email);
		return user.getStatus().toString();
	}

}
