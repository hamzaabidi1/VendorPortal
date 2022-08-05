package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Poterm;
import com.smartech.vendorportal.repositories.PoTermRepository;


@Service
public class PoTermServiceImpl implements PoTermService {

	@Autowired
	PoTermRepository poTermRepository;
	
	
	@Override
	public List<Poterm> retriveAllPoTerm(Long poid) {
		return poTermRepository.findAllPotermByUser(poid);
		
	}

	@Override
	public Poterm retrivePOTerm(Long poTermid) {
		return poTermRepository.findById(poTermid).get();
	}

	@Override
	public void addPOTerm(List<Poterm> poterm) {
		for (int i = 0; i < poterm.size(); i++)
			poTermRepository.save(poterm.get(i));
		
	}

	@Override
	public Poterm updatePOTerm(Poterm poterm) {
		return poTermRepository.save(poterm);
	}

	@Override
	public void deleteAllPoTerm() {
		poTermRepository.deleteAll();
		
	}

}
