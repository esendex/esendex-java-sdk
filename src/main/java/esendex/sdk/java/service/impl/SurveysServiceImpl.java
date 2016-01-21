package esendex.sdk.java.service.impl;


import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.RecipientsRequestAssembler;
import esendex.sdk.java.model.domain.request.RecipientRequest;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;
import esendex.sdk.java.service.SurveysService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.surveys.SendSurveyResource;

public class SurveysServiceImpl
        extends AbstractService implements SurveysService {

    /**
     * Instantiates a new abstract service.
     *
     * @param authenticator the authenticator
     */
    public SurveysServiceImpl(Authenticator authenticator) {
        super(authenticator);
    }

    public void Send(String surveyId, RecipientRequest recipient) throws EsendexException {

        SendSurveyResource resource = new SendSurveyResource(authenticator, surveyId);

        RecipientsDto recipientDto = new RecipientsRequestAssembler().createRequest(recipient);
        resource.setRequestObject(recipientDto);

        resource.execute();
    }
}
