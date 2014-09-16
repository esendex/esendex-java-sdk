
package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.MessageRequest;
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

	
	
}
