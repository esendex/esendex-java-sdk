package esendex.sdk.java.service.resource.optout;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.optout.OptOutCollectionResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

public class RetrieveOptOutsResource
        extends XmlResponderResource<OptOutCollectionResponseDto> {

    /**
     * Instantiates a new retrieve contact resource.
     *
     * @param auth the authenticator
     * @param query the query
     */
    public RetrieveOptOutsResource(Authenticator auth, HttpQuery query) {
        super(auth, null, null, query);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getEndpointChild() {
        return "optouts";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HttpRequestMethod getRequestMethod() {
        return HttpRequestMethod.GET;
    }

}
