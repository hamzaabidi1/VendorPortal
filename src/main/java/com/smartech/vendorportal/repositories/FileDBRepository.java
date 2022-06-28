package com.smartech.vendorportal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.FileDB;



@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
