package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.RfqLine;


public interface RfqLineService {
	
	List<RfqLine> retriveAllRfqLine(Long rfqid);
	RfqLine retriveRfqLine(Long rfqLineid);
	void addRFQLine(List<RfqLine> rfqline);
	 void updateRFQLine( RfqLine rfqline);
	 void deleteById(Long id);

}
