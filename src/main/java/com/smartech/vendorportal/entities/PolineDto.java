package com.smartech.vendorportal.entities;

public class PolineDto {
	private String polinenum;
	private String itemnum;
	private String description;
	private String orderqty;
	private String orderunit;
	private String unitcost;
	private String linecost;
	private String vendeliverydate;

	public PolineDto(String polinenum, String itemnum, String description, String orderqty, String orderunit, String unitcost,
			String linecost,String vendeliverydate) {
		super();
		this.polinenum = polinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.vendeliverydate=vendeliverydate;
	}

	public PolineDto() {
		super();
	}

	public String getPolinenum() {
		return polinenum;
	}

	public void setPolinenum(String polinenum) {
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

	public String getOrderqty() {
		return orderqty;
	}

	public void setOrderqty(String orderqty) {
		this.orderqty = orderqty;
	}

	public String getOrderunit() {
		return orderunit;
	}

	public void setOrderunit(String orderunit) {
		this.orderunit = orderunit;
	}

	public String getUnitcost() {
		return unitcost;
	}

	public void setUnitcost(String unitcost) {
		this.unitcost = unitcost;
	}

	public String getLinecost() {
		return linecost;
	}

	public void setLinecost(String linecost) {
		this.linecost = linecost;
	}

	public String getVendeliverydate() {
		return vendeliverydate;
	}

	public void setVendeliverydate(String vendeliverydate) {
		this.vendeliverydate = vendeliverydate;
	}
	
	

}
