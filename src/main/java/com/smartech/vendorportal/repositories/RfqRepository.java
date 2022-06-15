package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.smartech.vendorportal.entities.Rfq;


@Repository
public interface RfqRepository extends JpaRepository<Rfq, Long> {
	@Query("SELECT r FROM Rfq r WHERE r.user.email =?1 ")
	List<Rfq> findAllRfqByUser(String email);
}
