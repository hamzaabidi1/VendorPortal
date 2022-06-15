package com.smartech.vendorportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "invoice_line")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class InvoiceLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private int invoicelinenum;
	private String itemnum;
	private String description;
	private double unitcost;
	private double linecost;
	private double qtyforui;
	private String invoiceunit;
	
	
	@ManyToOne
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;


	public InvoiceLine(Long id, int invoicelinenum, String itemnum, String description, double unitcost,
			double linecost, double qtyforui, String invoiceunit, Invoice invoice) {
		super();
		this.id = id;
		this.invoicelinenum = invoicelinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.qtyforui = qtyforui;
		this.invoiceunit = invoiceunit;
		this.invoice = invoice;
	}


	public InvoiceLine() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getInvoicelinenum() {
		return invoicelinenum;
	}


	public void setInvoicelinenum(int invoicelinenum) {
		this.invoicelinenum = invoicelinenum;
	}


	public String getItemnum() {
		return itemnum;
	}


	public void setItemnum(String itemnum) {
		this.itemnum = itemnum;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getUnitcost() {
		return unitcost;
	}


	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}


	public double getLinecost() {
		return linecost;
	}


	public void setLinecost(double linecost) {
		this.linecost = linecost;
	}


	public double getQtyforui() {
		return qtyforui;
	}


	public void setQtyforui(double qtyforui) {
		this.qtyforui = qtyforui;
	}


	public String getInvoiceunit() {
		return invoiceunit;
	}


	public void setInvoiceunit(String invoiceunit) {
		this.invoiceunit = invoiceunit;
	}


	public Invoice getInvoice() {
		return invoice;
	}


	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
	
	
	

}
