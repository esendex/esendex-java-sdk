
package esendex.sdk.java.service.resource.message;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

/**
 * This operation will return a paged response of all inbound messages to one
 * Account that the user has permissions to view. The Account is specified by
 * adding the Reference to the URI.
 * @author Mike Whittaker
 */
public class RetrieveInboxMessagesForOneAccountResource 
		extends XmlResponderResource<MessageCollectionResponseDto> {
		
	/**
	 * Instantiates a new retrieve inbox messages for one account resource.
	 * @param auth the authenticator
	 * @param account the account
	 * @param query the query
	 */
	public RetrieveInboxMessagesForOneAccountResource(Authenticator auth, 
			String account, HttpQuery query) {
		super(auth, account, null, query);
	}
	
	/**
	 * Instantiates a new retrieve inbox messages for one account resource.
	 * @param auth the authenticator
	 * @param account the account
	 */
	public RetrieveInboxMessagesForOneAccountResource(Authenticator auth, 
			String account) {
		this(auth, account, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.GET;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "inbox/" + getAccount() + "/messages";
	}
	
}
