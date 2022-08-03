package com.smartech.vendorportal.entities;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName(value = "member")
public class MaximoUpdatePo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9025616120356705964L;
	
	private PoLineUpdate poline;

	public MaximoUpdatePo(PoLineUpdate poline) {
		super();
		this.poline = poline;
	}

	public MaximoUpdatePo() {
		super();
	}

	public PoLineUpdate getPoline() {
		return poline;
	}

	public void setPoline(PoLineUpdate poline) {
		this.poline = poline;
	}
	
	
	
	
	 		

	
	

}
