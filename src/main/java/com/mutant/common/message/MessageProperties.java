package com.mutant.common.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageProperties {

    MessageSource messageSource;

    @Autowired
    public MessageProperties(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }

    @Nullable
    public String getMessage(MessageCatalog message) {
        return messageSource.getMessage(message.getDetails(), null, Locale.getDefault());
    }
}