package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Invoice;
import com.smartech.vendorportal.repositories.InvoiceLineRepository;
import com.smartech.vendorportal.repositories.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	InvoiceLineRepository invoiceLineRepository;

	@Override
	public List<Invoice> retriveAllInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice addInvoice(Invoice invoice) {
		for (int i = 0; i < invoice.getInvoiceLine().size(); i++) {
			invoiceLineRepository.save(invoice.getInvoiceLine().get(i));
		}
		return invoiceRepository.save(invoice);
	}

	@Override
	public void deleteInvoiceById(Long id) {
		invoiceRepository.deleteById(id);

	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice retrieveOneInvoiceById(Long id) {
		return invoiceRepository.findById(id).get();
	}

	@Override
	public List<Invoice> retriveAllInvoiceByUser(String email) {
		return invoiceRepository.findAllInvoiceByUser(email);
	}

}
