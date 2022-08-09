package com.smartech.vendorportal.services;


import java.util.List;


import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.RfqDto;

public interface RfqService {
	
	List<Rfq> retriveAllRFQ();
	Rfq addRFQ(Rfq rfq);
	void deleteRFQById(Long id);
	Rfq updateRFQ(Rfq rfq);
	Rfq retrieveOneById(Long id);
	List<Rfq> retriveAllRfqByUser(String email);
	public RfqDto addRfqTORfqDtomaximo(Long id);
	Rfq retrieveRfqByRfqNum(String rfqnum);

	
	

}
