package com.esendex.java.sdk.Surveys.SurveyReportService;

import com.esendex.java.sdk.SurveysTestServer;
import com.pyruby.stubserver.StubMethod;
import esendex.sdk.java.model.domain.impl.StandardReportRowImpl;
import esendex.sdk.java.model.domain.request.StandardReportRequest;
import esendex.sdk.java.model.domain.response.StandardReportResponse;
import esendex.sdk.java.model.types.DateRangeType;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.SurveyReportServiceImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class StandardReportWithBadRequestTests {
    private static SurveysTestServer server;
    private static StandardReportResponse result;
    private static String responseBody;

    @BeforeClass
    public static void beforeClass() throws Exception {
        responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?><response xmlns=\"http://api.esendex.com/ns/\"><errors><error>" +
                "<code>date_in_future</code><description>Cannot download report for dates in future</description>" +
                "</error></errors></response>";

        server = new SurveysTestServer();
        server.start();

        server.expect(StubMethod.get("/v1.0/surveys/THEID/report/standard" +
                "?questionSentAfter=2020-01-01+00%3A00%3A00")).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        SurveyReportServiceImpl surveySendService = new SurveyReportServiceImpl(new BasicAuthenticator(userPassword));

        StandardReportRequest request = new StandardReportRequest();
        request.setDateRangeType(DateRangeType.QUESTION_SENT);

        Calendar startDateCal = Calendar.getInstance();
        startDateCal.set(Calendar.YEAR, 2020);
        startDateCal.set(Calendar.MONTH, Calendar.JANUARY);
        startDateCal.set(Calendar.DAY_OF_MONTH, 1);
        startDateCal.set(Calendar.HOUR_OF_DAY, 0);
        startDateCal.set(Calendar.MINUTE, 0);
        startDateCal.set(Calendar.SECOND, 0);

        request.setStartDate(startDateCal.getTime());

        result = surveySendService.GetStandardReport("THEID", request);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheErrorsAreRetrieved()
    {
        assertEquals(0, result.getRows().size());
        assertEquals(1, result.getErrors().size());
        assertEquals("date_in_future", result.getErrors().get(0).getCode());
        assertEquals("Cannot download report for dates in future", result.getErrors().get(0).getDescription());
    }
}
