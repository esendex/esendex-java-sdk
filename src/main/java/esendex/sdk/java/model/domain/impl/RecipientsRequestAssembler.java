package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.request.RecipientRequest;
import esendex.sdk.java.model.transfer.surveys.RecipientDto;
import esendex.sdk.java.model.transfer.surveys.RecipientsDto;

import java.util.ArrayList;
import java.util.List;


public class RecipientsRequestAssembler  {

    private RecipientDto createSingleRequest(RecipientRequest r) {

        RecipientDto dto = new RecipientDto();

        dto.setPhonenumber(r.getPhonenumber());
        dto.setTemplateFields(new TemplateFieldRequestAssembler().create(r.getTemplateFields()));
        dto.setMetaData(new MetaDataRequestAssembler().create(r.getMetaData()));

        return dto;
    }

    public RecipientsDto createRequest(RecipientRequest r) {

        RecipientsDto dto = new RecipientsDto();

        List<RecipientDto> recipients = new ArrayList<>();
        recipients.add(createSingleRequest(r));

        dto.setRecipients(recipients);

        return dto;
    }
}

