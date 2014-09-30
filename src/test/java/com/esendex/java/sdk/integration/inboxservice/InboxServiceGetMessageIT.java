package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class InboxServiceGetMessageIT extends BaseTest {

    private static InboxMessageCollectionResponse expectedMessages;
    private static List<InboxMessageResponse> actualMessages;

    @BeforeClass
    public static void whenGettingSpecificMessages() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();
        expectedMessages = inboxService.getMessages();

        actualMessages = new Vector<InboxMessageResponse>();
        for (InboxMessageResponse inboxMessageResponse : expectedMessages.getMessages()) {

            String id = inboxMessageResponse.getId();

            actualMessages.add(inboxService.getMessage(id));
        }
    }

    @Test
    public void thenTheExpectedMessagesAreReturned() {
        for (InboxMessageResponse expected : expectedMessages.getMessages()) {

            InboxMessageResponse actual = getActualInboxMessageResponseWithId(expected.getId());

            assertEquals(actual.getFrom().getPhoneNumber(), expected.getFrom().getPhoneNumber());
            assertEquals(actual.getTo().getPhoneNumber(), expected.getTo().getPhoneNumber());
            assertEquals(actual.getReceivedAt(), expected.getReceivedAt());
        }
    }

    private InboxMessageResponse getActualInboxMessageResponseWithId(String id) {

        for (InboxMessageResponse m : actualMessages) {
            if ( m.getId().equals(id))
                return m;
        }
        return null;
    }
}
