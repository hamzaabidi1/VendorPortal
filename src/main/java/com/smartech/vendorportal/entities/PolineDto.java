package com.smartech.vendorportal.entities;

public class PolineDto {
	private int polinenum;
	private String itemnum;
	private String description;
	private Double orderqty;
	private String orderunit;
	private Double unitcost;
	private Double linecost;

	public PolineDto(int polinenum, String itemnum, String description, Double orderqty, String orderunit, Double unitcost,
			Double linecost) {
		super();
		this.polinenum = polinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
	}

	public PolineDto() {
		super();
	}

	public int getPolinenum() {
		return polinenum;
	}

	public void setPolinenum(int polinenum) {
		this.polinenum = polinenum;
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

}
