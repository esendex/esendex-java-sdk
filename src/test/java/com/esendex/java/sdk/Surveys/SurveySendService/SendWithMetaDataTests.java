package com.esendex.java.sdk.Surveys.SurveySendService;

import com.esendex.java.sdk.SurveysTestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.MetaData;
import esendex.sdk.java.model.domain.request.RecipientRequest;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.SurveySendServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SendWithMetaDataTests {

    private static SurveysTestServer server;
    private static StubMethod stubMethod;
    private static String expectedRequestBody;

    @BeforeClass
    public static void beforeClass() throws EsendexException {

        expectedRequestBody = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<recipients xmlns=\"http://api.esendex.com/ns/\">" +
                "<recipient><phonenumber>07123456789</phonenumber>" +
                "<templatefields/>" +
                "<metadata><metadataitem><name>my name</name><value>my value</value></metadataitem></metadata>" +
                "</recipient>" +
                "</recipients>";

        server = new SurveysTestServer();
        server.start();
        
        String surveyId = "THEID";
        
        stubMethod = StubMethod.post("/v1.0/surveys/THEID/send").ifContentType("text/xml");
        server.expect(stubMethod).thenReturn(200);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        SurveySendServiceImpl surveySendService = new SurveySendServiceImpl(new BasicAuthenticator(userPassword));

        RecipientRequest request = new RecipientRequest("07123456789");

        List<MetaData> metadata = new ArrayList<>();
        metadata.add(new MetaData("my name", "my value"));
        request.setMetaData(metadata);

        surveySendService.Send(surveyId, request);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheSurveyIsSent() {
        server.verify();
        assertEquals(expectedRequestBody, stubMethod.bodyString());
    }
}
