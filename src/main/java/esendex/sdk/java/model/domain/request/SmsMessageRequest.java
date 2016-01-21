
package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.MessageRequest;
import esendex.sdk.java.model.types.CharacterSet;
import esendex.sdk.java.model.types.MessageType;

public class SmsMessageRequest extends MessageRequest {

	/**
	 * 
	 * @param to
	 * @param body
	 */
	public SmsMessageRequest(String to, String body) {
		super(to, body, MessageType.SMS);
	}

	public SmsMessageRequest(String to, String body, CharacterSet characterSet) {
		super(to, body, MessageType.SMS, characterSet);
	}

	
	
}
