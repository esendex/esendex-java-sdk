package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.FromAddress;
import esendex.sdk.java.model.domain.response.OptOutResponse;

import java.util.Date;

public class OptOutResponseImpl implements OptOutResponse {

    private String id;
    private Date receivedAt;
    private String accountReference;
    private FromAddress from;

    public OptOutResponseImpl() { }

    public String getId() {
        return id;
    }

    public Date getReceivedAt() { return receivedAt; }

    public String getAccountReference() { return accountReference; }

    public FromAddress getFrom() { return from; }

    protected void setId(String id) {
        this.id = id;
    }

    protected void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    protected void setAccountReference(String accountReference) { this.accountReference = accountReference; }

    protected void setFrom(FromAddress from) { this.from = from; }
}