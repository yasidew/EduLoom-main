package com.ds.edustack.notification.service.impl;

import com.ds.edustack.notification.EmailStatus;
import com.ds.edustack.notification.entity.EmailDetails;
import com.ds.edustack.notification.repository.EmailRepository;
import com.ds.edustack.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private EmailRepository emailRepository;


    @Override
    public void sendSimpleEmail(String toEmail,
                                String subject,
                                String body
    ) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("fromemail@gmail.com");
            message.setTo(toEmail);
            message.setText(body);
            message.setSubject(subject);
            mailSender.send(message);

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setToEmail(toEmail);
            emailDetails.setSubject(subject);
            emailDetails.setBody(body);
            emailDetails.setStatus(EmailStatus.DELIVERED.toString());
            emailRepository.save(emailDetails);

            System.out.println("Mail Sent Successfully...");
        }
        catch (Exception e){
            System.out.println("Mail Sending Failed..." + e.getMessage());

            EmailDetails emailDetails = new EmailDetails();
            emailDetails.setToEmail(toEmail);
            emailDetails.setSubject(subject);
            emailDetails.setBody(body);
            emailDetails.setStatus(EmailStatus.FAILED.toString());
            emailDetails.setFailureReason(e.getMessage());
            emailRepository.save(emailDetails);
        }
    }

//    @Override
//    public List<EmailDetails> findByToEmail(String toEmail) {
//        return emailRepository.findByToEmail(toEmail);
//    }
}
