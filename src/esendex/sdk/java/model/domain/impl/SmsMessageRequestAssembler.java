package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.transfer.message.MessageRequestDto;

public class SmsMessageRequestAssembler extends MessageRequestAssembler {
		
	public SmsMessageRequestAssembler(SmsMessageRequest request) {
		super(request);
	}
	
	public MessageRequestDto createRequest() {
		
		MessageRequestDto dto = new MessageRequestDto();		
		populateRequest(dto);		
		return dto;
	}
	
	@Override
	protected void populateRequest(MessageRequestDto dto) {
		super.populateRequest(dto);
	}
	
}
