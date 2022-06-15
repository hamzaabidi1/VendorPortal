package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.InvoiceLine;

public interface InvoiceLineService {
	
	List<InvoiceLine> retriveAllInvoiceLine(Long poid);
	InvoiceLine retriveInvoiceLine(Long invoiceLineid);
	void addInvoiceLine(List<InvoiceLine> invoiceLine);
	InvoiceLine updateInvoiceLine( InvoiceLine invoiceLine);

}
