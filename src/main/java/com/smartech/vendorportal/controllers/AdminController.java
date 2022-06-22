package com.smartech.vendorportal.controllers;

import java.util.Arrays;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.smartech.vendorportal.entities.EStatus;
import com.smartech.vendorportal.entities.MaximoRequest;
import com.smartech.vendorportal.entities.MaximoRequestList;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.entities.UserHistory;
import com.smartech.vendorportal.services.UserControl;
import com.smartech.vendorportal.services.UserHistoryServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Value("${VendorPortal.app.header.key}")
	private String key;
	@Value("${VendorPortal.app.header.value}")
	private String value;
	@Value("${VendorPortal.app.urlmaximo}")
	private String maximourl;

	@Autowired
	UserControl usercontrol;
	@Autowired
	UserHistoryServiceImpl userHistoryServiceImpl;
	@Autowired
	MaximoRequestList maximoRequestList;

	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> retrieveAllUsers() {
		return usercontrol.retriveAllVendor();
	}

	@DeleteMapping("/delete/{idUser}/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteUser(@Valid @PathVariable("idUser") Long idUser, @Valid @PathVariable("email") String email) {
		usercontrol.deleteUser(idUser, email);
	}
	
	@GetMapping("/getvendor/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public User getVendorDetails(@PathVariable("email") String email) {
		return usercontrol.retrieveOneUserByEmail(email);
	}
	


	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/changestatus/{idUser}/{status}/{email}")
	public User changeStatus(@Valid @PathVariable("idUser") Long idUser, @Valid @PathVariable("status") EStatus status,
			@Valid @PathVariable("email") String email) {
		return usercontrol.updateStatusOfUser(usercontrol.retrieveOneUser(idUser), status, email);
	}

	@PutMapping("/confirm/{idUser}/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public User confirmOneUsers(@Valid @PathVariable("idUser") Long idUser,
			@Valid @PathVariable("email") String email) {
		return usercontrol.updateUserToConfirmed(usercontrol.retrieveOneUser(idUser), email);
	}

	@PostMapping("/inprogress/{idUser}/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public User inProgressOneUsers(@Valid @PathVariable("idUser") Long idUser,
			@Valid @PathVariable("email") String email) {
		return usercontrol.updateUserToInProgress(usercontrol.retrieveOneUser(idUser), email);
	}

	@GetMapping("/all/confirmed")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> retrieveAllConfirmedUsers() {
		return usercontrol.findallUserConfirmed();
	}

	@GetMapping("/all/inprogress")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> retrieveAllUsersInProgress() {
		return usercontrol.findallUserInprogress();
	}

	@GetMapping("/all/draft")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> retrieveAllDraftUsers() {
		return usercontrol.findallUserDraft();
	}

	@GetMapping("/all/submitted")
	@PreAuthorize("hasRole('ADMIN')")
	public List<User> retrieveAllSubmittedUsers() {
		return usercontrol.findallUserSubmitted();
	}

	@GetMapping("/all/history/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public List<UserHistory> retrieveAllUserHistory(@Valid @PathVariable("email") String email) {
		return userHistoryServiceImpl.retieveAllUserHistory(email);
	}

	@GetMapping("/allcompanies")
	@PreAuthorize("hasRole('ADMIN')")
	public String retrieveAllCompanies() {
		String url = maximourl+"/maxrest/oslc/os/MXVENDOR?lean=1&oslc.select=*&_dropnulls=0";
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, value);

		// HttpEntity<String>: To get result as String.
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		return response.getBody();
	}

	@RequestMapping("/addcompany/{idUser}/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> addCompany(@Valid @PathVariable("idUser") Long idUser,
			@Valid @PathVariable("email") String email)
			throws JsonMappingException, JsonProcessingException {
		MaximoRequest maximoRequest = usercontrol.addUserToMaximo(idUser, email);
		RestTemplate restTemplate = new RestTemplate();
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
	
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, value);
		headers.set("x-method-override", "PATCH");
		headers.set("properties", "*");
		
		
		HttpHeaders headersadd = new HttpHeaders();
		
		headersadd.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headersadd.setContentType(MediaType.APPLICATION_JSON);
		headersadd.set(key, value);
		headersadd.set("properties", "*");
		HttpEntity<MaximoRequest> addbody = new HttpEntity<>(maximoRequest, headersadd);
		// Data attached to the request.
		HttpEntity<MaximoRequest> requestBody = new HttpEntity<>(maximoRequest, headers);
		HttpEntity<MaximoRequest> getBody = new HttpEntity<>(headers);
		// send get method
		String url = maximourl+"/maxrest/oslc/os/MXVENDOR?lean=1&oslc.select=*&_dropnulls=0&oslc.where=company=\""
				+ maximoRequest.getCompany() + "\"";
		ResponseEntity<MaximoRequestList> resultGet = restTemplate.exchange(url, HttpMethod.GET, getBody,
				MaximoRequestList.class);
		if (resultGet.getBody().getMember().size() == 0) { // Send request with POST method.
			ResponseEntity<MaximoRequest> result = restTemplate.exchange(maximourl+"/maxrest/oslc/os/MXVENDOR?lean=1", HttpMethod.POST, addbody,
					MaximoRequest.class);
			System.out.println("Status code:" + result.getStatusCode());
			// Code = 201.
			if (result.getStatusCode() == HttpStatus.CREATED) {
				System.out.println("(Client Side) Vendor Created: ");
				return ResponseEntity.ok().body(true);
			}
		} else { 
			Long s=resultGet.getBody().getMember().get(0).getCompaniesid();
			ResponseEntity<MaximoRequest> result = restTemplate.exchange(maximourl+"/maxrest/oslc/os/MXVENDOR/"+s+"?lean=1", HttpMethod.POST, requestBody,
					MaximoRequest.class);
			System.out.println("Status code:" + result.getStatusCode());
			// Code = 200.
			if (result.getStatusCode() == HttpStatus.OK) {
				System.out.println("(Client Side) Vendor Updated: ");
				return ResponseEntity.ok().body(true);
			}
		}
		return ResponseEntity.ok().body(true);

	}

}
