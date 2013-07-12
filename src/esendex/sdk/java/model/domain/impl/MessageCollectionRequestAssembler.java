package esendex.sdk.java.model.domain.impl;

import java.util.ArrayList;
import java.util.List;

import esendex.sdk.java.model.domain.request.SmsMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageRequest;
import esendex.sdk.java.model.transfer.message.MessageCollectionRequestDto;
import esendex.sdk.java.model.transfer.message.MessageRequestDto;

public class MessageCollectionRequestAssembler {

	private MessageCollectionRequest<?> request;
	private MessageCollectionRequestDto dto;
		
	protected void populateRequest(MessageCollectionRequestDto dto) {
		dto.setAccountreference(request.getAccountReference());
		dto.setFrom(request.getFrom());
		dto.setType(request.getMessageType());
		dto.setValidity(request.getValidity());
	}
	
	public MessageCollectionRequestAssembler(
			VoiceMessageCollectionRequest request) {
		
		this.request = request;	
		List<MessageRequestDto> messages = new ArrayList<MessageRequestDto>();
		for (VoiceMessageRequest m : request.getMessages()) {
			messages.add(new VoiceMessageRequestAssembler(m).createRequest());
		}	
		dto = new MessageCollectionRequestDto(messages);	
		populateRequest(dto);
		dto.setLang(request.getMessageLanguage());
		dto.setRetries(request.getRetries());	
	}
	
	public MessageCollectionRequestAssembler(SmsMessageCollectionRequest request) {

		this.request = request;
		List<MessageRequestDto> messages = new ArrayList<MessageRequestDto>();
		for (SmsMessageRequest m : request.getMessages()) {
			messages.add(new SmsMessageRequestAssembler(m).createRequest());
		}	
		dto = new MessageCollectionRequestDto(messages);
		populateRequest(dto);
	}

	public MessageCollectionRequestDto createRequest() {
		return dto;
	}
}
