package com.smartech.vendorportal.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "users_history")
public class UserHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String address;
	private String city;
	private String region;
	private String postalcode;
	private String country;
	private String phone;
	@Enumerated(EnumType.STRING)
	private EStatus status;
	@Temporal(TemporalType.DATE)
	private Date dateEstablished;
	private String companywebsite;
	private String revenu;
	private String taxregistrationnumber;
	private String taxclassificationcode;
	private boolean isVendor;
	private boolean isAdmin;
	private String password;
	private boolean isEnabled;
	@Temporal(TemporalType.DATE)
	private Date statusDate;
	@ManyToOne
	@JoinColumn(name = "user_id")

	private User changedBy;

	public UserHistory(Long id, String firstname, String lastname, String username, String email, String address,
			String city, String region, String postalcode, String country, String phone, EStatus status,
			Date dateEstablished, String companywebsite, String revenu, String taxregistrationnumber,
			String taxclassificationcode, boolean isVendor, boolean isAdmin, String password, boolean isEnabled,
			Date statusDate, User changedBy) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.email = email;
		this.address = address;
		this.city = city;
		this.region = region;
		this.postalcode = postalcode;
		this.country = country;
		this.phone = phone;
		this.status = status;
		this.dateEstablished = dateEstablished;
		this.companywebsite = companywebsite;
		this.revenu = revenu;
		this.taxregistrationnumber = taxregistrationnumber;
		this.taxclassificationcode = taxclassificationcode;
		this.isVendor = isVendor;
		this.isAdmin = isAdmin;
		this.password = password;
		this.isEnabled = isEnabled;
		this.statusDate = statusDate;
		this.changedBy = changedBy;
	}

	public UserHistory() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public EStatus getStatus() {
		return status;
	}

	public void setStatus(EStatus status) {
		this.status = status;
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

	public boolean isVendor() {
		return isVendor;
	}

	public void setVendor(boolean isVendor) {
		this.isVendor = isVendor;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Date getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}

	public User getChangedBy() {
		return changedBy;
	}

	public void setChangedBy(User changedBy) {
		this.changedBy = changedBy;
	}

}
