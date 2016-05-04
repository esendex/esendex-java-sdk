package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.FromAddress;
import esendex.sdk.java.model.domain.request.OptOutRequest;
import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
import esendex.sdk.java.model.domain.response.OptOutResponse;

public interface OptOutService {

    /**
     * Gets an opt out.
     *
     * @param id the id
     * @return the opt out
     * @throws EsendexException the Esendex exception
     */
    OptOutResponse getOptOut(String id)
            throws EsendexException;

    /**
     * Gets opt outs.
     *
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the opt outs
     * @throws EsendexException the Esendex exception
     */
    OptOutCollectionResponse getOptOuts(int pageNumber, int pageSize)
            throws EsendexException;

    /**
     * Gets opt outs by account reference.
     *
     * @param account    the account
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the opt outs
     * @throws EsendexException the Esendex exception
     */
    OptOutCollectionResponse getOptOuts(String account, int pageNumber, int pageSize)
            throws EsendexException;

    /**
     * Gets opt outs by from address.
     *
     * @param from       the from address filter
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the opt outs
     * @throws EsendexException the Esendex exception
     */
    OptOutCollectionResponse getOptOuts(FromAddress from, int pageNumber, int pageSize)
            throws EsendexException;

    /**
     * Gets opt outs by account reference and from address.
     *
     * @param account    the account
     * @param from       the from address filter
     * @param pageNumber the page number
     * @param pageSize   the page size
     * @return the opt outs
     * @throws EsendexException the Esendex exception
     */
    OptOutCollectionResponse getOptOuts(String account, FromAddress from, int pageNumber, int pageSize)
            throws EsendexException;

    /**
     * Creates an opt out.
     *
     * @param optOutRequest the opt out to be created
     * @return the created opt out
     * @throws EsendexException the Esendex exception
     */
    OptOutResponse createOptOut(OptOutRequest optOutRequest)
            throws EsendexException;
}
