package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.OptOutResponse;

public interface OptOutService {

    /**
     * Gets an opt out.
     * @param id the id
     * @return the opt out
     * @throws EsendexException the esendex exception
     */
    OptOutResponse getOptOut(String id) throws EsendexException;
}
