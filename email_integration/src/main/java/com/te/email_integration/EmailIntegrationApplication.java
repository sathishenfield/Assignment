package com.te.email_integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.te.email_integration.service.EmailSenderService;
import com.te.email_integration.service.EmailSenderWithAttachment;

import jakarta.mail.MessagingException;

@SpringBootApplication
public class EmailIntegrationApplication {

	
//	 @Autowired
//      private EmailSenderWithAttachment attachment;

//	@Autowired
//	private EmailSenderService senderService;

	public static void main(String[] args) {
		SpringApplication.run(EmailIntegrationApplication.class, args);
	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMail() {
//		senderService.sendEmail("faridhere1326@gmail.com", 
//				"Email Integraion", "Spring Boot Email Inetgragion");
//	}

//	@EventListener(ApplicationReadyEvent.class)
//	public void sendMailWithAttachment() throws MessagingException {
//		attachment.sendMailWithAttachment("karthikeyan5k5k5@gmail.com", "Email Integraion",
//				"Spring Boot Email Inetgragion",
//				"D:\\OOTY\\VIDEOS\\VID-20220418-WA0034.mp4");
//	}

}
