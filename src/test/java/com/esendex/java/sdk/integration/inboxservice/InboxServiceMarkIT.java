package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.integration.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class InboxServiceMarkIT extends BaseTest {

    private static InboxMessageResponse unreadMessage;
    private static InboxMessageResponse readMessage;

    @BeforeClass
    public static void whenMarkingAMessageAsReadAndThenUnread() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();
        InboxMessageResponse message = inboxService.getMessages().getMessages().get(0);

        if (messageIsUnread(message)) {
            markMessageAsRead(inboxService, message);
            markMessageAsUnread(inboxService, message);
        } else {
            markMessageAsUnread(inboxService, message);
            markMessageAsRead(inboxService, message);
        }
    }

    @Test
    public void thenMarkingTheMessageAsReadMakesItRead() {
        assertEquals(USER, readMessage.getReadBy());
    }

    @Test
    public void thenMarkingTheMessageAsUnreadMakesItUnread() {
        assertNull(unreadMessage.getReadBy());
    }

    private static boolean messageIsUnread(InboxMessageResponse message) {
        return message.getReadBy() != null;
    }

    private static void markMessageAsRead(InboxService inboxService, InboxMessageResponse message) throws EsendexException {
        assertTrue(inboxService.markMessageAsRead(message.getId()));
        readMessage = inboxService.getMessages().getMessages().get(0);
    }

    private static void markMessageAsUnread(InboxService inboxService, InboxMessageResponse message) throws EsendexException {
        assertTrue(inboxService.markMessageAsUnread(message.getId()));
        unreadMessage = inboxService.getMessages().getMessages().get(0);
    }
}
