package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.domain.impl.StandardReportResponseAssembler;
import esendex.sdk.java.model.domain.request.StandardReportRequest;
import esendex.sdk.java.model.domain.response.StandardReportResponse;
import esendex.sdk.java.model.types.DateRangeType;
import esendex.sdk.java.service.SurveyReportService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.surveys.SurveyReportResource;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SurveyReportServiceImpl
        extends AbstractService implements SurveyReportService{

    public SurveyReportServiceImpl(Authenticator authenticator) {
        super(authenticator);
    }

    public StandardReportResponse GetStandardReport(String surveyId, StandardReportRequest request) throws EsendexException {
        HttpQuery query = new HttpQuery();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (request.getDateRangeType() == DateRangeType.ANSWER_RECEIVED)
        {
            if (request.getStartDate() != null) {
                query.addParameter(HttpQuery.ANSWER_RECEIVED_AFTER, dateFormat.format(request.getStartDate()));
            }
            if (request.getEndDate() != null) {
                query.addParameter(HttpQuery.ANSWER_RECEIVED_BEFORE, dateFormat.format(request.getEndDate()));
            }
        }
        else {
            if (request.getStartDate() != null) {
                query.addParameter(HttpQuery.QUESTION_SENT_AFTER,  dateFormat.format(request.getStartDate()));
            }

            if (request.getEndDate() != null) {
                query.addParameter(HttpQuery.QUESTION_SENT_BEFORE, dateFormat.format(request.getEndDate()));
            }
        }

        SurveyReportResource resource = new SurveyReportResource(authenticator, surveyId, query);

        resource.execute();

        return new StandardReportResponseAssembler(resource.getResponseObject()).createResponse();
    }
}
