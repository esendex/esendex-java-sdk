
package esendex.sdk.java.service.resource.contact;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.contact.ContactDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

/**
 * This operation returns a contact response for an individual contact 
 * identified by GUID.
 * 
 * @author Mike Whittaker
 */
public class RetrieveContactResource extends XmlResponderResource<ContactDto> { 

	/**
	 * Instantiates a new retrieve contact resource.
	 * @param auth the authenticator
	 * @param id the id
	 */
	public RetrieveContactResource(Authenticator auth, String id) {
		super(auth, null, id, null);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		String child =  "contacts/" + getId();
		return child;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.GET;
	}
	
}
