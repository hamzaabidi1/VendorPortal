package com.smartech.vendorportal.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.RequestProfile;
import com.smartech.vendorportal.entities.RequestUpdateProfile;
import com.smartech.vendorportal.repositories.RequestUpdateProfileRepository;

@Service
public class RequestUpdateProfileServiceImpl implements RequestUpdateProfileService {

	@Autowired
	RequestUpdateProfileRepository profileRepository;
	@Autowired
	Utilities utilities;
	
	@Override
	public List<RequestUpdateProfile> retriveAllRequestUpdateProfile() {
		return profileRepository.findAll();
	}

	@Override
	public void deleteRequestUpdateProfile(Long idRequest) {
		profileRepository.deleteById(idRequest);

	}

	@Override
	public RequestUpdateProfile updateUser(RequestUpdateProfile requestUpdateProfile) {
		return profileRepository.save(requestUpdateProfile);
	}

	@Override
	public RequestUpdateProfile retrieveOneUser(Long idRequest) {
		return profileRepository.findById(idRequest).get();
	}

	@Override
	public void addRequestUpdateProfile(RequestProfile requestProfile, String email) {

		RequestUpdateProfile requestUpdateProfile = new RequestUpdateProfile();
		requestUpdateProfile.setLastname(requestProfile.getLastname());
		requestUpdateProfile.setFirstname(requestProfile.getFirstname());
		requestUpdateProfile.setPhone(requestProfile.getPhone());
		requestUpdateProfile.setCountry(requestProfile.getCountry());
		requestUpdateProfile.setRegion(requestProfile.getRegion());
		requestUpdateProfile.setCity(requestProfile.getCity());
		requestUpdateProfile.setPostalcode(requestProfile.getPostalcode());
		requestUpdateProfile.setAddress(requestProfile.getAddress());
		requestUpdateProfile.setTaxregistrationnumber(requestProfile.getTaxregistrationnumber());
		requestUpdateProfile.setTaxclassificationcode(requestProfile.getTaxclassificationcode());
		requestUpdateProfile.setRevenu(requestProfile.getRevenu());
		requestUpdateProfile.setDateEstablished(requestProfile.getDateEstablished());
		requestUpdateProfile.setCompanywebsite(requestProfile.getCompanywebsite());
		requestUpdateProfile.setEmail(email);
		profileRepository.save(requestUpdateProfile);

	}

	@Override
	public void deleteRequestUpdateProfile(RequestUpdateProfile requestUpdateProfile) {
		String message="your request for upadting Account information has been refused";
		utilities.sendEmail(requestUpdateProfile.getEmail(), message);
		profileRepository.delete(requestUpdateProfile);

	}

	@Override
	public RequestUpdateProfile retrieveRequestUpdateProfileByUserName(String username) {
		return null;
	}

	@Override
	public RequestUpdateProfile retrieveRequestUpdateProfileByEmail(String email) {
		return profileRepository.findByEmail(email);
	}

	@Override
	public Long numberofRequest() {
		return profileRepository.count();
	}

	@Override
	public Boolean findRequestByEmail(String email) {
		if (profileRepository.findByEmail(email) == null) {
			return false;
		}
		return true;
	}

}
