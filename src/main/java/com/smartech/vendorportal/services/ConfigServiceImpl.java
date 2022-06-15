package com.smartech.vendorportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.repositories.ConfigRepository;

@Service
public class ConfigServiceImpl  implements ConfigService{
	
	@Autowired
	ConfigRepository configRepository;

	@Override
	public List<Config> retriveAllConfig() {
		return configRepository.findAll();
	}


	@Override
	public Config updateConfig(Config config) {
		return configRepository.save(config);
	}
	
	

}
