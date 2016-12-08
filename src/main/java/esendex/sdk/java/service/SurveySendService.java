package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.RecipientRequest;

public interface SurveySendService {
    void Send(String surveyId, RecipientRequest recipient) throws EsendexException;
}
