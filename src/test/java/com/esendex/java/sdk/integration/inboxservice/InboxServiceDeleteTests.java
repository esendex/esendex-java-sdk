package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InboxServiceDeleteTests extends BaseTest {

    private static String messageIdToDelete;
    private static InboxMessageCollectionResponse messagesAfterDelete;

    /*@BeforeClass
    public static void whenDeletingAnInboxMessage() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();

        InboxMessageCollectionResponse messages = inboxService.getMessages();

        if ( messages.getTotalCount() != 0 )
        {
            messageIdToDelete = messages.getMessages().get(0).getId();
            assertTrue(inboxService.deleteMessage(messageIdToDelete));
        }

        messagesAfterDelete = inboxService.getMessages();
    }

    @Test
    public void thenTheMessageIsNotInTheMessagesRetrievedAfterTheDelete() {

        for (InboxMessageResponse inboxMessageResponse : messagesAfterDelete.getMessages()) {
            assertTrue(messageIdToDelete.equals(inboxMessageResponse.getId()));
        }
    }*/

}
