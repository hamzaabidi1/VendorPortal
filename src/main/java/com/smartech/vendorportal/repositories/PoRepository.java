package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.Po;

@Repository
public interface PoRepository extends JpaRepository<Po, Long>{
	
	@Query("SELECT p FROM Po p WHERE p.user.email =?1 ")
	List<Po> findAllPoByUser(String email);

}
