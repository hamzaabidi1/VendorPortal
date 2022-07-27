package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class FileExchangeMaximoDto implements Serializable {

	private static final long serialVersionUID = -5442111625992157455L;
	private String href;
	private List<fileExchange> member;
	
	
	public FileExchangeMaximoDto(String href, List<fileExchange> member) {
		super();
		this.href = href;
		this.member = member;
	}
	
	


	public FileExchangeMaximoDto() {
		super();
	}




	public String getHref() {
		return href;
	}


	public void setHref(String href) {
		this.href = href;
	}


	public List<fileExchange> getMember() {
		return member;
	}


	public void setMember(List<fileExchange> member) {
		this.member = member;
	}
	
	
	
	
	
	

}
