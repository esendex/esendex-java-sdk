package esendex.sdk.java.model.transfer.surveys;

import esendex.sdk.java.model.transfer.Dto;

public class SurveyReportErrorDto extends Dto {

    public SurveyReportErrorDto() { super(); }

    private String code;
    private String description;

    public String getCode() { return code; }
    public String getDescription() { return description; }

}
