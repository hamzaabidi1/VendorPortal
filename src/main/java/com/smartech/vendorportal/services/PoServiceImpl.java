package com.smartech.vendorportal.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Po;
import com.smartech.vendorportal.entities.PoDto;
import com.smartech.vendorportal.entities.PoLine;
import com.smartech.vendorportal.entities.Poterm;
import com.smartech.vendorportal.repositories.PoLineRepository;
import com.smartech.vendorportal.repositories.PoRepository;
import com.smartech.vendorportal.repositories.PoTermRepository;

@Service
public class PoServiceImpl implements PoService {

	@Autowired
	PoRepository poRepository;
	@Autowired
	PoLineRepository poLineRepository;
	@Autowired
	PoTermRepository poTermRepository;

	@Override
	public List<Po> retriveAllPO() {
		return poRepository.findAll();
	}

	@Override
	public Po addPO(Po po) {
		for (int i = 0; i < po.getPoline().size(); i++) {
			poLineRepository.save(po.getPoline().get(i));
			
			
		}
		
		for (int i = 0; i < po.getPoterm().size(); i++) {
			poTermRepository.save(po.getPoterm().get(i));			
			
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
	@Override
	public Po poDtoToPo(PoDto poDto) {
		
		Po po = new Po();
		po.setPonum(poDto.getPonum());
		po.setDescription(poDto.getDescription());
		po.setStatus(poDto.getStatus());
		po.setRequireddate(poDto.getRequireddate());
		po.setTotalcost(poDto.getTotalcost());
		po.setTotaltax1(poDto.getTotaltax1());
		po.setCurrencycode(poDto.getCurrencycode());
		po.setPurchaseagent(poDto.getPurchaseagent());
		po.setVendeliverydate(poDto.getVendeliverydate());
		po.setPoid(poDto.getPoid());
		List<PoLine> polinelist=new ArrayList<>();
		for (int i =0 ;i<poDto.getPoline().size();i++) {
			
			PoLine poline=new PoLine();
			poline.setPolinenum(poDto.getPoline().get(i).getPolinenum());
			poline.setItemnum(poDto.getPoline().get(i).getItemnum());
			poline.setDescription(poDto.getPoline().get(i).getDescription());
			poline.setOrderqty(poDto.getPoline().get(i).getOrderqty());
			poline.setOrderunit(poDto.getPoline().get(i).getOrderunit());
			poline.setUnitcost(poDto.getPoline().get(i).getUnitcost());
			poline.setLinecost(poDto.getPoline().get(i).getLinecost());	
			poline.setVendeliverydate(poDto.getPoline().get(i).getVendeliverydate());	
			polinelist.add(poline);
			
		}
		List<Poterm> potermlist=new ArrayList<>();
		for (int i =0 ;i<poDto.getPoterm().size();i++) {
			
			Poterm poterm=new Poterm();
		
			poterm.setSeqnum(poDto.getPoterm().get(i).getSeqnum());
			poterm.setPotermid(poDto.getPoterm().get(i).getPotermid());
			poterm.setDescription(poDto.getPoterm().get(i).getDescription());
			poterm.setSendtovendor(poDto.getPoterm().get(i).getSendtovendor());
				
			potermlist.add(poterm);
			
		}
		po.setPoterm(potermlist);
		po.setPoline(polinelist);
	
		return po;
		
	}

	@Override
	public void deleteAllPos() {
		poRepository.deleteAll();		
	}

}
