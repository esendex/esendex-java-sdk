package com.esendex.java.sdk.integration.sentservice.session;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.SentMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.service.SentService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SessionSentServiceGetMessagesIT extends BaseTest {

    private static SentMessageCollectionResponse messages;

    @BeforeClass
    public static void whenGettingMessagesForTheAccountUsingASession() throws EsendexException {

        IsSessionMode = true;
        SentService sentService = getFactory().getSentService();

        messages = sentService.getMessages(ACCOUNT, 0, 10);
    }

    @Test
    public void thenTheNumberOfMessagesReturnedIsLessThanOrEqualToTheTotalCount() {

        assertTrue(messages.getCount() <= messages.getTotalCount());
    }

    @Test
    public void thenEachMessageHasAnIdAndBody() {

        for(SentMessageResponse m : messages.getMessages()) {
            assertNotNull(m.getId());
        }
    }

    @AfterClass
    public static void finallyEndSessionMode() {

        IsSessionMode = false;
    }
}
