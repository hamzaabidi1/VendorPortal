package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.Poterm;

@Repository
public interface PoTermRepository  extends JpaRepository <Poterm, Long> {
	

	@Query("SELECT p FROM Poterm p WHERE p.po.id =?1 ")
	List<Poterm> findAllPotermByUser(Long id);

}
