package esendex.sdk.java.integration.sentservice;

import esendex.sdk.java.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.SentMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.service.SentService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class SentServiceGetMessageTests extends BaseTest {

    private static SentMessageCollectionResponse expectedMessages;
    private static List<SentMessageResponse> actualMessages;

    @BeforeClass
    public static void whenGettingIndividualMessages() throws EsendexException {

        SentService sentService = getFactory().getSentService();

        expectedMessages = sentService.getMessages(0, 10);


        actualMessages = new Vector<SentMessageResponse>();
        for(SentMessageResponse m : expectedMessages.getMessages()) {

            SentMessageResponse actual = sentService.getMessage(m.getId());

            actualMessages.add(actual);
        }
    }

    @Test
    public void thenTheExpectedMessagesAreReturned() {

        for(SentMessageResponse expected : expectedMessages.getMessages()) {
            SentMessageResponse actual = getActualSentMessageResponseWithId(expected.getId());

            assertEquals(actual.getTo().getPhoneNumber(), expected.getTo().getPhoneNumber());
            assertEquals(actual.getFrom().getPhoneNumber(), expected.getFrom().getPhoneNumber());
            assertEquals(actual.getReference(), expected.getReference());

        }

    }

    private SentMessageResponse getActualSentMessageResponseWithId(String id) {
        for(SentMessageResponse m : actualMessages) {
            if ( m.getId().equals(id))
                return m;
        }
        return null;
    }
}
