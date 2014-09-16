
package esendex.sdk.java.service.resource.access;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;

/**
 * This resource is used to provide a simple method of checking if a user�s 
 * credentials or session ID are valid to access the Esendex API. It is a 
 * safe method of performing an operation on a resource with no side-effects.
 * 
 * @author Mike Whittaker
 */
public class AccessCheckResource extends Resource {
	
	/**
	 * Instantiates a new access check resource.
	 * @param auth the authenticator
	 * @param account the account
	 */
	public AccessCheckResource(Authenticator auth, String account) {
		super(auth, account, null, null);
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
		return "Account/" + getAccount() + "/accesscheck";
	}	

}
