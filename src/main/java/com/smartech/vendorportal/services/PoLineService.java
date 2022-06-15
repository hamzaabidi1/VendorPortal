package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.PoLine;

public interface PoLineService {
	
	List<PoLine> retriveAllPoLine(Long poid);
	PoLine retrivePOLine(Long poLineid);
	void addPOLine(List<PoLine> poline);
	PoLine updatePOLine( PoLine poline);

}
