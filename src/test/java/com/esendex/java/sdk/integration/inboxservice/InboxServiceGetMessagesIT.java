package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.integration.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class InboxServiceGetMessagesIT extends BaseTest {

    private static InboxMessageCollectionResponse messages;

    @BeforeClass
    public static void whenRetrievingTheInboxMessages() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();

        messages = inboxService.getMessages();
    }


    @Test
    public void thenMessagesAreReturned() {

        for (InboxMessageResponse response : messages.getMessages()) {
            assertNotNull(response.getId());
        }
    }
}
