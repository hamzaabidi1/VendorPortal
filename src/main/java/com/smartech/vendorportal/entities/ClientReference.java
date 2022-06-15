package com.smartech.vendorportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table
public class ClientReference {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientReferenceId;
	@Size(max = 50)
	private String company;
	@Size(max = 50)
	private String contactPerson;
	@Size(max = 50)
	private String phone;
	@Size(max = 50)
	private String email;

	public ClientReference(Long clientReferenceId, String company, String contactPerson, String phone, String email) {
		super();
		this.clientReferenceId = clientReferenceId;
		this.company = company;
		this.contactPerson = contactPerson;
		this.phone = phone;
		this.email = email;
	}

	public Long getClientReferenceId() {
		return clientReferenceId;
	}

	public void setClientReferenceId(Long clientReferenceId) {
		this.clientReferenceId = clientReferenceId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
