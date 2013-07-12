
package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.SentMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.SentMessageResponse;

/**
 * A SentService is a service for querying Sent messages. 
 * All methods throw an EsendexException to indicate either a problem during 
 * the underlying connection or there was a none okay response. 
 */
public interface SentService {

	/**
	 * Gets the message.
	 * @param id the id
	 * @return the message
	 * @throws EsendexException the esendex exception
	 */
	SentMessageResponse getMessage(String id) throws EsendexException;

	/**
	 * Gets the messages.
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	SentMessageCollectionResponse getMessages(int pageNumber, int pageSize)
			throws EsendexException;

	/**
	 * Gets the messages.
	 * @param account the account
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	SentMessageCollectionResponse getMessages(String account, int pageNumber,
			int pageSize) throws EsendexException;

}