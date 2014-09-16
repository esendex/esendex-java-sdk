
package esendex.sdk.java.service.auth;

import java.net.URLConnection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import biz.source_code.base64Coder.Base64Coder;

/**
 * An AbstractAuthenticator is a base class for Authenticators. 
 * It provides encryption facility and writes out the header.
 */
public abstract class AbstractAuthenticator implements Authenticator {
	
	private static Log log =  LogFactory.getLog(AbstractAuthenticator.class);

	private static final String AUTHORISATION 	= "Authorization";
	private static final String SCHEME 			= "Basic";

	private UserPassword userPassword;
	private String encoding;
	
	public AbstractAuthenticator(UserPassword userPassword) {
		this.userPassword = userPassword;
		if (userPassword == null) throw new NullPointerException(
				"UserPassword must not be null");
	}
	
	protected UserPassword getUserPassword() {
		return userPassword;
	}

	/**
	 * Gets the scheme which is BASIC.
	 * @return the scheme
	 */
	protected String getScheme() {
		return SCHEME;
	}

	/**
	 * Encode the credentials.
	 * @return encoded credentials
	 */
	protected String encode() {
		if (encoding == null) encoding = Base64Coder.encodeString(getCredentials());
		return encoding;
	}

	/**
	 * Gets the non encoded credentials.
	 * @return the credentials
	 */
	public abstract String getCredentials();

	/**
	 * Creates the header.
	 * @param urlCon the url con {@inheritDoc}
	 */
	public void createHeader(URLConnection urlCon) {
		log.info("Adding auth header for: " + getClass().getSimpleName() + ": " + getCredentials());
		log.info(AUTHORISATION + ": " + getScheme() + " " + encode());
		urlCon.setRequestProperty(AUTHORISATION, getScheme() + " " + encode());
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AbstractAuthenticator)) return false;
		AbstractAuthenticator that = (AbstractAuthenticator)obj;
		return this.userPassword.equals(that.userPassword);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return userPassword.hashCode();
	}
	
}
