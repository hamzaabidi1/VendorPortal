package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>{
	

	@Query("SELECT i FROM Invoice i WHERE i.user.email =?1 ")
	List<Invoice> findAllInvoiceByUser(String email);

}
