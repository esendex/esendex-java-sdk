package esendex.sdk.java.model.domain.impl;

import java.util.Iterator;
import java.util.List;


public class MessageCollectionResponseImpl<T extends MessageResponse> extends PageableImpl implements Iterable<T> {

	private List<T> messages;
	
	public MessageCollectionResponseImpl(List<T> messages) {
		this.messages = messages;
	}

	public List<T> getMessages() {
		return messages;
	}
	
	@Override
	public Iterator<T> iterator() {
		return null;
	}
	
}
