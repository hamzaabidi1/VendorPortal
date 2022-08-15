package com.smartech.vendorportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Invoice;
import com.smartech.vendorportal.entities.InvoiceDto;
import com.smartech.vendorportal.entities.InvoiceLine;
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
		if (invoice.getInvoiceLine() != null) {

			for (int i = 0; i < invoice.getInvoiceLine().size(); i++) {
				invoiceLineRepository.save(invoice.getInvoiceLine().get(i));
			}
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

	@Override
	public Invoice InvoiceDtoToInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = new Invoice();

		invoice.setInvoicenum(invoiceDto.getInvoicenum());
		invoice.setDescription(invoiceDto.getDescription());
		invoice.setStatus(invoiceDto.getStatus());
		invoice.setTotalcost(invoiceDto.getTotalcost());
		invoice.setTotaltax1(invoiceDto.getTotaltax1());
		invoice.setCurrencycode(invoiceDto.getCurrencycode());
		invoice.setEnterby(invoiceDto.getEnterby());
		invoice.setEnterdate(invoiceDto.getEnterdate());
		List<InvoiceLine> invoicelinelist = new ArrayList<>();

		if (invoiceDto.getInvoiceline() != null) {

			for (int i = 0; i < invoiceDto.getInvoiceline().size(); i++) {

				InvoiceLine invoiceline = new InvoiceLine();
				invoiceline.setInvoicelinenum(invoiceDto.getInvoiceline().get(i).getInvoicelinenum());
				invoiceline.setItemnum(invoiceDto.getInvoiceline().get(i).getItemnum());
				invoiceline.setDescription(invoiceDto.getInvoiceline().get(i).getDescription());
				invoiceline.setQtyforui(invoiceDto.getInvoiceline().get(i).getQtyforui());
				invoiceline.setInvoiceunit(invoiceDto.getInvoiceline().get(i).getInvoiceunit());
				invoiceline.setUnitcost(invoiceDto.getInvoiceline().get(i).getUnitcost());
				invoiceline.setLinecost(invoiceDto.getInvoiceline().get(i).getLinecost());
				invoicelinelist.add(invoiceline);

			}

			invoice.setInvoiceLine(invoicelinelist);
		}
		return invoice;
	}

	@Override
	public void deleteAllInvoices() {

		invoiceRepository.deleteAll();
	}

}
