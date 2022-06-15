package com.smartech.vendorportal.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.entities.MessageResponse;
import com.smartech.vendorportal.services.ConfigService;
import com.smartech.vendorportal.utils.PropertiesCache;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/config")
public class ConfigController {
	

	@Autowired
	ConfigService configService;
	@Autowired
	PropertiesCache configProperties;
	
	@PutMapping("/update")
	public ResponseEntity<?> updateConfig(@RequestBody Config config) {
		try {
			configService.updateConfig(config);
			configProperties.writeToProperties(config);
		
			return ResponseEntity.ok(new MessageResponse("Config Updated successfully!"));
		}catch (Exception e)
		{
			 return ResponseEntity.badRequest().body(new MessageResponse("unexpected problems! "));
		}
		
	}
	

	@GetMapping("/get")
	public Config getConfig() {

			List<Config> configs=configService.retriveAllConfig();
			return configs.get(0);
					
		
	
		
	}
	

}
