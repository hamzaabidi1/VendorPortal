package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Po;
import com.smartech.vendorportal.repositories.PoLineRepository;
import com.smartech.vendorportal.repositories.PoRepository;

@Service
public class PoServiceImpl implements PoService {

	@Autowired
	PoRepository poRepository;
	@Autowired
	PoLineRepository poLineRepository;

	@Override
	public List<Po> retriveAllPO() {
		return poRepository.findAll();
	}

	@Override
	public Po addPO(Po po) {
		for (int i = 0; i < po.getPoline().size(); i++) {
			poLineRepository.save(po.getPoline().get(i));
		}
		return poRepository.save(po);
	}

	@Override
	public void deletePOById(Long id) {
		poRepository.deleteById(id);

	}

	@Override
	public Po updatePO(Po po) {
		return poRepository.save(po);
	}

	@Override
	public Po retrieveOneById(Long id) {
		return poRepository.findById(id).get();
	}

	@Override
	public List<Po> retriveAllPOByUser(String email) {
		return poRepository.findAllPoByUser(email);
	}

}
