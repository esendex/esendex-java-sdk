
package esendex.sdk.java.service.auth;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.transfer.session.SessionDto;
import esendex.sdk.java.service.resource.access.SessionResource;

/**
 * A (RFC2617) Basic authenticator that writes out the Http header to 
 * authenticate a request.
 * In contrast to the BasicAuthenticator, the UserPassword credentials are 
 * written out (in Base64) in an initial request to the SessionResource.  
 * In return a session id is returned and subsequent requests to 
 * other resources use this as a credential, Base64 encoded.
 * 
 * @author Mike Whittaker
 */
public class SessionAuthenticator extends AbstractAuthenticator {
	
	private String id;
	
	/**
	 * Create an authenticator for session authentication.
	 * @param userPassword the user password
	 * @throws EsendexException the esendex exception
	 */
	public SessionAuthenticator(UserPassword userPassword) throws EsendexException {
		super(userPassword);
		SessionResource sessionService = new SessionResource(new BasicAuthenticator(userPassword));
		sessionService.execute();
		SessionDto dto = sessionService.getResponseObject();
		id = dto.getId();
	}
	
	/**
	 * Gets the credentials.
	 * @return the credentials {@inheritDoc}
	 */
	@Override
	public String getCredentials() {
		return id;
	}

}
