package com.smartech.vendorportal.entities;

public class InvoiceLineDto {
	private int invoicelinenum;
	private String itemnum;
	private String description;
	private double unitcost;
	private double linecost;
	private double qtyforui;
	private String invoiceunit;

	public InvoiceLineDto(int invoicelinenum, String itemnum, String description, double unitcost, double linecost,
			double qtyforui, String invoiceunit) {
		super();
		this.invoicelinenum = invoicelinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.qtyforui = qtyforui;
		this.invoiceunit = invoiceunit;

	}

	public InvoiceLineDto() {
		super();
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

}
