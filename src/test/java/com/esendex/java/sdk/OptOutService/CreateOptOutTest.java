package com.esendex.java.sdk.OptOutService;

import com.esendex.java.sdk.BaseTest;
import com.esendex.java.sdk.TestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.FromAddressImpl;
import esendex.sdk.java.model.domain.impl.OptOutRequestImpl;
import esendex.sdk.java.model.domain.request.OptOutRequest;
import esendex.sdk.java.model.domain.response.FromAddress;
import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.model.transfer.optout.FromAddressDto;
import esendex.sdk.java.service.OptOutService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.OptOutServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class CreateOptOutTest extends BaseTest {
    private static OptOutResponse result;
    private static Date expectedReceivedAt;
    private static TestServer server;
    private static StubMethod stubMethod;
    private static String expectedRequestBody;

    @BeforeClass
    public static void beforeClass() throws EsendexException {
        final String responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<response xmlns=\"http://api.esendex.com/ns/\">\n" +
                "  <optout id=\"5d3c5c2d-ae35-4001-bf64-8893c091cb7f\">\n" +
                "    <accountreference>EX0012345</accountreference>\n" +
                "    <receivedat>2016-05-04T10:27:12Z</receivedat>\n" +
                "    <from>\n" +
                "      <phonenumber>447987654321</phonenumber>\n" +
                "    </from>\n" +
                "    <link rel=\"self\" href=\"https://api.dev.esendex.com/v1.0/optouts/5d3c5c2d-ae35-4001-bf64-8893c091cb7f\" />\n" +
                "  </optout>\n" +
                "</response>";

        expectedRequestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<optout xmlns=\"http://api.esendex.com/ns/\">" +
                "<from><phonenumber>99887744556322</phonenumber></from>" +
                "<accountreference>EX006789</accountreference>" +
                "</optout>";

        Calendar cal = Calendar.getInstance();
        cal.set(2016, Calendar.MAY, 4, 11, 27, 12);
        cal.set(Calendar.MILLISECOND, 0);
        expectedReceivedAt = cal.getTime();

        server = new TestServer();
        server.start();

        stubMethod = StubMethod.post("/v1.0/optouts");
        server.expect(stubMethod).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        OptOutService optOutService = new OptOutServiceImpl(new BasicAuthenticator(userPassword));

        FromAddress fromAddress = new FromAddressImpl();
        fromAddress.setPhoneNumber("99887744556322");

        OptOutRequest request = new OptOutRequestImpl();
        request.setAccountReference("EX006789");
        request.setFromAddress(fromAddress);

        result = optOutService.createOptOut(request);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheOptOutIsCreated() {
        server.verify();
        assertEquals(expectedRequestBody, stubMethod.bodyString());
    }

    @Test
    public void thenTheCreatedOptOutIsReturned() {
        assertEquals("5d3c5c2d-ae35-4001-bf64-8893c091cb7f", result.getId());
        assertEquals("EX0012345", result.getAccountReference());
        assertEquals(expectedReceivedAt, result.getReceivedAt());
        assertEquals("447987654321", result.getFrom().getPhoneNumber());
    }
}

