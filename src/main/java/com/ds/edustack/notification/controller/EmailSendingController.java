package com.ds.edustack.notification.controller;

import com.ds.edustack.notification.entity.EmailDetails;
import com.ds.edustack.notification.repository.EmailRepository;
import com.ds.edustack.notification.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emails")
public class EmailSendingController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository emailRepository;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetails) {
        emailService.sendSimpleEmail(emailDetails.getToEmail(), emailDetails.getSubject(), emailDetails.getBody());
        return ResponseEntity.ok("Email sent successfully");
    }
    @GetMapping
    public ResponseEntity<List<EmailDetails>> getEmailDetails(@RequestParam String toEmail) {
        List<EmailDetails> email = emailRepository.findByToEmail(toEmail);
        return ResponseEntity.ok(email);
    }
}

//After enrolled in a course, we can get the course details through a get request.
// From that we can obtain the relevant course details and also the toEmail