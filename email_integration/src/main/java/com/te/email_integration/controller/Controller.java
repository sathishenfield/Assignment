package com.te.email_integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.email_integration.service.EmailSenderWithAttachment;

import jakarta.mail.MessagingException;

@RestController
public class Controller {

	@Autowired
	private EmailSenderWithAttachment attachment;

	@GetMapping("/sendMail")
	public ResponseEntity<?> sendEmailWithAttachment() throws MessagingException {

		attachment.sendMailWithAttachment("karthikeyan5k5k5@gmail.com", "Email Integraion",
				"Spring Boot Email Inetgragion", "D:\\OOTY\\VIDEOS\\VID-20220418-WA0034.mp4");

		return new ResponseEntity<String>("Email Sent", HttpStatus.OK);
	}

}
