package com.smartech.vendorportal.entities;

import java.util.Date;


public class RfqLineDto {

	private String rfqlinenum;
	private String itemnum;
	private String description;
	private double orderqty;
	private String orderunit;
	private double unitcost;
	private double linecost;	
	private double quotationqty;
	private Date quoteStartDate;
	private Date quoteEndDate;
	private Date delivryDate;

	public RfqLineDto(String rfqlinenum, String itemnum, String description, double orderqty, String orderunit,
			double unitcost, double linecost,double quotationqty,Date quoteStartDate,Date quoteEndDate, Date delivryDate) {
		super();
		this.rfqlinenum = rfqlinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.quotationqty=quotationqty;
		this.quoteStartDate=quoteStartDate;
		this.quoteEndDate=quoteEndDate;
		this.delivryDate=delivryDate;
	}

	public RfqLineDto() {
		super();
	}

	public String getRfqlinenum() {
		return rfqlinenum;
	}

	public void setRfqlinenum(String rfqlinenum) {
		this.rfqlinenum = rfqlinenum;
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

	public double getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(double orderqty) {
		this.orderqty = orderqty;
	}

	public String getOrderunit() {
		return orderunit;
	}

	public void setOrderunit(String orderunit) {
		this.orderunit = orderunit;
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

	public double getQuotationqty() {
		return quotationqty;
	}

	public void setQuotationqty(double quotationqty) {
		this.quotationqty = quotationqty;
	}

	public Date getQuoteStartDate() {
		return quoteStartDate;
	}

	public void setQuoteStartDate(Date quoteStartDate) {
		this.quoteStartDate = quoteStartDate;
	}

	public Date getQuoteEndDate() {
		return quoteEndDate;
	}

	public void setQuoteEndDate(Date quoteEndDate) {
		this.quoteEndDate = quoteEndDate;
	}

	public Date getDelivryDate() {
		return delivryDate;
	}

	public void setDelivryDate(Date delivryDate) {
		this.delivryDate = delivryDate;
	}
	
	

}
