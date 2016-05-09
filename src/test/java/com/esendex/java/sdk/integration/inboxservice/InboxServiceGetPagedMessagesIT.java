package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.integration.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class InboxServiceGetPagedMessagesIT extends BaseTest {

    private static InboxMessageCollectionResponse messages;
    private static int pageSize;

    @BeforeClass
    public static void whenRetrievingPagedInboxMessages() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();

        pageSize = 5;
        messages = inboxService.getMessages(0, pageSize);
    }

    @Test
    public void thenTheTotalCountIsGreaterThanOrEqualToTheNumberOfMessagesReturned() {
        assertTrue(messages.getCount() <= messages.getTotalCount());
    }

    @Test
    public void thenNoMoreThanThePageSizeMessagesAreReturned() {
        assertTrue(messages.getCount() <= pageSize);
    }

    @Test
    public void thenAllTheReturnedMessagesHaveIdAndBody() {
        for (InboxMessageResponse inboxMessageResponse : messages.getMessages()) {
            assertNotNull(inboxMessageResponse.getId());
            assertNotNull(inboxMessageResponse.getBody());
        }
    }
}
