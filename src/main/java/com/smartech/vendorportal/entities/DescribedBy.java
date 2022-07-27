package com.smartech.vendorportal.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "describedBy")
public class DescribedBy  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1546734983117401586L;
	
	
	@JsonProperty("identifier")
	private String identifier;
	@JsonProperty("fileName")
	private String fileName;
	@JsonProperty("format")
	private FormatFile format;
	
	
	public DescribedBy(String identifier, String fileName) {
		super();
		this.identifier = identifier;
		this.fileName = fileName;
	}
	public DescribedBy() {
		super();
	}

	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public FormatFile getFormat() {
		return format;
	}
	public void setFormat(FormatFile format) {
		this.format = format;
	}
	
	
	
	
	
	

}
