package com.esendex.java.sdk.integration.messagingservice;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.model.types.CharacterSet;
import esendex.sdk.java.service.MessagingService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SendServiceSingleUnicodeSMSIT extends BaseTest {

    private static MessageResultResponse resultResponse;

    @BeforeClass
    public static void whenSendingASingleMessage() throws EsendexException {

        MessagingService messagingService = getFactory().getMessagingService();

        resultResponse = messagingService.sendMessage(ACCOUNT, new SmsMessageRequest(DESTINATION_NUMBER, "\u1F43", CharacterSet.UNICODE));
    }

    @Test
    public void thenABatchIdIsReturned() {
        assertNotNull(resultResponse.getBatchId());
    }

    @Test
    public void thenAMessageHeaderIsReturned() {
        assertTrue(resultResponse.getMessageIds().size() == 1);
        assertNotNull(resultResponse.getMessageIds().get(0));
    }
}
