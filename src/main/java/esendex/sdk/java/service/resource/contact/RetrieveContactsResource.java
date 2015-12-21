
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

/**
 * This operation will return a ContactCollection response listing  a
 * user's stored contacts in a paged fashion.
 *
 * @author Mike Whittaker
 */
public class RetrieveContactsResource extends
		XmlResponderResource<ContactCollectionDto> {

	/**
	 * Instantiates a new retrieve contacts resource.
	 * @param auth the authenticator
	 * @param query the query
	 */
	public RetrieveContactsResource(Authenticator auth, HttpQuery query) {
		super(auth, null, null, query, "2.0");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "contacts";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.GET;
	}

}
