
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlRequesterResponderResource;

/**
 * This operation will amend an existing contact.
 * 
 * @author Mike Whittaker
 */
public class UpdateContactResource extends XmlRequesterResponderResource<ContactDto, ContactDto> {

	/**
	 * Instantiates a new update contact resource.
	 * @param auth the authenticator
	 * @param id the id
	 */
	public UpdateContactResource(Authenticator auth, String id) {
		super(auth, null, id, null);
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
		return HttpRequestMethod.PUT;
	}

}
