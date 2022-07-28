package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class MaximoSendFileDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2995055957457898178L;
	
	
	private String rfqnum;
	private String siteid;
	private List<Docklinks> doclinks;
	
	
	public MaximoSendFileDto(String rfqnum, String siteid, List<Docklinks> doclinks) {
		super();
		this.rfqnum = rfqnum;
		this.siteid = siteid;
		this.doclinks = doclinks;
	}


	public MaximoSendFileDto() {
		super();
	}


	public String getRfqnum() {
		return rfqnum;
	}


	public void setRfqnum(String rfqnum) {
		this.rfqnum = rfqnum;
	}


	public String getSiteid() {
		return siteid;
	}


	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}


	public List<Docklinks> getDoclinks() {
		return doclinks;
	}


	public void setDoclinks(List<Docklinks> doclinks) {
		this.doclinks = doclinks;
	}
	
	
	
	
	

}
