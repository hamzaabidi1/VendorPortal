package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.PoLine;


@Repository
public interface PoLineRepository extends JpaRepository <PoLine, Long> {
	
	
	@Query("SELECT p FROM PoLine p WHERE p.po.id =?1 ")
	List<PoLine> findAllPoByUser(Long id);

}
