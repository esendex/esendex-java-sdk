
package esendex.sdk.java.service;

import java.util.Date;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.request.SmsMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.SmsMessageRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageCollectionRequest;
import esendex.sdk.java.model.domain.request.VoiceMessageRequest;
import esendex.sdk.java.model.domain.response.MessageResultResponse;

/**
 * A MessagingService is a service for sending SMS or voice messages.
 * All methods throw an EsendexException to indicate either a problem during 
 * the underlying connection or there was a none okay response. 
 * 
 * @author Mike Whittaker
 */
public interface MessagingService {

	MessageResultResponse sendMessage(String account, SmsMessageRequest message)
			throws EsendexException;

	MessageResultResponse sendMessage(String account, VoiceMessageRequest message)
			throws EsendexException;

	MessageResultResponse sendMessages(SmsMessageCollectionRequest messages)
			throws EsendexException;

	MessageResultResponse sendMessages(VoiceMessageCollectionRequest messages)
			throws EsendexException;

	MessageResultResponse sendScheduledMessage(String account, SmsMessageRequest message, Date sendAt)
			throws EsendexException;

	MessageResultResponse sendScheduledMessage(String account, VoiceMessageRequest message, Date sendAt)
			throws EsendexException;

	MessageResultResponse sendScheduledMessages(SmsMessageCollectionRequest messages, Date sendAt)
			throws EsendexException;

	MessageResultResponse sendScheduledMessages(VoiceMessageCollectionRequest messages, Date sendAt)
			throws EsendexException;

}