package com.te.email_integration.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class EmailSenderWithAttachment {

	@Autowired
	private JavaMailSender mailSender;

	public void sendMailWithAttachment(String toEmail, String subject, String body, String attachment)
			throws MessagingException {

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		
		helper.setFrom("sathishenfield1996@gmail.com");
		helper.setTo(toEmail);
		helper.setSubject(subject);
		helper.setText(body);
		
		FileSystemResource resource=new FileSystemResource(new File(attachment));
		helper.addAttachment(resource.getFilename(), resource);
		mailSender.send(message);
		
		System.out.println("Mail sent with attachment");
	}

}
