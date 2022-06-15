package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.InvoiceLine;
import com.smartech.vendorportal.repositories.InvoiceLineRepository;

@Service
public class InvoiceLineServiceImpl implements InvoiceLineService {
	
	
	@Autowired
	InvoiceLineRepository invoiceLineRepository;

	@Override
	public List<InvoiceLine> retriveAllInvoiceLine(Long poid) {
		return invoiceLineRepository.findAllInvoiceByUser(poid);
	}

	@Override
	public InvoiceLine retriveInvoiceLine(Long invoiceLineid) {
		return invoiceLineRepository.findById(invoiceLineid).get();
	}

	@Override
	public void addInvoiceLine(List<InvoiceLine> invoiceLine) {
		for (int i=0;i<invoiceLine.size();i++)
			invoiceLineRepository.save(invoiceLine.get(i));
		
	}

	@Override
	public InvoiceLine updateInvoiceLine(InvoiceLine invoiceLine) {
		return invoiceLineRepository.save(invoiceLine);
	}
	

}
