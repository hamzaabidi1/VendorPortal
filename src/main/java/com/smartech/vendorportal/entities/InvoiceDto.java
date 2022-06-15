package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "member")

public class InvoiceDto implements Serializable {

	private static final long serialVersionUID = -2146345748651989302L;

	private String invoicenum;
	private String description;
	private String status;
	private double totalcost;
	private double totaltax1;
	private String currencycode;
	private String enterby;
	private String enterdate;
	private List<InvoiceLineDto> invoiceline;

	public InvoiceDto(String invoicenum, String description, String status, double totalcost, double totaltax1,
			String currencycode, String enterby, String enterdate, List<InvoiceLineDto> invoiceline) {
		super();
		this.invoicenum = invoicenum;
		this.description = description;
		this.status = status;
		this.totalcost = totalcost;
		this.totaltax1 = totaltax1;
		this.currencycode = currencycode;
		this.invoiceline = invoiceline;
		this.enterby = enterby;
		this.enterdate = enterdate;

	}

	public InvoiceDto() {
		super();
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

	public List<InvoiceLineDto> getInvoiceline() {
		return invoiceline;
	}

	public void setInvoiceline(List<InvoiceLineDto> invoiceline) {
		this.invoiceline = invoiceline;
	}

}