package esendex.sdk.java.service.resource.optout;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.optout.OptOutCreateResponseDto;
import esendex.sdk.java.model.transfer.optout.OptOutRequestDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlRequesterResponderResource;

public class CreateOptOutResource extends XmlRequesterResponderResource<OptOutRequestDto, OptOutCreateResponseDto> {

    public CreateOptOutResource(Authenticator auth) {
        super(auth, null, null, null, "1.0");
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
        return HttpRequestMethod.POST;
    }
}