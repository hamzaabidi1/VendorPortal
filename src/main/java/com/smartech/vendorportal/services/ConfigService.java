package com.smartech.vendorportal.services;

import java.util.List;

import com.smartech.vendorportal.entities.Config;

public interface ConfigService {
	
	List<Config> retriveAllConfig();
	Config updateConfig(Config config);

}
