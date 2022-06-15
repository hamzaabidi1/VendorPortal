package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RfqDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2146345748651989302L;
	@JsonProperty("RFQNUM")
	private String rfqnum;
	@JsonProperty("SITEID")
	private String siteid;
	@JsonProperty("VENDOR")
	private String vendor;
	private String description;
	private String status;
	private String requireddate;
	private String purchaseagent;
	private List<RfqLineDto> rfqline;
	
	public RfqDto(String rfqnum,String siteid,String vendor, String description, String status, String requireddate, String purchaseagent,
			List<RfqLineDto> rfqline) {
		super();
		this.rfqnum = rfqnum;
		this.siteid=siteid;
		this.vendor=vendor;
		this.description = description;
		this.status = status;
		this.requireddate = requireddate;
		this.purchaseagent = purchaseagent;
		this.rfqline = rfqline;
		
	}

	public RfqDto() {
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
	
	

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRequireddate() {
		return requireddate;
	}

	public void setRequireddate(String requireddate) {
		this.requireddate = requireddate;
	}

	public String getPurchaseagent() {
		return purchaseagent;
	}

	public void setPurchaseagent(String purchaseagent) {
		this.purchaseagent = purchaseagent;
	}

	public List<RfqLineDto> getRfqline() {
		return rfqline;
	}

	public void setRfqline(List<RfqLineDto> rfqline) {
		this.rfqline = rfqline;
	}

}
