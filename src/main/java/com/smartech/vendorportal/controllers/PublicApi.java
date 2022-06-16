package com.smartech.vendorportal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartech.vendorportal.entities.Rfq;
import com.smartech.vendorportal.entities.User;
import com.smartech.vendorportal.services.RfqLineService;
import com.smartech.vendorportal.services.RfqService;
import com.smartech.vendorportal.services.UserControl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/public/Rfq")
public class PublicApi {
	@Autowired
	RfqService rfqService;
	@Autowired
	UserControl userControl;
	@Autowired
	RfqLineService rfqLineService;
	
	
	@PostMapping("/addRfq/{email}")
	public Rfq addRfq(@RequestBody Rfq rfq,@PathVariable("email") String email) {
		User user=userControl.retrieveOneUserByEmail(email);
		rfq.setUser(user);
		return rfqService.addRFQ(rfq);
		
	}

}
