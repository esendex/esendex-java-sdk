package esendex.sdk.java.model.domain.response;

import esendex.sdk.java.model.domain.impl.StandardReportRowImpl;

import java.util.List;

public interface StandardReportResponse {
    List<StandardReportRowImpl> getRows();
}
