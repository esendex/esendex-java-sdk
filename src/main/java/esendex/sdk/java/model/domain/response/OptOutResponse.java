package esendex.sdk.java.model.domain.response;

import esendex.sdk.java.model.domain.impl.FromAddress;

import java.util.Date;

public interface OptOutResponse {

    String getId();

    Date getReceivedAt();

    String getAccountReference();

    FromAddress getFrom();
}