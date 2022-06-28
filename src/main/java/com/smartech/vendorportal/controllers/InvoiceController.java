package com.smartech.vendorportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartech.vendorportal.entities.Invoice;
import com.smartech.vendorportal.entities.InvoiceLine;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.InvoiceLineService;
import com.smartech.vendorportal.services.InvoiceService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;
	@Autowired
	UserControl userControl;
	@Autowired
	InvoiceLineService invoiceLineService;

	@PostMapping("/addinvoice/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Invoice addInvoice(@RequestBody Invoice invoice, @PathVariable("email") String email) {
		User user = userControl.retrieveOneUserByEmail(email);
		invoice.setUser(user);
		return invoiceService.addInvoice(invoice);

	}

	@GetMapping("/Getinvoice/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<Invoice> getAllInvoice(@PathVariable("email") String email) {
		return invoiceService.retriveAllInvoiceByUser(email);

	}

	@GetMapping("/Getinvoicedetails/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Invoice getInvoiceDetails(@PathVariable("id") Long id) {
		return invoiceService.retrieveOneInvoiceById(id);

	}

	@GetMapping("/GetInvoiceLines/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<InvoiceLine> getInvoiceLines(@PathVariable("id") Long id) {
		return invoiceLineService.retriveAllInvoiceLine(id);

	}

	@GetMapping("/GetInvoiceLine/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public InvoiceLine getInvoiceLineByid(@PathVariable("id") Long id) {
		return invoiceLineService.retriveInvoiceLine(id);

	}

	@PutMapping("/updateinvoiceLine")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public InvoiceLine updateInvoiceLineByid(@RequestBody InvoiceLine invoiceline) {
		return invoiceLineService.updateInvoiceLine(invoiceline);

	}

}
