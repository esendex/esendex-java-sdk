
package esendex.sdk.java.service.resource.access;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.session.SessionDto;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.resource.base.XmlResponderResource;

/**
 * The Session Constructor resource is used to generate a unique Esendex API 
 * session GUID. A successful HTTP POST request to the Constructor URI requires 
 * a valid Basic Authentication header of Base64 encoded username and password 
 * to be supplied.
 * 
 * @author Mike Whittaker
 */
public class SessionResource extends XmlResponderResource<SessionDto> {
	
	/**
	 * The session resource must be authenticated with Basic
	 * Authentication. Thereafter other resources may be authenticated with a
	 * SessionAuthenticator.
	 * @param auth the authenticator
	 */
	public SessionResource(BasicAuthenticator auth) {
		super(auth, null, null, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "session/constructor";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.POST;
	}

}
