package com.esendex.java.sdk.OptOutService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.FromAddress;
import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
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

public class GetOptOutsByPhoneNumberAndAccountReferenceTest extends BaseTest {
    private static OptOutCollectionResponse result;
    private static Date expectedFirstReceivedAt;
    private static Date expectedSecondReceivedAt;
    private static TestServer server;
    private static StubMethod stubMethod;

    @BeforeClass
    public static void beforeClass() throws EsendexException {
        String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<optouts startindex=\"34\" count=\"167\" totalcount=\"9\" xmlns=\"http://api.esendex.com/ns/\">" +
                "  <optout id=\"aa71708f-824e-4c88-a8cb-81705145eecf\" xmlns=\"http://api.esendex.com/ns/\">\n" +
                "    <accountreference>EX0012346</accountreference>\n" +
                "    <receivedat>2011-12-31T23:59:59.997Z</receivedat>\n" +
                "    <from><phonenumber>447000047076</phonenumber></from>\n" +
                "    <link rel=\"self\" href=\"https://api.esendex.com/v1.0/optouts/aa71708f-824e-4c88-a8cb-81705145eecf\" />\n" +
                "  </optout>" +
                "  <optout id=\"885b3596-32b4-491f-994c-21ece4ef3dd4\" xmlns=\"http://api.esendex.com/ns/\">\n" +
                "    <accountreference>EX0012347</accountreference>\n" +
                "    <receivedat>2012-11-30T20:59:59.997Z</receivedat>\n" +
                "    <from><phonenumber>447000047077</phonenumber></from>\n" +
                "    <link rel=\"self\" href=\"https://api.esendex.com/v1.0/optouts/885b3596-32b4-491f-994c-21ece4ef3dd4\" />\n" +
                "  </optout>" +
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

        stubMethod = StubMethod.get("/v1.0/optouts");
        server.expect(stubMethod).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        OptOutService optOutService = new OptOutServiceImpl(new BasicAuthenticator(userPassword));

        FromAddress fromAddress = new FromAddress();
        fromAddress.setPhoneNumber("193746825");

        result = optOutService.getOptOuts("EX9999999", fromAddress, 56, 71);
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
    public void thenThePageQueryParametersWereAddedToTheRequest() {
        assertEquals("56", stubMethod.query.get("startIndex")[0]);
        assertEquals("71", stubMethod.query.get("count")[0]);
    }

    @Test
    public void thenTheAccountReferenceQueryParameterWasAddedToTheRequest() {
        assertEquals("EX9999999", stubMethod.query.get("accountreference")[0]);
    }

    @Test
    public void thenTheFromAddressQueryParameterWasAddedToTheRequest() {
        assertEquals("193746825", stubMethod.query.get("from")[0]);
    }

    @Test
    public void thenTheExpectedStartIndexAndCountValuesAreReturned() {
        assertEquals(Integer.valueOf(167), result.getCount());
        assertEquals(Integer.valueOf(34), result.getStartIndex());
        assertEquals(Integer.valueOf(9), result.getTotalCount());
    }

    @Test
    public void thenTwoOptOutsAreReturned() {
        assertEquals(2, result.getOptOuts().size());
    }

    @Test
    public void thenTheFirstOptOutIsReturned() {
        OptOutResponse optOut = result.getOptOuts().get(0);

        assertEquals("aa71708f-824e-4c88-a8cb-81705145eecf", optOut.getId());
        assertEquals("EX0012346", optOut.getAccountReference());
        assertEquals(expectedFirstReceivedAt, optOut.getReceivedAt());
        assertEquals("447000047076", optOut.getFrom().getPhoneNumber());
    }

    @Test
    public void thenTheSecondOptOutIsReturned() {
        OptOutResponse optOut = result.getOptOuts().get(1);

        assertEquals("885b3596-32b4-491f-994c-21ece4ef3dd4", optOut.getId());
        assertEquals("EX0012347", optOut.getAccountReference());
        assertEquals(expectedSecondReceivedAt, optOut.getReceivedAt());
        assertEquals("447000047077", optOut.getFrom().getPhoneNumber());
    }
}

