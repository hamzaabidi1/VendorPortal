package com.smartech.vendorportal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UtilitiesImpl implements Utilities {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String recipientEmail, String messageText) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(recipientEmail);
		message.setSubject("Portal vendor support");
		message.setText(messageText);
		this.mailSender.send(message);
	}

}
