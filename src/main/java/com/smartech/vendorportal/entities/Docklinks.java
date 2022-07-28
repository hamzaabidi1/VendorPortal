package com.smartech.vendorportal.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "doclinks")
public class Docklinks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3413011120493423961L;
	
	
	private String  urltype;
	private String  documentdata;
	private String  doctype;
	private String  urlname;
	private String description;
	
	
	public Docklinks(String urltype, String documentdata, String doctype, String urlname, String description) {
		super();
		this.urltype = urltype;
		this.documentdata = documentdata;
		this.doctype = doctype;
		this.urlname = urlname;
		this.description = description;
	}
	public Docklinks() {
		super();
	}
	public String getUrltype() {
		return urltype;
	}
	public void setUrltype(String urltype) {
		this.urltype = urltype;
	}
	public String getDocumentdata() {
		return documentdata;
	}
	public void setDocumentdata(String documentdata) {
		this.documentdata = documentdata;
	}
	public String getDoctype() {
		return doctype;
	}
	public void setDoctype(String doctype) {
		this.doctype = doctype;
	}
	public String getUrlname() {
		return urlname;
	}
	public void setUrlname(String urlname) {
		this.urlname = urlname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	

}
