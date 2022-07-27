package com.smartech.vendorportal.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "format")
public class FormatFile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9114251211001233304L;
	
	private String href;
	private String label;
	public FormatFile(String href, String label) {
		super();
		this.href = href;
		this.label = label;
	}
	public FormatFile() {
		super();
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
	
	
	
	

}
