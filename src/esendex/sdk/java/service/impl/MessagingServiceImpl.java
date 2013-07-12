
package esendex.sdk.java.service.impl;

import java.util.Date;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.MessageCollectionRequestAssembler;
import esendex.sdk.java.model.domain.impl.MessageResultResponseAssembler;
import esendex.sdk.java.model.domain.request.SmsMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.model.transfer.message.MessageCollectionRequestDto;
import esendex.sdk.java.service.MessagingService;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.message.MessageDispatcherResource;

/**
 * A concrete MessagingService.
 */
public class MessagingServiceImpl 
		extends AbstractService implements MessagingService {
	
	/**
	 * Instantiates a new messaging service.
	 * @param authenticator the authenticator
	 */
	public MessagingServiceImpl(Authenticator authenticator) {
		super(authenticator);
	}

	@Override
	public MessageResultResponse sendMessage(
			String account, SmsMessageRequest message) throws EsendexException {
		
		SmsMessageCollectionRequest messages = 
			new SmsMessageCollectionRequest(account, message);
		
		return send(messages, null);
	}

	@Override
	public MessageResultResponse sendMessage(String account, 
			VoiceMessageRequest message) throws EsendexException {
		
		VoiceMessageCollectionRequest messages = 
			new VoiceMessageCollectionRequest(account, message);
		return send(messages, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MessageResultResponse sendMessages(
			SmsMessageCollectionRequest messages) throws EsendexException {
		
		return send(messages, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MessageResultResponse sendMessages(
			VoiceMessageCollectionRequest messages) throws EsendexException {
		
		return send(messages, null);
	}

	@Override
	public MessageResultResponse 
			sendScheduledMessage(String account, 
			SmsMessageRequest message, Date sendAt) throws EsendexException {

		SmsMessageCollectionRequest messages = 
			new SmsMessageCollectionRequest(account, message);
		return send(messages, sendAt);
	}

	@Override
	public MessageResultResponse sendScheduledMessage(
			String account, VoiceMessageRequest message, Date sendAt)
			throws EsendexException {
		
		VoiceMessageCollectionRequest messages = 
			new VoiceMessageCollectionRequest(account, message);
		return send(messages, sendAt);
	}

	@Override
	public MessageResultResponse sendScheduledMessages(
			SmsMessageCollectionRequest messages, Date sendAt)
			throws EsendexException {
		
		return send(messages, sendAt);
	}

	@Override
	public MessageResultResponse sendScheduledMessages(
			VoiceMessageCollectionRequest messages, Date sendAt)
			throws EsendexException {
		
		return send(messages, sendAt);
	}

	private MessageResultResponse send(SmsMessageCollectionRequest messages, 
			Date sendAt) throws EsendexException {
		
		return send(new MessageCollectionRequestAssembler(
				messages).createRequest(), sendAt);
	}

	private MessageResultResponse send(VoiceMessageCollectionRequest messages, 
			Date sendAt) throws EsendexException {

		return send(new MessageCollectionRequestAssembler(
				messages).createRequest(), sendAt);
	}
	
	private MessageResultResponse send(MessageCollectionRequestDto messages, 
			Date sendAt) throws EsendexException {
		
		messages.setSendat(sendAt);
		MessageDispatcherResource resource = 
			new MessageDispatcherResource(authenticator);		
		resource.setRequestObject(messages);
		resource.execute();

		return new MessageResultResponseAssembler(
				resource.getResponseObject()).createResponse();
				
	}
}
	
	
