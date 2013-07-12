package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;

public class MessageCollectionResponseAssembler {
	
	protected MessageCollectionResponseDto collection;
	
	public MessageCollectionResponseAssembler(MessageCollectionResponseDto dtos) {
		this.collection = dtos;
	}

	public void populateResponse(MessageCollectionResponseImpl<?> response) {
		response.setCount(collection.getCount());
		response.setStartIndex(collection.getStartindex());
		response.setTotalCount(collection.getTotalcount());
	}

}
