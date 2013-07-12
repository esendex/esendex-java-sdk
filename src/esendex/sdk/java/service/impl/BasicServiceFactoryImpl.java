
package esendex.sdk.java.service.impl;

import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.service.BasicServiceFactory;
import esendex.sdk.java.service.SessionService;
import esendex.sdk.java.service.auth.BasicAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;

/**
 * A basic authenticating Service Factory.
 */
public class BasicServiceFactoryImpl extends ServiceFactory implements BasicServiceFactory {

	/**
	 * Instantiates a new basic service factory impl.
	 * @param userPassword the user password
	 */
	public BasicServiceFactoryImpl(UserPassword userPassword) {
		super(new BasicAuthenticator(userPassword));
	}

	/**
	 * Gets the session service.
	 * @return the session service {@inheritDoc}
	 */
	public SessionService getSessionService() {
		return new SessionServiceImpl((BasicAuthenticator)authenticator);
	}
}
