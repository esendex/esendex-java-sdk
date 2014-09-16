
package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.impl.SessionResponseAssembler;
import esendex.sdk.java.model.domain.response.SessionResponse;
import esendex.sdk.java.service.SessionService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.resource.access.SessionResource;

/**
 * A concrete SessionService.
 */
public class SessionServiceImpl extends AbstractService implements SessionService {
	
	/**
	 * Instantiates a new session service.
	 * @param authenticator the authenticator
	 */
	public SessionServiceImpl(BasicAuthenticator authenticator) {
		super(authenticator);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public SessionResponse getSession() throws EsendexException {
		SessionResource resource = new SessionResource((BasicAuthenticator)authenticator);
		resource.execute();
		return new SessionResponseAssembler().createResponse(
				resource.getResponseObject());
	}

}
