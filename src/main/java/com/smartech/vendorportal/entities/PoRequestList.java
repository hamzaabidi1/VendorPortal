package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PoRequestList implements Serializable {

	private static final long serialVersionUID = 5539274907009391996L;
	private List<PoDto> member;
	private Object responseInfo;
	private String href;

	public PoRequestList(List<PoDto> member, Object responseInfo, String href) {
		super();
		this.member = member;
		this.responseInfo = responseInfo;
		this.href = href;
	}

	public PoRequestList() {
	}

	public List<PoDto> getMember() {
		return member;
	}

	public void setMember(List<PoDto> member) {
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
