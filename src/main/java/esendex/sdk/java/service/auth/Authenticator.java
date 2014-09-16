
package esendex.sdk.java.service.auth;

import java.net.URLConnection;

/**
 * An Authenticator writes out a header to a URLConnection with the intention
 * of authenticating the resource in question.
 * @author Mike Whittaker
 */
public interface Authenticator {

	
	/**
	 * Creates a header suitable for authenticating an Http connection.
	 * @param urlCon the URLConnection
	 */
	void createHeader(URLConnection urlCon);

}