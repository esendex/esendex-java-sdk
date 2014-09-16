package esendex.sdk.java.model.domain.impl;

import java.util.ArrayList;
import java.util.List;

import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;

public class InboxMessageCollectionResponseAssembler extends MessageCollectionResponseAssembler {

	public InboxMessageCollectionResponseAssembler(MessageCollectionResponseDto dto) {
		super(dto);
	}
	
	public InboxMessageCollectionResponse createResponse() {
		
		List<InboxMessageResponse> messages = new ArrayList<InboxMessageResponse>();
		for (MessageResponseDto dto : collection) {
			InboxMessageResponseAssembler assembler = new InboxMessageResponseAssembler(dto);
			messages.add(assembler.createResponse());
		}
		
		InboxMessageCollectionResponseImpl response = new InboxMessageCollectionResponseImpl(messages);
		populateResponse(response);
		return response;
	}

	protected void populateResponse(InboxMessageCollectionResponseImpl response) {
		super.populateResponse(response);
	}
}
