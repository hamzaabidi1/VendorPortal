package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.UserHistory;

public interface UserHistoryService {
	List<UserHistory> retriveAllUserHistory();

	void deleteUserHistory(Long idUser);

	UserHistory updateUser(UserHistory user);

	UserHistory retrieveOneUserHistory(Long idUser);

	void addUserHistory(UserHistory user);

	void deleteUserHistoryr(UserHistory user);

	List<UserHistory> retieveAllUserHistory(String email);

}
