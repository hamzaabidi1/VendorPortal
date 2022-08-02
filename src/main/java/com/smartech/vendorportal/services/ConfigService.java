package com.smartech.vendorportal.services;


import com.smartech.vendorportal.entities.Config;

public interface ConfigService {
	
	Config retriveAllConfig();
	Config updateConfig(Config config);

}
