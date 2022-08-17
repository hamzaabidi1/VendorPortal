package com.smartech.vendorportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.smartech.vendorportal.entities.Config;

@Service
public class UtilitiesImpl implements Utilities {
	@Autowired
	ConfigService configService;


	@Autowired
	private JavaMailSenderImpl mailSender;

	public void sendEmail(String recipientEmail, String messageText) {
		Config configs = configService.retriveAllConfig();
		mailSender.setUsername(configs.getEmail());
		mailSender.setPassword(configs.getPassword());
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject("Portal vendor support");
		message.setText(messageText);
		this.mailSender.send(message);
	}

}
