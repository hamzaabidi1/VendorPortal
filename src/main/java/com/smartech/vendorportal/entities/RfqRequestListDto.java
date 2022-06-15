package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RfqRequestListDto implements Serializable {


	private static final long serialVersionUID = -6521577291121700343L;
	private List<RfqDto> member;
	private Object responseInfo;
	private String href;

	public RfqRequestListDto(List<RfqDto> member, Object responseInfo, String href) {
		super();
		this.member = member;
		this.responseInfo = responseInfo;
		this.href = href;
	}

	public RfqRequestListDto() {
	}

	public List<RfqDto> getMember() {
		return member;
	}

	public void setMember(List<RfqDto> member) {
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
