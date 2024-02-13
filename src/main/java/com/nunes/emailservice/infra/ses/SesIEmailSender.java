package com.nunes.emailservice.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.nunes.emailservice.adapters.IEmailSenderGateway;
import com.nunes.emailservice.core.exceptions.EmailServiceException;
import com.nunes.emailservice.core.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesIEmailSender implements IEmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesIEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }

    @Override
    public void sendEmail(Email email) {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("ninjagabiru@gmail.com")
                .withDestination(new Destination().withToAddresses(email.getTo()))
                .withMessage(new Message()
                        .withSubject(new Content(email.getSubject()))
                        .withBody(new Body().withText(new Content(email.getBody())))
                );
        try{
            amazonSimpleEmailService.sendEmail(request);
        } catch (AmazonServiceException e) {
            throw new EmailServiceException("Error sending email", e);
        }
    }
}
