package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.request.OptOutRequest;

public class OptOutRequestImpl implements OptOutRequest {
    private String accountReference;
    private FromAddress fromAddress;

    @Override
    public String getAccountReference() {
        return accountReference;
    }

    @Override
    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    @Override
    public FromAddress getFromAddress() {
        return fromAddress;
    }

    @Override
    public void setFromAddress(FromAddress fromAddress) {
        this.fromAddress = fromAddress;
    }
}
