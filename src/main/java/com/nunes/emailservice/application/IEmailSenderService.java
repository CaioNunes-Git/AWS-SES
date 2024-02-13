package com.nunes.emailservice.application;

import com.nunes.emailservice.adapters.IEmailSenderGateway;
import com.nunes.emailservice.core.IEmailSenderUseCase;
import com.nunes.emailservice.core.domain.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IEmailSenderService implements IEmailSenderUseCase {

    private final IEmailSenderGateway IEmailSenderGateway;

    @Autowired
    public IEmailSenderService(IEmailSenderGateway IEmailSenderGateway) {
        this.IEmailSenderGateway = IEmailSenderGateway;
    }

    @Override
    public void sendEmail(Email email) {
        this.IEmailSenderGateway.sendEmail(email);
    }
}
