package com.smartech.vendorportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.RequestUpdateProfile;


@Repository
public interface RequestUpdateProfileRepository extends JpaRepository<RequestUpdateProfile, Long> {

	@Query("SELECT r FROM RequestUpdateProfile r WHERE r.email = ?1")
	RequestUpdateProfile findByEmail(String email);

}
