package com.esendex.java.sdk.SentService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.FailureReason;
import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.model.types.MessageType;
import esendex.sdk.java.model.types.Status;
import esendex.sdk.java.service.SentService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.SentServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static junit.framework.Assert.assertEquals;

public class GetMessageWithFailureReasonTest extends BaseTest {
    private static SentMessageResponse result;
    private static TestServer server;
    private static Date expectedLastStatusAt;
    private static Date expectedSubmittedAt;

    @BeforeClass
    public static void beforeClass() throws EsendexException {
        final String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<messageheader id=\"CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC\" uri=\"http://api.esendex.com/v1.0/messageheaders/CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC/\" xmlns=\"http://api.esendex.com/ns/\">" +
                " <status>Delivered</status>" +
                " <laststatusat>2010-01-01T12:00:05.000</laststatusat>" +
                " <submittedat>2010-01-01T12:00:02.000</submittedat>" +
                " <type>SMS</type>" +
                " <to>" +
                "  <phonenumber>447700900123</phonenumber>" +
                " </to>" +
                " <from>" +
                "  <phonenumber>447700900654</phonenumber>" +
                " </from>" +
                " <summary>Testing REST API</summary>" +
                " <body uri=\"http://api.esendex.com/v1.0/messageheaders/CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC/body\"/>" +
                " <direction>Outbound</direction>" +
                " <parts>1</parts>" +
                " <username>user@example.com</username>" +
                " <failurereason>" +
                "  <code>102</code>" +
                "  <description>Some problem</description>" +
                "  <permanentfailure>true</permanentfailure>" +
                " </failurereason>" +
                "</messageheader>";

        Calendar cal = Calendar.getInstance();

        cal.set(2010, Calendar.JANUARY, 01, 12, 00, 05);
        cal.set(Calendar.MILLISECOND, 0);
        expectedLastStatusAt = cal.getTime();

        cal.set(2010, Calendar.JANUARY, 01, 12, 00, 02);
        cal.set(Calendar.MILLISECOND, 0);
        expectedSubmittedAt = cal.getTime();

        server = new TestServer();
        server.start();
        server.expect(StubMethod.get("/v1.0/messageheaders/THEID")).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        SentService sentService = new SentServiceImpl(new BasicAuthenticator(userPassword));

        result = sentService.getMessage("THEID");
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheMessageHeaderIsRetrieved() {
        server.verify();
    }

    @Test
    public void thenTheMessagePropertiesAreSet() {
        assertEquals("CDEB3533-1F76-46D7-A2A9-0DAF8290F7FC", result.getId());
        assertEquals(Status.DELIVERED, result.getStatus());
        assertEquals(expectedLastStatusAt, result.getLastStatusAt());
        assertEquals(expectedSubmittedAt, result.getSubmittedAt());
        assertEquals(MessageType.SMS, result.getType());
        assertEquals("447700900123", result.getTo().getPhoneNumber());
        assertEquals("447700900654", result.getFrom().getPhoneNumber());
        assertEquals("Testing REST API", result.getSummary());
        assertEquals(Integer.valueOf(1), result.getParts());
        assertEquals("user@example.com", result.getUserName());
    }

    @Test
    public void thenTheMessageFailureReasonIsSet() {
        FailureReason failureReason = result.getFailureReason();

        assertEquals(Integer.valueOf(102), failureReason.getCode());
        assertEquals("Some problem", failureReason.getDescription());
        assertEquals(true, failureReason.isPermanentFailure());
    }
}
