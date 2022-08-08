package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.PoLine;
import com.smartech.vendorportal.repositories.PoLineRepository;

@Service
public class PoLineServiceImpl implements PoLineService {
	@Autowired
	PoLineRepository poLineRepository;

	@Override
	public List<PoLine> retriveAllPoLine(Long poid) {
		return poLineRepository.findAllPoByUser(poid);
	}

	@Override
	public PoLine retrivePOLine(Long poLineid) {
		return poLineRepository.findById(poLineid).get();
	}

	@Override
	public void addPOLine(List<PoLine> poline) {
		for (int i = 0; i < poline.size(); i++)
			poLineRepository.save(poline.get(i));

	}

	@Override
	public PoLine updatePOLine(PoLine poline) {
		String poLinedate=poline.getVendeliverydate().substring(0, 10);
		poline.setVendeliverydate(poLinedate);
		return poLineRepository.save(poline);
	}

	@Override
	public void deleteAllPoLines() {
		poLineRepository.deleteAll();
	}

}
