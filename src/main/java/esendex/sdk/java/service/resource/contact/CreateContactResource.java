
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.model.transfer.contact.ContactResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlRequesterResponderResource;

/**
 * This operation will add a new Contact based on the request submitted and
 * return a Contact response.
 * @author Mike Whittaker
 */
public class CreateContactResource extends XmlRequesterResponderResource<ContactDto, ContactResponseDto> {

	/**
	 * Instantiates a new creates the contact resource.
	 * @param auth the authenticator
	 */
	public CreateContactResource(Authenticator auth) {
		super(auth, null, null, null, "2.0");
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


