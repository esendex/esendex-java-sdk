
package esendex.sdk.java.service.auth;

/**
 * A (RFC2617) Basic authenticator that writes out the Http header to 
 * authenticate a request with the UserPassword credentials provided.
 * Each request will contain the user and password credentials 
 * encoded in Base64 
 * @author Mike Whittaker
 */
public class BasicAuthenticator extends AbstractAuthenticator {

	
	/**
	 * Create an authenticator for basic authentication with the supplied
	 * credentials.
	 * @param userPassword the credentials
	 */
	public BasicAuthenticator(UserPassword userPassword) {
		super(userPassword);
	}

	/**
	 * Gets the credentials.
	 * @return the credentials {@inheritDoc}
	 */
	@Override
	public String getCredentials() {
		UserPassword userPassword = getUserPassword();
		return userPassword.getUser() + ":" + userPassword.getPassword();
	}
	
}
