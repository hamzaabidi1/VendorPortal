package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.Invoice;
import com.smartech.vendorportal.entities.InvoiceDto;
public interface InvoiceService {
	
	List<Invoice> retriveAllInvoice();
	Invoice addInvoice(Invoice invoice);
	void deleteInvoiceById(Long id);
	Invoice updateInvoice(Invoice invoice);
	Invoice retrieveOneInvoiceById(Long id);
	List<Invoice> retriveAllInvoiceByUser(String email);
	Invoice InvoiceDtoToInvoice(InvoiceDto invoice);
	void deleteAllInvoices();

}
