package esendex.sdk.java.integration.messagingservice;

import esendex.sdk.java.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.service.MessagingService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SendServiceSingleSmsMessageTests extends BaseTest {

    private static MessageResultResponse resultResponse;

    @BeforeClass
    public static void whenSendingASingleMessage() throws EsendexException {

        MessagingService messagingService = getFactory().getMessagingService();

        resultResponse = messagingService.sendMessage(ACCOUNT, new SmsMessageRequest(DESTINATION_NUMBER, "Hello World"));
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

