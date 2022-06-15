package com.smartech.vendorportal.entities;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "member")

public class PoDto implements Serializable {

	private static final long serialVersionUID = -2146345748651989302L;

	private String ponum;
	private String description;
	private String status;
	private String requireddate;
	private String totalcost;
	private String totaltax1;
	private String currencycode;
	private String purchaseagent;
	private List<PolineDto> poline;

	public PoDto(String ponum, String description, String status, String requireddate, String totalcost, String totaltax1,
			String currencycode, String purchaseagent, List<PolineDto> poline) {
		super();
		this.ponum = ponum;
		this.description = description;
		this.status = status;
		this.requireddate = requireddate;
		this.totalcost = totalcost;
		this.totaltax1 = totaltax1;
		this.currencycode = currencycode;
		this.purchaseagent = purchaseagent;
		this.poline = poline;
	}

	public PoDto() {
		super();
	}

	public String getPonum() {
		return ponum;
	}

	public void setPonum(String ponum) {
		this.ponum = ponum;
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

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

	public String getTotaltax1() {
		return totaltax1;
	}

	public void setTotaltax1(String totaltax1) {
		this.totaltax1 = totaltax1;
	}

	public String getCurrencycode() {
		return currencycode;
	}

	public void setCurrencycode(String currencycode) {
		this.currencycode = currencycode;
	}

	public String getPurchaseagent() {
		return purchaseagent;
	}

	public void setPurchaseagent(String purchaseagent) {
		this.purchaseagent = purchaseagent;
	}

	public List<PolineDto> getPoline() {
		return poline;
	}

	public void setPoline(List<PolineDto> poline) {
		this.poline = poline;
	}

}
