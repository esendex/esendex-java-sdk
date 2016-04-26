package esendex.sdk.java.service.resource.optout;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.optout.OptOutResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

public class RetrieveOptOutResource
        extends XmlResponderResource<OptOutResponseDto> {

    /**
     * Instantiates a new retrieve contact resource.
     * @param auth the authenticator
     * @param id the opt out id
     */
    public RetrieveOptOutResource(Authenticator auth, String id) {
        super(auth, null, id, null, "1.0");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getEndpointChild() {
        return "optouts/" + getId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HttpRequestMethod getRequestMethod() {
        return HttpRequestMethod.GET;
    }

}
