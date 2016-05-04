package com.esendex.java.sdk.OptOutService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.service.OptOutService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.OptOutServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class GetOptOutTest extends BaseTest {
    private static OptOutResponse result;
    private static Date expectedReceivedAt;
    private static TestServer server;

    @BeforeClass
    public static void beforeClass() throws EsendexException {
        final String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<optout id=\"6d2b745d-c214-4154-bca9-b0ff9a6b94c1\" xmlns=\"http://api.esendex.com/ns/\">\n" +
                "  <accountreference>EX0012345</accountreference>\n" +
                "  <receivedat>2010-12-31T23:59:59.997Z</receivedat>\n" +
                "  <from><phonenumber>447000047075</phonenumber></from>\n" +
                "  <link rel=\"self\" href=\"https://api.esendex.com/v1.0/optouts/6d2b745d-c214-4154-bca9-b0ff9a6b94c1\" />\n" +
                "</optout>";

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(2010, Calendar.DECEMBER, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 0);
        expectedReceivedAt = cal.getTime();

        server = new TestServer();
        server.start();

        server.expect(StubMethod.get("/v1.0/optouts/THEID")).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        OptOutService optOutService = new OptOutServiceImpl(new BasicAuthenticator(userPassword));

        result = optOutService.getOptOut("THEID");
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheOptOutIsRetrieved() {
        server.verify();
    }

    @Test
    public void thenTheOptOutIsReturned() {
        assertEquals("6d2b745d-c214-4154-bca9-b0ff9a6b94c1", result.getId());
        assertEquals("EX0012345", result.getAccountReference());
        assertEquals(expectedReceivedAt, result.getReceivedAt());
        assertEquals("447000047075", result.getFrom().getPhoneNumber());
    }
}

