package com.smartech.vendorportal.controllers;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.smartech.vendorportal.entities.MaximoRequest;
import com.smartech.vendorportal.entities.MaximoRequestList;
import com.smartech.vendorportal.entities.RequestUpdateProfile;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.RequestUpdateProfileService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	@Value("${VendorPortal.app.header.key}")
	private String key;
	@Value("${VendorPortal.app.header.value}")
	private String value;
	@Value("${VendorPortal.app.urlmaximo}")
	private String maximourl;

	@Autowired
	RequestUpdateProfileService requestUpdateProfileService;
	@Autowired
	UserControl usercontrol;

	@GetMapping("/getProfiles")
	@PreAuthorize("hasRole('ADMIN')")
	public List<RequestUpdateProfile> getAllRequest() {
		return requestUpdateProfileService.retriveAllRequestUpdateProfile();

	}

	@RequestMapping("/requestUpdateProfile/{email}/{emailconnected}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateProfile(@Valid @PathVariable("email") String email,
			@Valid @PathVariable("emailconnected") String emailconnected) {
		User userForUpdate = usercontrol.updateUserfromRequest(email);
		RequestUpdateProfile request = requestUpdateProfileService.retrieveRequestUpdateProfileByEmail(email);
		MaximoRequest maximoRequest = usercontrol.addUserToMaximo(userForUpdate.getId(), emailconnected);
		RestTemplate restTemplate = new RestTemplate();
		// HttpHeaders
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
		// Request to return JSON format
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set(key, value);
		headers.set("x-method-override", "PATCH");
		headers.set("properties", "*");
		// Data attached to the request.
		HttpEntity<MaximoRequest> requestBody = new HttpEntity<>(maximoRequest, headers);
		HttpEntity<MaximoRequest> getBody = new HttpEntity<>(headers);
		String url = maximourl+"/maxrest/oslc/os/MXVENDOR?lean=1&oslc.select=*&_dropnulls=0&oslc.where=company=\""
				+ maximoRequest.getCompany() + "\"";
		ResponseEntity<MaximoRequestList> resultGet = restTemplate.exchange(url, HttpMethod.GET, getBody,
				MaximoRequestList.class);
		if (resultGet.getBody().getMember().get(0).getCompany() != null) {
			restTemplate.postForEntity(
					maximourl+"/maxrest/oslc/os/MXVENDOR/"
							+ resultGet.getBody().getMember().get(0).getCompaniesid() + "?lean=1",
					requestBody, MaximoRequest.class);
			requestUpdateProfileService.deleteRequestUpdateProfile(request.getId());
			return ResponseEntity.ok().body(true);
		}
		return ResponseEntity.ok().body(false);

	}

	@DeleteMapping("/deleterequest/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	// add send email
	public void deleteUser(@Valid @PathVariable("email") String email) {
		requestUpdateProfileService
				.deleteRequestUpdateProfile(requestUpdateProfileService.retrieveRequestUpdateProfileByEmail(email));
	}
	
	@GetMapping("/retrievevendor/{email}")
	@PreAuthorize("hasRole('ADMIN')")
	public RequestUpdateProfile findRequest(@PathVariable("email") String email) {
		return requestUpdateProfileService.retrieveRequestUpdateProfileByEmail(email);
	}

}
