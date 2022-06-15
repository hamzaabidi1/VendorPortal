package com.smartech.vendorportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "VendorCommodities")
public class VendorCommodities {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorCommoditieId;
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "commoditie_id")
	private Commoditie commoditie;
	@Size(max = 30)
	private String type;

	public VendorCommodities(Long vendorCommoditieId, User user, Commoditie commoditie, String type) {
		super();
		this.vendorCommoditieId = vendorCommoditieId;
		this.user = user;
		this.commoditie = commoditie;
		this.type = type;
	}

	public Long getVendorCommoditieId() {
		return vendorCommoditieId;
	}

	public void setVendorCommoditieId(Long vendorCommoditieId) {
		this.vendorCommoditieId = vendorCommoditieId;
	}

	public User getVendor() {
		return user;
	}

	public void setVendor(User user) {
		this.user = user;
	}

	public Commoditie getCommoditie() {
		return commoditie;
	}

	public void setCommoditie(Commoditie commoditie) {
		this.commoditie = commoditie;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
