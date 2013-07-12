package esendex.sdk.java.integration.inboxservice;

import esendex.sdk.java.BaseTest;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.service.InboxService;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class InboxServiceGetMessagesTests extends BaseTest {

    private static InboxMessageCollectionResponse messages;

    @BeforeClass
    public static void whenRetrievingTheInboxMessages() throws EsendexException {

        InboxService inboxService = getFactory().getInboxService();

        messages = inboxService.getMessages();
    }


    @Test
    public void thenMessagesAreReturned() {

        for(InboxMessageResponse response : messages.getMessages()) {
            assertNotNull(response.getId());
        }
    }
}
