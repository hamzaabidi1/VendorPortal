package com.smartech.vendorportal.services;


import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.repositories.ConfigRepository;

@Service
public class ConfigServiceImpl implements ConfigService {

	@Autowired
	ConfigRepository configRepository;

	@Override
	public Config retriveAllConfig() {
		Config config= new Config();
		if (!configRepository.findAll().isEmpty())
			config = configRepository.findAll().get(0);
		return config;
	}

	@Override
	public Config updateConfig(Config config) {
		String originalInput =config.getUsermaximo()+":"+config.getPasswordmaximo();
		String header = Base64.getEncoder().encodeToString(originalInput.getBytes());
			config.setHeaderMaximo(header);
			return configRepository.save(config);
	}

}
