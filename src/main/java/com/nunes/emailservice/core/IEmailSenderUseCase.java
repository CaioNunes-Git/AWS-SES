package com.nunes.emailservice.core;

import com.nunes.emailservice.core.domain.Email;

public interface IEmailSenderUseCase {

    void sendEmail(Email email);

}
