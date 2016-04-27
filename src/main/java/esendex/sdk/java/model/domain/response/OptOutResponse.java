package esendex.sdk.java.model.domain.response;

import java.util.Date;

public interface OptOutResponse {

    String getId();

    Date getReceivedAt();

    String getAccountReference();

    FromAddress getFrom();
}