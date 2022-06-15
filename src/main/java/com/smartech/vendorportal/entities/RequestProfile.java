package com.smartech.vendorportal.entities;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class RequestProfile {

	@Size(max = 50)
	private String firstname;
	@Size(max = 50)
	private String lastname;
	@Size(max = 50)
	@Email
	private String email;
	@Size(max = 50)
	private String address;
	@Size(max = 50)
	private String city;
	@Size(max = 50)
	private String region;
	@Size(max = 50)
	private String postalcode;
	@Size(max = 50)
	private String country;
	@Size(max = 50)
	private String phone;
	@Temporal(TemporalType.DATE)
	private Date dateEstablished;
	@Size(max = 50)
	private String companywebsite;
	@Size(max = 50)
	private String revenu;
	private String taxregistrationnumber;
	private String taxclassificationcode;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDateEstablished() {
		return dateEstablished;
	}

	public void setDateEstablished(Date dateEstablished) {
		this.dateEstablished = dateEstablished;
	}

	public String getCompanywebsite() {
		return companywebsite;
	}

	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
	}

	public String getRevenu() {
		return revenu;
	}

	public void setRevenu(String revenu) {
		this.revenu = revenu;
	}

	public String getTaxregistrationnumber() {
		return taxregistrationnumber;
	}

	public void setTaxregistrationnumber(String taxregistrationnumber) {
		this.taxregistrationnumber = taxregistrationnumber;
	}

	public String getTaxclassificationcode() {
		return taxclassificationcode;
	}

	public void setTaxclassificationcode(String taxclassificationcode) {
		this.taxclassificationcode = taxclassificationcode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
