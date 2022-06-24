package com.smartech.vendorportal.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RfqLineDto {
	@JsonProperty("rfqlinenum")
	private String rfqlinenum;
	@JsonProperty("cost")
	private double unitcost;
	@JsonProperty("quantity")
	private double quotationqty;
	@JsonProperty("QUOTESTARTDATE")
	private String quoteStartDate;
	@JsonProperty("QUOTEENDDATE")
	private String quoteEndDate;
	@JsonProperty("DELIVERYDATE")
	private String delivryDate;

	public RfqLineDto(String rfqlinenum ,
			double unitcost, double linecost,double quotationqty,String quoteStartDate,String quoteEndDate, String delivryDate) {
		super();
		this.rfqlinenum = rfqlinenum;
		this.unitcost = unitcost;
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



	public double getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(double unitcost) {
		this.unitcost = unitcost;
	}

	public double getQuotationqty() {
		return quotationqty;
	}

	public void setQuotationqty(double quotationqty) {
		this.quotationqty = quotationqty;
	}

	public String getQuoteStartDate() {
		return quoteStartDate;
	}

	public void setQuoteStartDate(String quoteStartDate) {
		this.quoteStartDate = quoteStartDate;
	}

	public String getQuoteEndDate() {
		return quoteEndDate;
	}

	public void setQuoteEndDate(String quoteEndDate) {
		this.quoteEndDate = quoteEndDate;
	}

	public String getDelivryDate() {
		return delivryDate;
	}

	public void setDelivryDate(String delivryDate) {
		this.delivryDate = delivryDate;
	}
	
	

}
