
package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.MessageType;

public abstract class MessageRequest extends BaseMessageRequest {

	private String to;	
	private String body;	
	
	public MessageRequest(String to, String body, MessageType type) {
		super(type);
		this.to = to;
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public String getBody() {
		return body;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nto: " + to +
			"\nbody: " + body;
	}

}
