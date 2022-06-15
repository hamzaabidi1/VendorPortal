package com.smartech.vendorportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.smartech.vendorportal.entities.Po;
import com.smartech.vendorportal.entities.PoLine;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.PoLineService;
import com.smartech.vendorportal.services.PoService;
import com.smartech.vendorportal.services.UserControl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/po")
public class PoController {
	
	@Autowired
	PoService poService;
	@Autowired
	UserControl userControl;
	@Autowired
	PoLineService poLineService;
	
	
	@PostMapping("/addpo/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Po addPo(@RequestBody Po po ,@PathVariable("email") String email) {
		User user=userControl.retrieveOneUserByEmail(email);
		po.setUser(user);
		return poService.addPO(po);
		
	}
	
	

	@GetMapping("/GetPo/{email}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<Po> getAllPo(@PathVariable("email") String email) {
		return poService.retriveAllPOByUser(email);
		
	}
	
	@GetMapping("/GetPodetails/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public Po getPoDetails(@PathVariable("id") Long id) {
		return poService.retrieveOneById(id);
		
	}
	
	
	@GetMapping("/GetpoLines/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public List<PoLine> getPoLines(@PathVariable("id") Long id) {
		return poLineService.retriveAllPoLine(id);
		
	}
	
	@GetMapping("/GetpoLine/{id}")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public PoLine getPoLineByid(@PathVariable("id") Long id) {
		return poLineService.retrivePOLine(id);
		
	}

	@PutMapping("/updatepoLine")
	@PreAuthorize("hasRole('FOURNISSEUR')")
	public PoLine updatePoLineByid(@RequestBody PoLine poline) {
		return poLineService.updatePOLine(poline);
		
	}

}
