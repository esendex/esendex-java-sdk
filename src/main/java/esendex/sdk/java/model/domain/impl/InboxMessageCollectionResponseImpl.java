package esendex.sdk.java.model.domain.impl;

import java.util.List;

import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;


public class InboxMessageCollectionResponseImpl 
		extends MessageCollectionResponseImpl<InboxMessageResponse> 
		implements InboxMessageCollectionResponse {

	public InboxMessageCollectionResponseImpl(List<InboxMessageResponse> messages) {
		super(messages);
	}
	
}
