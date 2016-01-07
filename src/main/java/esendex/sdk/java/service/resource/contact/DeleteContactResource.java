
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;

/**
 * This operation will remove an entry from a Users contacts.
 * There is no response generated for this operation.
 *
 * @author Mike Whittaker
 */
public class DeleteContactResource extends Resource {

	/**
	 * Instantiates a new delete contact resource.
	 * @param auth the authenticator
	 * @param id the id
	 */
	public DeleteContactResource(Authenticator auth, String id) {
		super(auth, null, id, null, "2.0");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "contacts/" + getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.DELETE;
	}

}
