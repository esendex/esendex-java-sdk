package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.StandardReportResponse;

import java.util.List;

public class StandardReportResponseImpl implements StandardReportResponse {
    private List<StandardReportRowImpl> rows;

    public List<StandardReportRowImpl> getRows() {
        return rows;
    }

    public void setRows(List<StandardReportRowImpl> rows) {
        this.rows = rows;
    }
}
