package com.smartech.vendorportal.entities;

public class PoLineUpdate {
	
	private String polinenum;
	private String vendeliverydate;
	
	public PoLineUpdate(String polinenum,String vendeliverydate) {
		this.polinenum = polinenum;
		this.vendeliverydate=vendeliverydate;
	}
	
	
	

	public PoLineUpdate() {
		super();
	}




	public String getPolinenum() {
		return polinenum;
	}

	public void setPolinenum(String polinenum) {
		this.polinenum = polinenum;
	}

	public String getVendeliverydate() {
		return vendeliverydate;
	}

	public void setVendeliverydate(String vendeliverydate) {
		this.vendeliverydate = vendeliverydate;
	}
	
	

}
