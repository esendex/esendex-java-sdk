package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.message.MessageRequestDto;

public abstract class MessageRequestAssembler {

	private MessageRequest request;
	
	public MessageRequestAssembler(MessageRequest request) {
		this.request = request;
	}
	
	protected void populateRequest(MessageRequestDto dto) {		
		dto.setTo(request.getTo());
		dto.setBody(request.getBody());
		dto.setFrom(request.getFrom());
		dto.setValidity(request.getValidity());
		dto.setType(request.getMessageType());
	}
}
