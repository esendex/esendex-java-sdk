package com.esendex.java.sdk.SentService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.FailureReason;
import esendex.sdk.java.model.domain.response.SentMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.model.types.MessageType;
import esendex.sdk.java.model.types.Status;
import esendex.sdk.java.service.SentService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.SentServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class GetMessagesWithFailureReasonTest extends BaseTest {
    private SentMessageCollectionResponse result;

    @Before
    public void before() throws EsendexException {
        TestServer server = new TestServer(44041);
        server.start();
        try {
            server.expect(StubMethod.get("/v1.0/messageheaders")).thenReturn(200, "application/xml",
                    "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                    "<messageheaders startindex=\"0\" count=\"15\" totalcount=\"200\" xmlns=\"http://api.esendex.com/ns/\">" +
                    " <messageheader id=\"CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC\" uri=\"http://api.esendex.com/v1.0/messageheaders/CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC/\">" +
                    "  <status>Delivered</status>" +
                    "  <laststatusat>2010-01-01T12:00:05.000</laststatusat>" +
                    "  <submittedat>2010-01-01T12:00:02.000</submittedat>" +
                    "  <type>SMS</type>" +
                    "  <to>" +
                    "   <phonenumber>447700900123</phonenumber>" +
                    "  </to>" +
                    "  <from>" +
                    "   <phonenumber>447700900654</phonenumber>" +
                    "  </from>" +
                    "  <summary>Testing REST API</summary>" +
                    "  <body uri=\"http://api.esendex.com/v1.0/messageheaders/CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC/body\"/>" +
                    "  <direction>Outbound</direction>" +
                    "  <parts>1</parts>" +
                    "  <username>user@example.com</username>" +
                    "  <failurereason>" +
                    "   <code>492</code>" +
                    "   <description>Lots of problems</description>" +
                    "   <permanentfailure>false</permanentfailure>" +
                    "  </failurereason>" +
                    " </messageheader>" +
                    "</messageheaders>");

            UserPassword userPassword = new UserPassword("YourUsername","YourPassword");
            SentService sentService = new SentServiceImpl(new BasicAuthenticator(userPassword));

            result = sentService.getMessages(2, 5);

            server.verify();
        } finally {
            server.stop();
        }
    }

    @Test
    public void thenTheMessagePropertiesAreSet() {
        assertEquals(new Integer(0), result.getStartIndex());
        assertEquals(new Integer(15), result.getCount());
        assertEquals(new Integer(200), result.getTotalCount());

        SentMessageResponse message = result.getMessages().get(0);

        assertEquals(Status.DELIVERED, message.getStatus());
        assertEquals(new Date(110, 0, 1, 12, 0, 5), message.getLastStatusAt());
        assertEquals(new Date(110, 0, 1, 12, 0, 2), message.getSubmittedAt());
        assertEquals(MessageType.SMS, message.getType());
        assertEquals("447700900123", message.getTo().getPhoneNumber());
        assertEquals("447700900654", message.getFrom().getPhoneNumber());
        assertEquals("Testing REST API", message.getSummary());
        assertEquals(new Integer(1), message.getParts());
        assertEquals("user@example.com", message.getUserName());

        FailureReason failureReason = message.getFailureReason();

        assertEquals(new Integer(492), failureReason.getCode());
        assertEquals("Lots of problems", failureReason.getDescription());
        assertEquals(false, failureReason.isPermanentFailure());
    }
}
