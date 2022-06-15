package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.UserHistory;
import com.smartech.vendorportal.repositories.UserHistoryRepository;

@Service
public class UserHistoryServiceImpl implements UserHistoryService {

	@Autowired
	UserHistoryRepository userHistoryRepository;

	@Override
	public List<UserHistory> retriveAllUserHistory() {
		return userHistoryRepository.findAll();
	}

	@Override
	public void deleteUserHistory(Long idUser) {
		userHistoryRepository.deleteById(idUser);
	}

	@Override
	public UserHistory updateUser(UserHistory user) {
		return userHistoryRepository.save(user);
	}

	@Override
	public UserHistory retrieveOneUserHistory(Long idUser) {
		return userHistoryRepository.findById(idUser).get();
	}

	@Override
	public void addUserHistory(UserHistory user) {
		userHistoryRepository.save(user);
	}

	@Override
	public void deleteUserHistoryr(UserHistory user) {
		userHistoryRepository.delete(user);
	}

	@Override
	public List<UserHistory> retieveAllUserHistory(String email) {
		return userHistoryRepository.findByEmail(email);
	}

}
