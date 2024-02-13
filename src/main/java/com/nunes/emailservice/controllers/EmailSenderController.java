package com.nunes.emailservice.controllers;

import com.nunes.emailservice.application.IEmailSenderService;
import com.nunes.emailservice.core.domain.Email;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/email")
public class EmailSenderController {

    private final IEmailSenderService emailSenderService;

    public EmailSenderController(IEmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping
    public ResponseEntity<String> sendEmail (@RequestBody Email email) {
        this.emailSenderService.sendEmail(email);
        return ResponseEntity.ok("Email sent");
    }
}
