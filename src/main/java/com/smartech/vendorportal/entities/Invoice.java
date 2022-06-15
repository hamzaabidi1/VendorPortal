package com.smartech.vendorportal.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
@Entity
@Table(name = "invoices")
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String invoicenum;
	private String description;
	private String status;
	private double totalcost;
	private double totaltax1;
	private String currencycode;
	private String enterby;
	private String enterdate;
	
	
	@OneToMany
	@JoinColumn(name = "invoice_id")
	List<InvoiceLine> invoiceLine;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public Invoice(Long id, String invoicenum, String description, String status, double totalcost, double totaltax1,
			String currencycode, String enterby, String enterdate, List<InvoiceLine> invoiceLine, User user) {
		super();
		this.id = id;
		this.invoicenum = invoicenum;
		this.description = description;
		this.status = status;
		this.totalcost = totalcost;
		this.totaltax1 = totaltax1;
		this.currencycode = currencycode;
		this.enterby = enterby;
		this.enterdate = enterdate;
		this.invoiceLine = invoiceLine;
		this.user = user;
	}


	public Invoice() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getInvoicenum() {
		return invoicenum;
	}


	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public double getTotalcost() {
		return totalcost;
	}


	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}


	public double getTotaltax1() {
		return totaltax1;
	}


	public void setTotaltax1(double totaltax1) {
		this.totaltax1 = totaltax1;
	}


	public String getCurrencycode() {
		return currencycode;
	}


	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}


	public String getEnterby() {
		return enterby;
	}


	public void setEnterby(String enterby) {
		this.enterby = enterby;
	}


	public String getEnterdate() {
		return enterdate;
	}


	public void setEnterdate(String enterdate) {
		this.enterdate = enterdate;
	}


	public List<InvoiceLine> getInvoiceLine() {
		return invoiceLine;
	}


	public void setInvoiceLine(List<InvoiceLine> invoiceLine) {
		this.invoiceLine = invoiceLine;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	

}
