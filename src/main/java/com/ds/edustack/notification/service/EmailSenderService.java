package com.ds.edustack.notification.service;

public interface EmailSenderService {
    void sendSimpleEmail(String toEmail, String subject, String body);
}
