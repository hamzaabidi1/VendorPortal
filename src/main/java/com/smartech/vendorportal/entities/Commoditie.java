package com.smartech.vendorportal.entities;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class Commoditie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long commoditiesId;
	@Size(max = 50)
	private String description;
	private Long parentId;
	@OneToMany(mappedBy = "commoditie")
	Set<VendorCommodities> vendorCommodities;

	public Commoditie(Long commoditiesId, String description, Long parentId, Set<VendorCommodities> vendorCommodities) {
		super();
		this.commoditiesId = commoditiesId;
		this.description = description;
		this.parentId = parentId;
		this.vendorCommodities = vendorCommodities;
	}

	public Long getCommoditiesId() {
		return commoditiesId;
	}

	public void setCommoditiesId(Long commoditiesId) {
		this.commoditiesId = commoditiesId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Set<VendorCommodities> getVendorCommodities() {
		return vendorCommodities;
	}

	public void setVendorCommodities(Set<VendorCommodities> vendorCommodities) {
		this.vendorCommodities = vendorCommodities;
	}

}
