package com.ds.edustack.notification.service;

import com.ds.edustack.notification.entity.EmailDetails;

import java.util.List;

public interface EmailService {
    void sendSimpleEmail(String toEmail, String subject, String body);

//    List<EmailDetails> findByToEmail(String toEmail);
}
