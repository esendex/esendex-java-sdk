
package esendex.sdk.java.service.impl;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.ServiceFactory;
import esendex.sdk.java.service.SessionServiceFactory;
import esendex.sdk.java.service.auth.SessionAuthenticator;
import esendex.sdk.java.service.auth.UserPassword;


/**
 * The Class SessionServiceFactoryImpl.
 */
public class SessionServiceFactoryImpl extends ServiceFactory implements SessionServiceFactory {

	/**
	 * Instantiates a new session service factory impl.
	 * @param userPassword the user password
	 * @throws EsendexException the esendex exception
	 */
	public SessionServiceFactoryImpl(UserPassword userPassword) throws EsendexException {
		super(new SessionAuthenticator(userPassword));
	}

}
