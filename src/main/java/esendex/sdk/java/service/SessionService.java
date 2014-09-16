
package esendex.sdk.java.service;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.domain.response.SessionResponse;

/**
 * A SessionService is a service for obtaining a Session for the purposes of
 * session authentication. An EsendexException is thrown  to indicate either 
 * a problem during the underlying connection or there was a none okay response. 
 */
public interface SessionService {

	/**
	 * Obtains a session for authentication of subsequent resources by session
	 * authentication.
	 * @return a session object that wraps the session id
	 * @throws EsendexException to indicate a problem during the underlying 
	 *	connection or there was a none okay response.
	 */
	SessionResponse getSession() throws EsendexException;

}