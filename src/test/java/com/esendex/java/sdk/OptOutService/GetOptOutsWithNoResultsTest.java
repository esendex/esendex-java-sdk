package com.esendex.java.sdk.OptOutService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
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

public class GetOptOutsWithNoResultsTest extends BaseTest {
    private static OptOutCollectionResponse result;
    private static Date expectedFirstReceivedAt;
    private static Date expectedSecondReceivedAt;
    private static TestServer server;

    @BeforeClass
    public static void beforeClass() throws EsendexException {
        String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<optouts startindex=\"12\" count=\"133\" totalcount=\"18\" xmlns=\"http://api.esendex.com/ns/\">" +
                "</optouts>";

        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        cal.set(2011, Calendar.DECEMBER, 31, 23, 59, 59);
        cal.set(Calendar.MILLISECOND, 0);
        expectedFirstReceivedAt = cal.getTime();

        cal.set(2012, Calendar.NOVEMBER, 30, 20, 59, 59);
        cal.set(Calendar.MILLISECOND, 0);
        expectedSecondReceivedAt = cal.getTime();

        server = new TestServer();
        server.start();

        server.expect(StubMethod.get("/v1.0/optouts")).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        OptOutService optOutService = new OptOutServiceImpl(new BasicAuthenticator(userPassword));

        result = optOutService.getOptOuts(56, 71);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheOptOutsAreRetrieved() {
        server.verify();
    }

    @Test
    public void thenTheExpectedStartIndexAndCountValuesAreReturned() {
        assertEquals(Integer.valueOf(133), result.getCount());
        assertEquals(Integer.valueOf(12), result.getStartIndex());
        assertEquals(Integer.valueOf(18), result.getTotalCount());
    }

    @Test
    public void thenNoOptOutsAreReturned() {
        assertEquals(0, result.getOptOuts().size());
    }
}

