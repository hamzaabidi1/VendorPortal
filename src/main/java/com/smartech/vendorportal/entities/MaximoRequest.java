package com.smartech.vendorportal.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "member")
public class MaximoRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3632942779862913144L;
	@JsonProperty("companiesid")
	private Long companiesid;
	@JsonProperty("company")
	private String company;
	@JsonProperty("orgid")
	private String orgid;
	@JsonProperty("name")
	private String name;
	@JsonProperty("changeby")
	private String changeby;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("sm_pwemail")
	private String sm_pwemail;
	@JsonProperty("sm_country")
	private String sm_country;
	@JsonProperty("address1")
	private String address1;
	@JsonProperty("address2")
	private String address2;
	@JsonProperty("address3")
	private String address3;
	@JsonProperty("address4")
	private String address4;
	@JsonProperty("homepage")
	private String homepage;
	@JsonProperty("registration1")
	private String registration1;
	@JsonProperty("registration2")
	private String registration2;

	public MaximoRequest(String company, String orgid, String name, String changeby, String phone, String sm_pwemail,
			String sm_country, String address1, String address2, String address3, String address4, String homepage,
			String registration1, String registration2) {
		super();
		this.company = company;
		this.orgid = orgid;
		this.name = name;
		this.changeby = changeby;
		this.phone = phone;
		this.sm_pwemail = sm_pwemail;
		this.sm_country = sm_country;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.address4 = address4;
		this.homepage = homepage;
		this.registration1 = registration1;
		this.registration2 = registration2;

	}

	public MaximoRequest() {
		super();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChangeby() {
		return changeby;
	}

	public void setChangeby(String changeby) {
		this.changeby = changeby;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSm_pwemail() {
		return sm_pwemail;
	}

	public void setSm_pwemail(String sm_pwemail) {
		this.sm_pwemail = sm_pwemail;
	}

	public String getSm_country() {
		return sm_country;
	}

	public void setSm_country(String sm_country) {
		this.sm_country = sm_country;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getHomepage() {
		return homepage;
	}

	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}

	public String getRegistration1() {
		return registration1;
	}

	public void setRegistration1(String registration1) {
		this.registration1 = registration1;
	}

	public String getRegistration2() {
		return registration2;
	}

	public void setRegistration2(String registration2) {
		this.registration2 = registration2;
	}

	public Long getCompaniesid() {
		return companiesid;
	}

	public void setCompaniesid(Long companiesid) {
		this.companiesid = companiesid;
	}

}
