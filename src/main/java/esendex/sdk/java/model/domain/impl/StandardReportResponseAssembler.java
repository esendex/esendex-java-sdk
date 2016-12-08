package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.surveys.StandardReportDto;
import esendex.sdk.java.model.transfer.surveys.StandardReportRowDto;
import esendex.sdk.java.model.transfer.surveys.SurveyReportErrorDto;

import java.util.ArrayList;
import java.util.List;

public class StandardReportResponseAssembler {

    private final StandardReportDto dto;

    public StandardReportResponseAssembler(StandardReportDto dto) {
        this.dto = dto;
    }

    public StandardReportResponseImpl createResponse() {
        StandardReportResponseImpl response = new StandardReportResponseImpl();
        populateResponse(response);
        return response;
    }

    private void populateResponse(StandardReportResponseImpl response) {
        List<StandardReportRowImpl> rows = new ArrayList<>();
        List<SurveyReportErrorImpl> errors = new ArrayList<>();

        for (StandardReportRowDto row : dto.getRows()) {
            rows.add(new StandardReportRowAssembler(row).populateResponse());
        }

        for (SurveyReportErrorDto errorDto : dto.getErrors()) {
            SurveyReportErrorImpl error = new SurveyReportErrorImpl();
            error.setCode(errorDto.getCode());
            error.setDescription(errorDto.getDescription());
            errors.add(error);
        }

        response.setRows(rows);
        response.setErrors(errors);
    }
}

