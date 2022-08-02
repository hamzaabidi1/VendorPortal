package com.smartech.vendorportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Config {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String email;
	private String password;
	private String maximopath;
	private String logpath;
	private String usermaximo;
	private String passwordmaximo;
	private String headerMaximo;
	private String organization;
	
	public Config(Long id, String email, String password, String maximopath, String logpath, String usermaximo,String passwordmaximo,String headerMaximo, String organization) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.maximopath = maximopath;
		this.logpath = logpath;
		this.usermaximo=usermaximo;
		this.passwordmaximo=passwordmaximo;
		this.headerMaximo=headerMaximo;
		this.organization=organization;
	}
	public Config() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMaximopath() {
		return maximopath;
	}
	public void setMaximopath(String maximopath) {
		this.maximopath = maximopath;
	}
	public String getLogpath() {
		return logpath;
	}
	public void setLogpath(String logpath) {
		this.logpath = logpath;
	}
	public String getUsermaximo() {
		return usermaximo;
	}
	public void setUsermaximo(String usermaximo) {
		this.usermaximo = usermaximo;
	}
	public String getPasswordmaximo() {
		return passwordmaximo;
	}
	public void setPasswordmaximo(String passwordmaximo) {
		this.passwordmaximo = passwordmaximo;
	}
	public String getHeaderMaximo() {
		return headerMaximo;
	}
	public void setHeaderMaximo(String headerMaximo) {
		this.headerMaximo = headerMaximo;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
	
	
	
	
	

}
