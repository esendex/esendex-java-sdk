package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.StandardReportRequest;
import esendex.sdk.java.model.domain.response.StandardReportResponse;

public interface SurveyReportService {
    StandardReportResponse GetStandardReport(String surveyId, StandardReportRequest request) throws EsendexException;
}
