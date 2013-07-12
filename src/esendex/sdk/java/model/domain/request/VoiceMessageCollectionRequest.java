package esendex.sdk.java.model.domain.request;

import java.util.List;

import esendex.sdk.java.model.domain.impl.MessageCollectionRequest;
import esendex.sdk.java.model.types.MessageLanguage;
import esendex.sdk.java.model.types.MessageType;

public class VoiceMessageCollectionRequest extends MessageCollectionRequest<VoiceMessageRequest> {

	private MessageLanguage messageLanguage;
	private Integer retries;

	public VoiceMessageCollectionRequest(
			String account, List<VoiceMessageRequest> messages) {
		super(account, messages, MessageType.VOICE);
	}

	public VoiceMessageCollectionRequest(
			String account, VoiceMessageRequest message) {
		super(account, message, MessageType.VOICE);
	}

	public MessageLanguage getMessageLanguage() {
		return messageLanguage;
	}

	public Integer getRetries() {
		return retries;
	}

	public void setMessageLanguage(MessageLanguage messageLanguage) {
		this.messageLanguage = messageLanguage;
	}

	public void setRetries(Integer retries) {
		this.retries = retries;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nmessageLanguage: " + messageLanguage +
			"\nretries: " + retries;
	}

}
