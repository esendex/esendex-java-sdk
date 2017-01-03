package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.surveys.StandardReportDto;
import esendex.sdk.java.model.transfer.surveys.StandardReportRowDto;

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

        for (StandardReportRowDto row : dto.getRows()) {
            rows.add(new StandardReportRowAssembler(row).populateResponse());
        }

        response.setRows(rows);
    }
}

