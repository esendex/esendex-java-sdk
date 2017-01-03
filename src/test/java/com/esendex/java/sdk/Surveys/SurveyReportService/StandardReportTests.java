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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class StandardReportTests {
    private static SurveysTestServer server;
    private static StandardReportRowImpl expectedReportRow;
    private static StandardReportResponse result;
    private static String responseBody;

    @BeforeClass
    public static void beforeClass() throws Exception {
        responseBody = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                "<rows xmlns=\"http://api.esendex.com/ns/\">\n" +
                "    <row>\n" +
                "        <recipient>44712345678</recipient>\n" +
                "        <status>Delivered</status>\n" +
                "        <questionlabel>1</questionlabel>\n" +
                "        <questiondatetime>2016-12-01T13:25:41.17</questiondatetime>\n" +
                "        <answerlabel>positive</answerlabel>\n" +
                "        <answerdatetime>2016-12-01T13:38:14.96</answerdatetime>\n" +
                "        <answertext>Yes</answertext>\n" +
                "        <recipientdata>\n" +
                "            <recipientdataitem>\n" +
                "                <key>Title</key>\n" +
                "                <value>Mr</value>\n" +
                "            </recipientdataitem>\n" +
                "            <recipientdataitem>\n" +
                "                <key>Surname</key>\n" +
                "                <value>Smith</value>\n" +
                "            </recipientdataitem>\n" +
                "        </recipientdata>" +
                "    </row>\n" +
                "</rows>";

        expectedReportRow = new StandardReportRowImpl();
        expectedReportRow.setRecipient("44712345678");
        expectedReportRow.setDeliveryStatus("Delivered");
        expectedReportRow.setQuestionLabel("1");
        expectedReportRow.setQuestionDateTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2016-12-01T13:25:41.17"));
        expectedReportRow.setAnswerLabel("positive");
        expectedReportRow.setAnswerDateTime(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2016-12-01T13:38:14.96"));
        expectedReportRow.setAnswerText("Yes");
        HashMap<String, String> recipientData = new HashMap<>();
        recipientData.put("Title", "Mr");
        recipientData.put("Surname", "Smith");
        expectedReportRow.setRecipientData(recipientData);

        server = new SurveysTestServer();
        server.start();

        server.expect(StubMethod.get("/v1.0/surveys/THEID/report/standard" +
                "?questionSentAfter=2016-12-01+00%3A00%3A00" +
                "&questionSentBefore=2016-12-20+00%3A00%3A00")).thenReturn(200, "application/xml", responseBody);

        UserPassword userPassword = new UserPassword("YourUsername", "YourPassword");
        SurveyReportServiceImpl surveySendService = new SurveyReportServiceImpl(new BasicAuthenticator(userPassword));

        Calendar startDateCal = Calendar.getInstance();
        startDateCal.set(Calendar.YEAR, 2016);
        startDateCal.set(Calendar.MONTH, Calendar.DECEMBER);
        startDateCal.set(Calendar.DAY_OF_MONTH, 1);
        startDateCal.set(Calendar.HOUR_OF_DAY, 0);
        startDateCal.set(Calendar.MINUTE, 0);
        startDateCal.set(Calendar.SECOND, 0);

        Calendar endDateCal = Calendar.getInstance();
        endDateCal.set(Calendar.YEAR, 2016);
        endDateCal.set(Calendar.MONTH, Calendar.DECEMBER);
        endDateCal.set(Calendar.DAY_OF_MONTH, 20);
        endDateCal.set(Calendar.HOUR_OF_DAY, 0);
        endDateCal.set(Calendar.MINUTE, 0);
        endDateCal.set(Calendar.SECOND, 0);

        StandardReportRequest request = new StandardReportRequest(startDateCal.getTime(), endDateCal.getTime(), DateRangeType.QUESTION_SENT);
        result = surveySendService.GetStandardReport("THEID", request);
    }

    @AfterClass
    public static void afterClass() {
        server.stop();
    }

    @Test
    public void thenTheReportIsRetrieved()
    {
        assertEquals(result.getRows().size(), 1);

        for (StandardReportRowImpl row : result.getRows()) {
            assertStandardReportRow(expectedReportRow, row);
        }
    }

    private void assertStandardReportRow(StandardReportRowImpl expected, StandardReportRowImpl actual) {
        assertEquals(expected.getRecipient(), actual.getRecipient());
        assertEquals(expected.getDeliveryStatus(), actual.getDeliveryStatus());
        assertEquals(expected.getQuestionLabel(), actual.getQuestionLabel());
        assertEquals(expected.getQuestionDateTime(), actual.getQuestionDateTime());
        assertEquals(expected.getAnswerLabel(), actual.getAnswerLabel());
        assertEquals(expected.getAnswerDateTime(), actual.getAnswerDateTime());
        assertEquals(expected.getAnswerText(), actual.getAnswerText());

        assertEquals(expected.getRecipientData().size(), actual.getRecipientData().size());

        for (String key : actual.getRecipientData().keySet()) {
            assertEquals(expected.getRecipientData().get(key), actual.getRecipientData().get(key));
        }
    }
}
