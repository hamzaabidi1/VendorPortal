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
@Table(name = "po_term")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Poterm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String seqnum;
	private String potermid;
	private String description;
	private String sendtovendor;
	@ManyToOne
	@JoinColumn(name = "po_id")
	private Po po;
	
	
	public Poterm(Long id, String seqnum, String potermid, String description, String sendtovendor, Po po) {
		super();
		this.id = id;
		this.seqnum = seqnum;
		this.potermid = potermid;
		this.description = description;
		this.sendtovendor = sendtovendor;
		this.po = po;
	}
	public Poterm() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSeqnum() {
		return seqnum;
	}
	public void setSeqnum(String seqnum) {
		this.seqnum = seqnum;
	}
	public String getPotermid() {
		return potermid;
	}
	public void setPotermid(String potermid) {
		this.potermid = potermid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSendtovendor() {
		return sendtovendor;
	}
	public void setSendtovendor(String sendtovendor) {
		this.sendtovendor = sendtovendor;
	}
	public Po getPo() {
		return po;
	}
	public void setPo(Po po) {
		this.po = po;
	}

	
	
	
	
	

}
