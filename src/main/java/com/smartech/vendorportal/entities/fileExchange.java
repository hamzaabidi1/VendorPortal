package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "member")
public class fileExchange implements Serializable {
	
	private static final long serialVersionUID = 7147577405008213863L;
	
	private String href;
	private String localref;
	private DescribedBy describedBy;
	
	
	public fileExchange(String href, String localref, DescribedBy describedBy) {
		super();
		this.href = href;
		this.localref = localref;
		this.describedBy = describedBy;
	}
	
	
	


	public fileExchange() {
		super();
	}





	public String getHref() {
		return href;
	}


	public void setHref(String href) {
		this.href = href;
	}


	public String getLocalref() {
		return localref;
	}


	public void setLocalref(String localref) {
		this.localref = localref;
	}


	public DescribedBy getDescribedBy() {
		return describedBy;
	}


	public void setDescribedBy(DescribedBy describedBy) {
		this.describedBy = describedBy;
	}
	
	
	
	

}
