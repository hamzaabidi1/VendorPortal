package com.smartech.vendorportal.services;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.smartech.vendorportal.entities.ERole;
import com.smartech.vendorportal.entities.EStatus;
import com.smartech.vendorportal.entities.MaximoRequest;
import com.smartech.vendorportal.entities.Role;
import com.smartech.vendorportal.entities.User;

public interface UserControl {
	List<User> retriveAllUser();

	void deleteUser(Long idUser, String email);

	User updateUser(User user);

	User retrieveOneUser(Long idUser);

	void addUser(User user);

	void deleteUser(User user);

	Role retrieveRoleByName(ERole erole);

	Boolean retrieveUserByUserName(String username);

	Boolean retrieveUserByEmail(String email);

	void updateResetPasswordToken(String token, String email) throws AccountNotFoundException;

	void updateVerifyAccountToken(String token, String email) throws AccountNotFoundException;

	User getByVerifyAccountToken(String token);

	void updatePassword(String newPassword, String token);

	void verifiedUser(User user);

	User updateUserToInProgress(User user, String email);

	User updateUserToConfirmed(User user, String email);

	List<User> findallUserInprogress();

	List<User> findallUserDraft();

	List<User> findallUserConfirmed();

	List<User> findallUserSubmitted();

	User retrieveOneUserByEmail(String email);

	String retrieveStatusOneUserByEmail(String email);

	List<User> retriveAllVendor();

	User updateStatusOfUser(User user, EStatus status, String email);

	MaximoRequest addUserToMaximo(Long idUser, String email);

	User getbyUserName(String username);

	void saveHistory(User user, String email, EStatus status);

	User updateUserfromRequest(String email);

	void deleteUnconfirmedUser();

	User checkUser(String password, String username);
	
	void updateUserPassword (String email,String password);
	
	public boolean checkUserfoundandconfirmed(String username);
}
