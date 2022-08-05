package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.Poterm;

public interface PoTermService {
	
	List<Poterm> retriveAllPoTerm(Long poid);
	Poterm retrivePOTerm(Long poTermid);
	void addPOTerm(List<Poterm> poterm);
	Poterm updatePOTerm( Poterm poterm);
	void deleteAllPoTerm();

}
