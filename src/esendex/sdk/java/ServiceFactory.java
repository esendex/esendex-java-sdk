
package esendex.sdk.java;

import esendex.sdk.java.service.BasicServiceFactory;
import esendex.sdk.java.service.ContactService;
import esendex.sdk.java.service.InboxService;
import esendex.sdk.java.service.MessagingService;
import esendex.sdk.java.service.SentService;
import esendex.sdk.java.service.SessionServiceFactory;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.auth.UserPassword;
import esendex.sdk.java.service.impl.BasicServiceFactoryImpl;
import esendex.sdk.java.service.impl.ContactServiceImpl;
import esendex.sdk.java.service.impl.IServiceFactory;
import esendex.sdk.java.service.impl.InboxServiceImpl;
import esendex.sdk.java.service.impl.MessagingServiceImpl;
import esendex.sdk.java.service.impl.SentServiceImpl;
import esendex.sdk.java.service.impl.SessionServiceFactoryImpl;

/**
 * A factory for services.  A service is the fundamental developer interface to
 * the Esendex resources. A new ServiceFactory should be created for every
 * Authentication identity.  
 * 
 * @author Mike Whittaker
 */
public abstract class ServiceFactory implements IServiceFactory  {
	
	protected Authenticator authenticator;

	/**
	 * Instantiates a new service factory.
	 * @param authenticator the authenticator
	 */
	protected ServiceFactory(Authenticator authenticator) {
		this.authenticator = authenticator;
	}

	/**
	 * Create a ServiceFactory whose services will connect using Session
	 * authentication.
	 * @param userPassword the credentials used to authenticate
	 * @return a ServiceFactory with session authentication
	 * @throws EsendexException if there is any problem creating the session
	 */
	public static SessionServiceFactory createSessionAuthenticatingFactory(
			UserPassword userPassword) throws EsendexException {
		return new SessionServiceFactoryImpl(userPassword);
	}
	
	/**
	 * Create a ServiceFactory whose services will connect using Basic
	 * authentication.
	 * @param userPassword the credentials used to authenticate
	 * @return a ServiceFactory with Basic authentication
	 */
	public static BasicServiceFactory createBasicAuthenticatingFactory(
			UserPassword userPassword) {
		return new BasicServiceFactoryImpl(userPassword);
	}

	/**
	 * Obtains a service suitable for sending voice and SMS messages.
	 * @return the service
	 */
	public MessagingService getMessagingService() {
		return new MessagingServiceImpl(authenticator);
	}

	/**
	 * Obtains a service suitable for querying sent messages.
	 * @return the service
	 */
	public SentService getSentService() {
		return new SentServiceImpl(authenticator);
	}

	/**
	 * Obtains a service suitable for querying the Inbox for messages.
	 * @return the service
	 */
	public InboxService getInboxService() {
		return new InboxServiceImpl(authenticator);
	}

	/**
	 * Obtains a service suitable for create, read, update and delete
	 * operations on the users contacts.
	 * @return the service
	 */
	public ContactService getContactService() {
		return new ContactServiceImpl(authenticator);
	}
	
}
