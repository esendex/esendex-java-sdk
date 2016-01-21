
package esendex.sdk.java.model.domain.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import esendex.sdk.java.model.types.MessageType;

/**
 * The Class MessageCollectionRequest.
 * @param <T> the generic type
 */
public abstract class MessageCollectionRequest<T extends MessageRequest> extends BaseMessageRequest implements Iterable<T> {
	
	private String accountReference;
	private List<T> messages;

	/**
	 * Instantiates a new message collection request.
	 * @param account the esendex account
	 * @param messages the messages
	 * @param type the message type eg voice or sms 
	 */
	public MessageCollectionRequest(
			String account, List<T> messages, MessageType type) {
		super(type);
		if (account == null || messages == null) throw new NullPointerException(
				"'account' and 'messages' are required fields");
		if (messages.isEmpty()) throw new IllegalArgumentException(
				"'messages' must not be empty");
		this.accountReference = account;
		this.messages = messages;
	}
	
	/**
	 * Instantiates a new message collection request.
	 * @param account the account
	 * @param message the message
	 */
	public MessageCollectionRequest(
			String account, T message, MessageType type) {
		super(type);
		if (account == null || message == null) throw new NullPointerException(
			"'account' and 'message' are required fields");
		List<T> list = new ArrayList<T>();
		list.add(message);
		this.accountReference = account;
		this.messages = list;
	}

	public String getAccountReference() {
		return accountReference;
	}

	public List<T> getMessages() {
		return messages;
	}

	public void setAccountReference(String accountReference) {
		this.accountReference = accountReference;
	}

	public void setMessages(List<T> messages) {
		this.messages = messages;
	}

	@Override
	public Iterator<T> iterator() {
		return messages.iterator();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + 
			"\naccountReference: " + accountReference +
			"\nmessages: " + messages;
	}
	
}
