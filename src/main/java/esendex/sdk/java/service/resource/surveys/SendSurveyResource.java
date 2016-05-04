package esendex.sdk.java.service.resource.surveys;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.domain.request.RecipientRequest;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.BaseSurveysResource;

public class SendSurveyResource extends BaseSurveysResource<RecipientsDto> {

    /**
     * Instantiates a new creates the contact resource.
     * @param auth the authenticator
     * @param id the survey id
     */
    public SendSurveyResource(Authenticator auth, String id) {
        super(auth, id, null, "1.0");
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