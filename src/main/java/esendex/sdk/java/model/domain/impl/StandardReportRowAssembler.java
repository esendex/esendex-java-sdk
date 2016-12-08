package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.surveys.StandardReportRowDto;

public class StandardReportRowAssembler
{
    private final StandardReportRowDto rowDto;

    public StandardReportRowAssembler(StandardReportRowDto row) {
        this.rowDto = row;
    }

    public StandardReportRowImpl populateResponse() {
        StandardReportRowImpl row = new StandardReportRowImpl();
        row.setRecipient(rowDto.getRecipient());
        row.setDeliveryStatus(rowDto.getDeliveryStatus());
        row.setQuestionLabel(rowDto.getQuestionLabel());
        row.setQuestionDateTime(rowDto.getQuestionDateTime());
        row.setAnswerLabel(rowDto.getAnswerLabel());
        row.setAnswerDateTime(rowDto.getAnswerDateTime());
        row.setAnswerText(rowDto.getAnswerText());
        row.setRecipientData(rowDto.getRecipientData());
        return row;
    }
}
