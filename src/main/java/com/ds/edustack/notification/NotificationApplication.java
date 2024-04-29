package com.ds.edustack.notification;

import com.ds.edustack.notification.config.TwilioConfig;
import com.ds.edustack.notification.service.EmailService;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableConfigurationProperties
public class NotificationApplication {

	@Autowired
	private EmailService senderService;

	@Autowired
	private TwilioConfig twilioConfig;

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		senderService.sendSimpleEmail("kodithuwakkuyeran@gmail.com",
				"This is email body",
				"This is email subject");

	}

	@PostConstruct //when the application starts, this method will be called
	public void setup() {
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
	}

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}
}
