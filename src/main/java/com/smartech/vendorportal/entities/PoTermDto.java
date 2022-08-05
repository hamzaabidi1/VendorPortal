package com.smartech.vendorportal.entities;

import java.io.Serializable;

public class PoTermDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8420626820429855348L;
	private String seqnum;
	private String potermid;
	private String description;
	private String sendtovendor;
	public PoTermDto(String seqnum, String potermid, String description, String sendtovendor) {
		super();
		this.seqnum = seqnum;
		this.potermid = potermid;
		this.description = description;
		this.sendtovendor = sendtovendor;
	}
	public PoTermDto() {
		super();
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
	
	

}
