package com.smartech.vendorportal.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(max = 50)
	private String firstname;
	@Size(max = 50)
	private String lastname;
	@Size(max = 20)
	private String username;
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
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private EStatus status;
	@Temporal(TemporalType.DATE)
	private Date dateEstablished;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Size(max = 50)
	private String companywebsite;
	@Size(max = 50)
	private String revenu;
	private String taxregistrationnumber;
	private String taxclassificationcode;
	private boolean isVendor;
	private boolean isAdmin;
	@Size(max = 120)
	private String password;
	private boolean isEnabled;
	private String verifyAccountToken;
	private String resetPasswordToken;
	private String langue;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	@OneToMany(mappedBy = "user")
	Set<VendorCommodities> vendorCommodities;
	@OneToMany
	@JoinColumn(name = "user_id")
	Set<UserHistory> userHistory;
	
	@OneToMany
	@JoinColumn(name = "user_id")
	Set<Rfq> rfqs;
	
	
	@OneToMany
	@JoinColumn(name = "user_id")
	Set<Po> pos;


	public User() {
	}

	public User(Long id, String firstName, String lastName, String username, String email, String adresse, String ville,
			String dptProvinance, String codePostal, String pays, String phone, boolean isVendor, boolean isAdmin,
			boolean isEnabled, String password, EStatus status, String taxRegistrationNumber,
			String taxClassificationCode, String webSite, String revenu, Date dateEstablished,
			String verifyAccountToken, Date dateCreation,String langue) {
		super();
		this.id = id;
		this.firstname = firstName;
		this.lastname = lastName;
		this.username = username;
		this.email = email;
		this.address = adresse;
		this.city = ville;
		this.region = dptProvinance;
		this.postalcode = codePostal;
		this.country = pays;
		this.phone = phone;
		this.isVendor = isVendor;
		this.isAdmin = isAdmin;
		this.isEnabled = isEnabled;
		this.password = password;
		this.status = status;
		this.taxclassificationcode = taxClassificationCode;
		this.taxregistrationnumber = taxRegistrationNumber;
		this.dateEstablished = dateEstablished;
		this.revenu = revenu;
		this.companywebsite = webSite;
		this.verifyAccountToken = verifyAccountToken;
		this.dateCreation = dateCreation;
		this.langue=langue;
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public User(Long id, @Size(max = 20) String username, @Size(max = 50) @Email String email, EStatus status,
			@Size(max = 120) String password, String verifyAccountToken, boolean isEnabled, boolean isAdmin,
			boolean isVendor) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.status = status;
		this.password = password;
		this.verifyAccountToken = verifyAccountToken;
		this.isEnabled = isEnabled;
		this.isVendor = isVendor;
		this.isAdmin = isAdmin;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRevenu() {
		return revenu;
	}

	public void setRevenu(String revenu) {
		this.revenu = revenu;
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

	public String getVerifyAccountToken() {
		return verifyAccountToken;
	}

	public void setVerifyAccountToken(String verifyAccountToken) {
		this.verifyAccountToken = verifyAccountToken;
	}

	public String getResetPasswordToken() {
		return resetPasswordToken;
	}

	public void setResetPasswordToken(String resetPasswordToken) {
		this.resetPasswordToken = resetPasswordToken;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<VendorCommodities> getVendorCommodities() {
		return vendorCommodities;
	}

	public void setVendorCommodities(Set<VendorCommodities> vendorCommodities) {
		this.vendorCommodities = vendorCommodities;
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

	public String getCompanywebsite() {
		return companywebsite;
	}

	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
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

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

}
