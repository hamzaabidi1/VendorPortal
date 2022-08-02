package com.smartech.vendorportal.utils;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.smartech.vendorportal.entities.Config;
import com.smartech.vendorportal.services.ConfigService;

@Configuration
public class MailConfig {
	@Autowired
	ConfigService configService;


	@Bean
	public JavaMailSender getJavaMailSender() {
		Config configs = configService.retriveAllConfig();
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername(configs.getEmail());
		mailSender.setPassword(configs.getPassword());
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		return mailSender;
	}

}