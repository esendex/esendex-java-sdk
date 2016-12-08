package esendex.sdk.java.model.domain.response;

import esendex.sdk.java.model.domain.impl.StandardReportRowImpl;
import esendex.sdk.java.model.domain.impl.SurveyReportErrorImpl;

import java.util.List;

public interface StandardReportResponse {
    List<StandardReportRowImpl> getRows();
    List<SurveyReportErrorImpl> getErrors();
}
