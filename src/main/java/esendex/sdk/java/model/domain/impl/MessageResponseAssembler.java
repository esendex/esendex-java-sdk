package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.message.BatchDto;
import esendex.sdk.java.model.transfer.message.BodyDto;
import esendex.sdk.java.model.transfer.message.MessageContactDto;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;

public abstract class MessageResponseAssembler {

	protected MessageResponseDto dto;

	public MessageResponseAssembler(MessageResponseDto dto) {
		this.dto = dto;
	}
	
	protected void populateResponse(MessageResponseImpl response) {
		response.setId(dto.getId());
		response.setBody(createBody(dto.getBody()));
		response.setFrom(createContact(dto.getFrom()));
		response.setParts(dto.getParts());
		response.setReference(dto.getReference());
		response.setStatus(dto.getStatus());
		response.setSummary(dto.getSummary());
		response.setTo(createContact(dto.getTo()));
		response.setType(dto.getType());
		response.setBatch(createBatch(dto.getBatch()));
	}

	private MessageBody createBody(BodyDto dto) {
		MessageBody body = new MessageBody();
		body.setBodyText(dto.getText());
		return body;
	}

	private Identity createBatch(BatchDto dto) {
		if(dto == null)
			return null;

		Identity batch = new Identity();
		batch.setId(dto.getId());
		batch.setUri(dto.getUri());
		return batch;
	}
	
	private MessageContact createContact(MessageContactDto dto) {
		MessageContact contact = new MessageContact();
		contact.setDisplayName(dto.getDisplayname());
		contact.setPhoneNumber(dto.getPhonenumber());
		return contact;
	}
	
}
