
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.contact.ContactCollectionDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlRequesterResource;

/**
 * This operation allows the creation of multiple Contacts with one request POST
 * to the Contacts resource. There is only an HTTP Status Code result from this
 * operation.
 * 
 * @author Mike Whittaker
 */
public class CreateContactsResource extends XmlRequesterResource<ContactCollectionDto> {

	/**
	 * Instantiates a new creates the contacts resource.
	 * @param auth the authenticator
	 */
	public CreateContactsResource(Authenticator auth) {
		super(auth, null, null, null);
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
		return HttpRequestMethod.POST;
	}

}
