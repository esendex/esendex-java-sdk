package esendex.sdk.java.model.domain.response;

import java.util.List;

import esendex.sdk.java.model.domain.impl.Pageable;

public interface SentMessageCollectionResponse extends Pageable {

	List<SentMessageResponse> getMessages();
	
}