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
@Table(name = "po_line")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class PoLine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	private String polinenum;
	private String itemnum;
	private String description;
	private String orderqty;
	private String orderunit;
	private String unitcost;
	private String linecost;
	private String vendeliverydate;
	
	@ManyToOne
	@JoinColumn(name = "po_id")
	private Po po;

	public PoLine(Long id, String polinenum, String itemnum, String description, String orderqty, String orderunit,
			String unitcost, String linecost,String vendeliverydate, Po po) {
		super();
		this.id = id;
		this.polinenum = polinenum;
		this.itemnum = itemnum;
		this.description = description;
		this.orderqty = orderqty;
		this.orderunit = orderunit;
		this.unitcost = unitcost;
		this.linecost = linecost;
		this.vendeliverydate=vendeliverydate;
		this.po = po;
	}

	public PoLine() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Po getPo() {
		return po;
	}

	public void setPo(Po po) {
		this.po = po;
	}
	
	
	

}
