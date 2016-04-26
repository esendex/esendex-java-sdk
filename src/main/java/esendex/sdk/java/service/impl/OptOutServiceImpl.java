package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.OptOutResponseAssembler;
import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.service.OptOutService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.optout.RetrieveOptOutResource;

public class OptOutServiceImpl extends AbstractService implements OptOutService {

    /**
     * Instantiates a new opt outs service.
     * @param authenticator the authenticator
     */
    public OptOutServiceImpl(Authenticator authenticator) { super(authenticator); }

    /**
     * {@inheritDoc}
     */
    public OptOutResponse getOptOut(String id) throws EsendexException {

        RetrieveOptOutResource resource = new RetrieveOptOutResource(authenticator, id);
        resource.execute();
        return new OptOutResponseAssembler().createResponse(resource.getResponseObject());
    }
}
