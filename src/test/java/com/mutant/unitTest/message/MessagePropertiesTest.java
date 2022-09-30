package com.mutant.unitTest.message;

import com.mutant.common.message.MessageCatalog;
import com.mutant.common.message.MessageProperties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.mockito.stubbing.Answer;
import org.springframework.context.MessageSource;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MessagePropertiesTest {

    @InjectMocks
    MessageProperties messageProperties;

    @Mock
    MessageSource messageSource;

    /**
     * This method testing messageProperties.getMessage
     * Validate that response is not null.
     */
    @Test
    void getMessageTest() {
        when(messageSource.getMessage(any(),any(),any())).then(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                return "Message test";
            }
        });
        assertNotNull(messageProperties.getMessage(MessageCatalog.DNAEXIST));
    }

}
