package com.smartech.vendorportal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.smartech.vendorportal.entities.InvoiceLine;

@Repository
public interface InvoiceLineRepository extends JpaRepository <InvoiceLine, Long> {
	
	
	@Query("SELECT i FROM InvoiceLine i WHERE i.invoice.id =?1 ")
	List<InvoiceLine> findAllInvoiceByUser(Long id);

}
