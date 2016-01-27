
package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.CharacterSet;
import esendex.sdk.java.model.types.MessageType;

public abstract class MessageRequest extends BaseMessageRequest {

	private CharacterSet characterSet;
	private String to;
	private String body;	
	
	public MessageRequest(String to, String body, MessageType type) {
		super(type);
		this.to = to;
		this.body = body;
		this.characterSet = CharacterSet.GSM;
	}

	public MessageRequest(String to, String body, MessageType type, CharacterSet characterSet) {
		super(type);
		this.to = to;
		this.body = body;
		this.characterSet = characterSet;
	}

	public String getTo() {
		return to;
	}

	public String getBody() {
		return body;
	}

	public CharacterSet getCharacterSet() {	return characterSet;}

	public void setTo(String to) {
		this.to = to;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public void setCharacterSet(CharacterSet characterSet) { this.characterSet = characterSet; }
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
