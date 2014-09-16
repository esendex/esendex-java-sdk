
package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.InboxMessageCollectionResponse;
import esendex.sdk.java.model.domain.response.InboxMessageResponse;

/**
 * A service for querying an Esendex Inbox.
 * All methods throw an EsendexException to indicate either a problem during 
 * the underlying connection or there was a none okay response. 
 * @author Mike Whittaker
 */
public interface InboxService {

	/**
	 * This operation will remove an individual message from an Inbox. As the
	 * message is identified by its GUID there is no additional need to specify
	 * which Account the message belongs to.
	 * @param id the message id
	 * @return true if the message has been deleted successfully otherwise false
	 * @throws EsendexException the esendex exception
	 */
	boolean deleteMessage(String id) throws EsendexException;

	/**
	 * Gets the message.
	 * @param id the id
	 * @return the message
	 * @throws EsendexException the esendex exception
	 */
	InboxMessageResponse getMessage(String id) throws EsendexException;
	
	/**
	 * Gets the messages.
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	InboxMessageCollectionResponse getMessages() throws EsendexException;
	
	/**
	 * Gets the messages.
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	InboxMessageCollectionResponse getMessages(
			int pageNumber, int pageSize) throws EsendexException;

	
	/**
	 * Gets the messages.
	 * @param accountReference the account reference
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	InboxMessageCollectionResponse getMessages(
			String accountReference) throws EsendexException;

	
	/**
	 * Gets the messages.
	 * @param accountReference the account reference
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @return the messages
	 * @throws EsendexException the esendex exception
	 */
	InboxMessageCollectionResponse getMessages(String accountReference, 
			int pageNumber, int pageSize) throws EsendexException;
	
	
	/**
	 * Mark message as read.
	 * @param id the id
	 * @return true, if successful
	 * @throws EsendexException the esendex exception
	 */
	boolean markMessageAsRead(String id) throws EsendexException;
	
	
	/**
	 * Mark message as unread.
	 * @param id the id
	 * @return true, if successful
	 * @throws EsendexException the esendex exception
	 */
	boolean markMessageAsUnread(String id) throws EsendexException;
	
}