package com.esendex.java.sdk.integration.messagingservice;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.SmsMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.service.MessagingService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SendServiceMultiSmsMessageIT extends BaseTest {

    private static MessageResultResponse resultResponse;

    @BeforeClass
    public static void whenSendingMultipleMessages() throws EsendexException {

        MessagingService messagingService = getFactory().getMessagingService();

        List<SmsMessageRequest> messages = new Vector<SmsMessageRequest>();
        messages.add(new SmsMessageRequest(DESTINATION_NUMBER, "message body 1"));
        messages.add(new SmsMessageRequest(DESTINATION_NUMBER, "message body 2"));
        messages.add(new SmsMessageRequest(DESTINATION_NUMBER, "message body 3"));
        messages.add(new SmsMessageRequest(DESTINATION_NUMBER, "message body 4"));
        messages.add(new SmsMessageRequest(DESTINATION_NUMBER, "message body 5"));

        SmsMessageCollectionRequest smsMessageRequests = new SmsMessageCollectionRequest(ACCOUNT, messages);

        resultResponse = messagingService.sendMessages(smsMessageRequests);
    }

    @Test
    public void thenABatchIdIsReturned() {
        assertNotNull(resultResponse.getBatchId());
    }

    @Test
    public void thenMessageHeadersAreReturned() {
        assertTrue(resultResponse.getMessageIds().size() == 5);
        for(int i = 0; i < 5; ++i)
            assertNotNull(resultResponse.getMessageIds().get(i));
    }
}


