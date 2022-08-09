package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smartech.vendorportal.entities.RfqLine;
import com.smartech.vendorportal.repositories.RfqLineRepository;

@Service
public class RfqLineServiceImpl implements RfqLineService {

	@Autowired
	RfqLineRepository rfqLineRepository;

	@Override
	public void addRFQLine(List<RfqLine> rfqline) {
		for (int i = 0; i < rfqline.size(); i++)
			rfqLineRepository.save(rfqline.get(i));

	}

	@Override
	public List<RfqLine> retriveAllRfqLine(Long rfqid) {
		return rfqLineRepository.findAllRfqByUser(rfqid);
	}

	@Override
	public RfqLine retriveRfqLine(Long rfqLineid) {

		return rfqLineRepository.findById(rfqLineid).get();
	}

	@Override
	public RfqLine updateRFQLine(RfqLine rfqline) {

		return rfqLineRepository.save(rfqline);
	}

	@Override
	public void DeleteById(Long id) {
		rfqLineRepository.deleteById(id);
		
	}

	
}
