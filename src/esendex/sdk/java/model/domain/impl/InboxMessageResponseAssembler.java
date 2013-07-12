package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.InboxMessageResponse;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;

public class InboxMessageResponseAssembler extends MessageResponseAssembler {

	public InboxMessageResponseAssembler(MessageResponseDto dto) {
		super(dto);
	}
	
	public InboxMessageResponse createResponse() {
		InboxMessageResponseImpl response = new InboxMessageResponseImpl();
		populateResponse(response);
		return response;
	}
	
	protected void populateResponse(InboxMessageResponseImpl response) {
		super.populateResponse(response);
		response.setReadAt(dto.getReadat());
		response.setReadBy(dto.getReadby());
		response.setReceivedAt(dto.getReceivedat());
	}
}
