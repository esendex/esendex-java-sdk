
package esendex.sdk.java.service.resource.message;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;

/**
 * This operation will mark an individual Inbox Message as having been read 
 * or unread. The PUT request does not require the Message Header 
 * object to be included in the request body.
 * 
 * @author Mike Whittaker
 */
public class UpdateMessageStatusResource extends Resource {
	
	/**
	 * Instantiates a new update message status resource.
	 * @param auth the authenticator
	 * @param id the id
	 * @param query the query
	 */
	public UpdateMessageStatusResource(
			Authenticator auth, String id, HttpQuery query) {
		super(auth, null, id, query);
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
		return HttpRequestMethod.PUT;
	}

}
