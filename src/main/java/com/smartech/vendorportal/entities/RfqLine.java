package com.smartech.vendorportal.entities;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rfq_line")
public class RfqLine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5641460718074875004L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String rfqlinenum;
	private String itemnum;
	private String description;
	private Double orderqty;
	private String orderunit;
	private Double unitcost;
	private Double linecost;
	private Double quotationqty;
	private String quoteStartDate;
	private String quoteEndDate;
	private String delivryDate;
	@ManyToOne
	@JoinColumn(name = "rfq_id")
	private Rfq rfq;
	
	
	
	public RfqLine(Long id, String rfqlinenum, String itemnum, String description, Double orderqty, String orderunit,
			Double unitcost, Double linecost, Double quotationqty, String quoteStartDate, String quoteEndDate,
			String delivryDate) {
		super();
		this.id = id;
		this.rfqlinenum = rfqlinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.quotationqty = quotationqty;
		this.quoteStartDate = quoteStartDate;
		this.quoteEndDate = quoteEndDate;
		this.delivryDate = delivryDate;
	}
	public RfqLine(Long id, String rfqlinenum, String itemnum, String description, Double orderqty, String orderunit,
			Double unitcost, Double linecost, Double quotationqty, String quoteStartDate, String quoteEndDate,
			String delivryDate, Rfq rfq) {
		super();
		this.id = id;
		this.rfqlinenum = rfqlinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.quotationqty = quotationqty;
		this.quoteStartDate = quoteStartDate;
		this.quoteEndDate = quoteEndDate;
		this.delivryDate = delivryDate;
		this.rfq = rfq;
	}
	public RfqLine() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Double getOrderqty() {
		return orderqty;
	}
	public void setOrderqty(Double orderqty) {
		this.orderqty = orderqty;
	}
	public String getOrderunit() {
		return orderunit;
	}
	public void setOrderunit(String orderunit) {
		this.orderunit = orderunit;
	}
	public Double getUnitcost() {
		return unitcost;
	}
	public void setUnitcost(Double unitcost) {
		this.unitcost = unitcost;
	}
	public Double getLinecost() {
		return linecost;
	}
	public void setLinecost(Double linecost) {
		this.linecost = linecost;
	}
	public Double getQuotationqty() {
		return quotationqty;
	}
	public void setQuotationqty(Double quotationqty) {
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
	public Rfq getRfq() {
		return rfq;
	}
	public void setRfq(Rfq rfq) {
		this.rfq = rfq;
	}
	
	
	

}
