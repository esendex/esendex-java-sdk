
package esendex.sdk.java.service.resource.message;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;

/**
 * This operation will remove an individual message from an Inbox. 
 * As the message is identified by its GUID there is no additional need 
 * to specify which Account the message belongs to.
 * 
 * @author Mike Whittaker
 */
public class DeleteInboxMessageResource extends Resource {

	/**
	 * Instantiates a new delete inbox message resource.
	 * @param auth the authenticator
	 * @param id the id
	 */
	public DeleteInboxMessageResource(Authenticator auth, String id) {
		super(auth, null, id, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "inbox/messages/" + getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.DELETE;
	}

}
