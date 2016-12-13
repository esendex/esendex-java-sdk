package esendex.sdk.java.service.impl;


import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.MetaData;
import esendex.sdk.java.model.domain.impl.RecipientsRequestAssembler;
import esendex.sdk.java.model.domain.request.RecipientRequest;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;
import esendex.sdk.java.service.SurveySendService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.surveys.SurveySendResource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SurveySendServiceImpl extends AbstractService implements SurveySendService {

    public SurveySendServiceImpl(Authenticator authenticator) {
        super(authenticator);
    }

    public void Send(String surveyId, RecipientRequest recipient) throws EsendexException {

        SurveySendResource resource = new SurveySendResource(authenticator, surveyId);

        checkArrayListForDuplicates(recipient.getMetaData());
        RecipientsDto recipientDto = new RecipientsRequestAssembler().createRequest(recipient);
        resource.setRequestObject(recipientDto);

        resource.execute();
    }
    
    private void checkArrayListForDuplicates(List<MetaData> metaData) throws EsendexException {
        ArrayList<String> alreadyKeys = new ArrayList<String>();

        for(Iterator<MetaData> i = metaData.iterator(); i.hasNext(); ) {
            MetaData item = i.next();

            for (String string : alreadyKeys) {
                if(string == item.getName())
                    throw new EsendexException("MetaData fields collection cannot contain duplicate fields");
                alreadyKeys.add(item.getName());
            }
        }
    }
}
