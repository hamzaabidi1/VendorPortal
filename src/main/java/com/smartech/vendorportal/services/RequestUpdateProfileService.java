package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.RequestProfile;
import com.smartech.vendorportal.entities.RequestUpdateProfile;

public interface RequestUpdateProfileService {
	List<RequestUpdateProfile> retriveAllRequestUpdateProfile();

	void deleteRequestUpdateProfile(Long idRequest);

	RequestUpdateProfile updateUser(RequestUpdateProfile requestUpdateProfile);

	RequestUpdateProfile retrieveOneUser(Long idRequest);

	void addRequestUpdateProfile(RequestProfile requestUpdateProfile, String email);

	void deleteRequestUpdateProfile(RequestUpdateProfile requestUpdateProfile);

	RequestUpdateProfile retrieveRequestUpdateProfileByUserName(String username);

	RequestUpdateProfile retrieveRequestUpdateProfileByEmail(String email);

	Long numberofRequest();

	Boolean findRequestByEmail(String email);

}
