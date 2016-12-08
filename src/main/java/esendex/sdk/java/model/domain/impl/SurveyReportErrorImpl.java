package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.SurveyReportError;

public class SurveyReportErrorImpl implements SurveyReportError {

    private String code;
    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String errorCode) {
        this.code = errorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
