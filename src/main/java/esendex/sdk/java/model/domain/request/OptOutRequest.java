package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.FromAddress;

public interface OptOutRequest {
    String getAccountReference();

    void setAccountReference(String accountReference);

    FromAddress getFromAddress();

    void setFromAddress(FromAddress fromAddress);
}
