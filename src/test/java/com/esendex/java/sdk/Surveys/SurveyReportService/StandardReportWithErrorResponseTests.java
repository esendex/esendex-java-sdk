package com.esendex.java.sdk.Surveys.SurveyReportService;

import com.esendex.java.sdk.SurveysTestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.StandardReportRequest;
import esendex.sdk.java.model.types.DateRangeType;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.SurveyReportServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.*;

import static org.junit.Assert.assertTrue;

public class StandardReportWithErrorResponseTests {
    private static SurveysTestServer server;
    private static EsendexException expectedException;

    @BeforeClass
    public static void beforeClass() throws Exception {

        server = new SurveysTestServer();
        server.start();

        server.expect(StubMethod.get("/v1.0/surveys/THEID/report/standard")).thenReturn(403);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        SurveyReportServiceImpl surveySendService = new SurveyReportServiceImpl(new BasicAuthenticator(userPassword));

        StandardReportRequest request = new StandardReportRequest();
        request.setDateRangeType(DateRangeType.QUESTION_SENT);

        try {
            surveySendService.GetStandardReport("THEID", request);
        } catch (EsendexException e) {
            expectedException = e;
        }
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenAnExceptionIsThrown()
    {
        boolean correctException = expectedException.getMessage().contains("403");
        assertTrue(correctException);
    }
}