package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MaximoRequestList implements Serializable {
	
	private static final long serialVersionUID = 1399485261610473000L;
	private List<MaximoRequest> member;
	private Object responseInfo;
	private String href;

	public MaximoRequestList(List<MaximoRequest> member, Object responseInfo, String href) {
		super();
		this.member = member;
		this.responseInfo = responseInfo;
		this.href = href;
	}

	public MaximoRequestList() {
	}

	public List<MaximoRequest> getMember() {
		return member;
	}

	public void setMember(List<MaximoRequest> member) {
		this.member = member;
	}

	public Object getResponseInfo() {
		return responseInfo;
	}

	public void setResponseInfo(Object responseInfo) {
		this.responseInfo = responseInfo;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}
