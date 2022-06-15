package com.smartech.vendorportal.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	
	@Query("SELECT u FROM User u WHERE u.password = ?1 and u.username= ?2")
	User checkUser(String password,String username);

	User findByResetPasswordToken(String token);

	User findByVerifyAccountToken(String token);

	@Query("SELECT u FROM User u WHERE u.status = 'InProgress'")
	List<User> findAllUserInProgress();

	@Query("SELECT u FROM User u WHERE u.status = 'Confirmed'")
	List<User> findAllUserConfirmed();

	@Query("SELECT u FROM User u WHERE u.status = 'Draft'")
	List<User> findAllUserDraft();

	@Query("FROM User u WHERE u.status = 'Submitted'")
	List<User> findAllUserSubmitted();

	@Query(value = "select * from users u join user_roles ur on u.id=ur.user_id join roles r on r.id=ur.role_id where r.name='ROLE_FOURNISSEUR'", nativeQuery = true)
	List<User> findAllVendors();
}