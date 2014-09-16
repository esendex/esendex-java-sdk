package esendex.sdk.java.model.domain.impl;

import java.util.List;

import esendex.sdk.java.model.domain.response.SentMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.SentMessageResponse;

public class SentMessageCollectionResponseImpl 
		extends MessageCollectionResponseImpl<SentMessageResponse> 
		implements SentMessageCollectionResponse {

	public SentMessageCollectionResponseImpl(List<SentMessageResponse> messages) {
		super(messages);
	}



}
