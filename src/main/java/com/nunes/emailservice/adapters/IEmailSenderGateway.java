package com.nunes.emailservice.adapters;

import com.nunes.emailservice.core.domain.Email;

public interface IEmailSenderGateway {
    void sendEmail(Email email);
}
