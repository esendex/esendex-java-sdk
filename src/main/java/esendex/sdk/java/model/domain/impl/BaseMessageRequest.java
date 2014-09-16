
package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.MessageType;

/**
 * A BaseMessageRequest is the base class for all Message requests whether
 * that is a collection or a single message.
 */
public abstract class BaseMessageRequest {

	private String from;	
	private Integer validity;
	private MessageType messageType;	

	public BaseMessageRequest(MessageType type) {
		this.messageType = type;
	}

	public MessageType getMessageType() {
		return messageType;
	}

	public String getFrom() {
		return from;
	}

	public Integer getValidity() {
		return validity;
	}

	/**
	 * Sets the alphanumeric originator for the message to 
	 * appear to originate from.
	 * @param from the originator
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Sets the validity period for a message in hours (defaults to 
	 * 0 which indicates the MAX allowed).
	 * @param validity the period in hours
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	public void setMessageType(MessageType messageType) {
		this.messageType = messageType;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			"from: " + from +
			"\nvalidity: " + validity +
			"\nmessageType: " + messageType;
	}
	
	
}
