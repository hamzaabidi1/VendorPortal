package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {
	@Query("SELECT f FROM FileDB f WHERE f.rfq.id =?1 ")
	List<FileDB> getAllFilePerRfq(Long id);

}
