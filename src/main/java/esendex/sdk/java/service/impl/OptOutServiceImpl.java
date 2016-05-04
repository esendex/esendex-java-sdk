package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.domain.impl.OptOutRequestAssembler;
import esendex.sdk.java.model.domain.impl.OptOutResponseAssembler;
import esendex.sdk.java.model.domain.request.OptOutRequest;
import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.model.transfer.optout.OptOutCreateResponseDto;
import esendex.sdk.java.model.transfer.optout.OptOutRequestDto;
import esendex.sdk.java.service.OptOutService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.optout.CreateOptOutResource;
import esendex.sdk.java.service.resource.optout.RetrieveOptOutResource;
import esendex.sdk.java.service.resource.optout.RetrieveOptOutsResource;

public class OptOutServiceImpl extends AbstractService implements OptOutService {

    /**
     * Instantiates a new opt outs service.
     *
     * @param authenticator the authenticator
     */
    public OptOutServiceImpl(Authenticator authenticator) {
        super(authenticator);
    }

    /**
     * {@inheritDoc}
     */
    public OptOutResponse getOptOut(String id) throws EsendexException {
        RetrieveOptOutResource resource = new RetrieveOptOutResource(authenticator, id);
        resource.execute();

        return new OptOutResponseAssembler().createResponse(resource.getResponseObject());
    }

    /**
     * {@inheritDoc}
     */
    public OptOutCollectionResponse getOptOuts(int pageNumber, int pageSize) throws EsendexException {
        HttpQuery query = new HttpQuery();
        query.addParameter(HttpQuery.START_INDEX, pageNumber);
        query.addParameter(HttpQuery.COUNT, pageSize);

        RetrieveOptOutsResource resource = new RetrieveOptOutsResource(authenticator, query);
        resource.execute();

        return new OptOutResponseAssembler().createCollectionResponse(resource.getResponseObject());
    }

    /**
     * {@inheritDoc}
     */
    public OptOutCollectionResponse getOptOuts(String account, int pageNumber, int pageSize) throws EsendexException {
        HttpQuery query = new HttpQuery();
        query.addParameter(HttpQuery.START_INDEX, pageNumber);
        query.addParameter(HttpQuery.COUNT, pageSize);
        query.addParameter(HttpQuery.ACCOUNT_REFERENCE, account);

        RetrieveOptOutsResource resource = new RetrieveOptOutsResource(authenticator, query);
        resource.execute();

        return new OptOutResponseAssembler().createCollectionResponse(resource.getResponseObject());
    }

    /**
     * {@inheritDoc}
     */
    public OptOutResponse createOptOut(OptOutRequest optOutRequest) throws EsendexException {
        CreateOptOutResource resource = new CreateOptOutResource(authenticator);
        OptOutRequestDto optOutDto = new OptOutRequestAssembler().createOptOutDto(optOutRequest);

        resource.setRequestObject(optOutDto);
        resource.execute();

        OptOutCreateResponseDto resp = resource.getResponseObject();
        return new OptOutResponseAssembler().createResponse(resp.getOptOut());
    }
}
