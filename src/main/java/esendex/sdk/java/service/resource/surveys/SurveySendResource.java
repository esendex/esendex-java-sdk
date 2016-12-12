package esendex.sdk.java.service.resource.surveys;

import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;
import esendex.sdk.java.service.resource.base.XmlRequester;

public class SurveySendResource extends Resource {

    private XmlRequester<RecipientsDto> requester;
    private static EsendexProperties props = EsendexProperties.instance();

    /**
     * Instantiates a new creates the contact resource.
     * @param auth the authenticator
     * @param id the survey id
     */
    public SurveySendResource(Authenticator auth, String id) {
        super(auth, id, null, "1.0", props.getProperty(EsendexProperties.Key.SURVEYS_DOMAIN), props.getProperty(EsendexProperties.Key.SECURE).equals("true"));
    }

    /**
     * Sets the request object.
     * @param recipientsDto the new request object
     */
    public void setRequestObject(RecipientsDto recipientsDto) {
        this.requester = new XmlRequester<>(recipientsDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getRequestData() {
        if(requester == null) {
            return "";
        }
        return requester.getRequestData();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected String getEndpointChild() {
        return "surveys/" + getId() + "/send";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected HttpRequestMethod getRequestMethod() {
        return HttpRequestMethod.POST;
    }

}