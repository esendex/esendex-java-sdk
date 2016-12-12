package esendex.sdk.java.model.domain.response;

import java.util.List;

import esendex.sdk.java.model.domain.impl.Pageable;

public interface InboxMessageCollectionResponse extends Pageable {

	List<InboxMessageResponse> getMessages();
	
}