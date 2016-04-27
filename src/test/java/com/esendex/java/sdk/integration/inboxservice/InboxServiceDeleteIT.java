package com.esendex.java.sdk.integration.inboxservice;

import com.esendex.java.sdk.integration.BaseTest;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;

import static org.junit.Assert.assertTrue;

public class InboxServiceDeleteIT extends BaseTest {

    private static String messageIdToDelete;
    private static InboxMessageCollectionResponse messagesAfterDelete;

    /*@BeforeClass
    public static void whenDeletingAnInboxMessage() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();

        InboxMessageCollectionResponse messages = inboxService.getOptOuts();

        if ( messages.getTotalcount() != 0 )
        {
            messageIdToDelete = messages.getOptOuts().get(0).getId();
            assertTrue(inboxService.deleteMessage(messageIdToDelete));
        }

        messagesAfterDelete = inboxService.getOptOuts();
    }

    @Test
    public void thenTheMessageIsNotInTheMessagesRetrievedAfterTheDelete() {

        for (InboxMessageResponse inboxMessageResponse : messagesAfterDelete.getOptOuts()) {
            assertTrue(messageIdToDelete.equals(inboxMessageResponse.getId()));
        }
    }*/

}
