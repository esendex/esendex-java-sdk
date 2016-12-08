package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.StandardReportResponse;
import esendex.sdk.java.model.domain.response.SurveyReportError;

import java.util.List;

public class StandardReportResponseImpl implements StandardReportResponse {
    private List<StandardReportRowImpl> rows;
    private List<SurveyReportErrorImpl> errors;

    public List<StandardReportRowImpl> getRows() {
        return rows;
    }

    public List<SurveyReportErrorImpl> getErrors() {
        return errors;
    }

    public void setRows(List<StandardReportRowImpl> rows) {
        this.rows = rows;
    }

    public void setErrors(List<SurveyReportErrorImpl> errors) {
        this.errors = errors;
    }
}
