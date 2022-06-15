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
@Table(name = "pos")
public class Po {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ponum;
	private String description;
	private String status;
	private String requireddate;
	private String totalcost;
	private String totaltax1;
	private String currencycode;
	private String purchaseagent;
	private String vendeliverydate;
	
	@OneToMany
	@JoinColumn(name = "po_id")
	List<PoLine> poline;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;


	public Po(Long id, String ponum, String description, String status, String requireddate, String totalcost,
			String totaltax1, String currencycode, String purchaseagent,String vendeliverydate, List<PoLine> poline, User user) {
		super();
		this.id = id;
		this.ponum = ponum;
		this.description = description;
		this.status = status;
		this.requireddate = requireddate;
		this.totalcost = totalcost;
		this.totaltax1 = totaltax1;
		this.currencycode = currencycode;
		this.purchaseagent = purchaseagent;
		this.vendeliverydate=vendeliverydate;
		this.poline = poline;
		this.user = user;
	}


	public Po() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getPonum() {
		return ponum;
	}


	public void setPonum(String ponum) {
		this.ponum = ponum;
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


	public String getRequireddate() {
		return requireddate;
	}


	public void setRequireddate(String requireddate) {
		this.requireddate = requireddate;
	}


	public String getTotalcost() {
		return totalcost;
	}


	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}


	public String getTotaltax1() {
		return totaltax1;
	}


	public void setTotaltax1(String totaltax1) {
		this.totaltax1 = totaltax1;
	}


	public String getCurrencycode() {
		return currencycode;
	}


	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}


	public String getPurchaseagent() {
		return purchaseagent;
	}


	public void setPurchaseagent(String purchaseagent) {
		this.purchaseagent = purchaseagent;
	}


	public String getVendeliverydate() {
		return vendeliverydate;
	}


	public void setVendeliverydate(String vendeliverydate) {
		this.vendeliverydate = vendeliverydate;
	}


	public List<PoLine> getPoline() {
		return poline;
	}


	public void setPoline(List<PoLine> poline) {
		this.poline = poline;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	

}
