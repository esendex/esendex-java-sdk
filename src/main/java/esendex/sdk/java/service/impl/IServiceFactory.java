
package esendex.sdk.java.service.impl;

import esendex.sdk.java.service.ContactService;
import esendex.sdk.java.service.InboxService;
import esendex.sdk.java.service.MessagingService;
import esendex.sdk.java.service.SentService;

/**
 * A factory for creating IService objects.
 * @author Mike Whittaker
 */
public interface IServiceFactory {

	/**
	 * Obtains a service suitable for sending voice and sms messages
	 * @return the service
	 */
	MessagingService getMessagingService();

	/**
	 * Obtains a service suitable for querying sent messages
	 * @return the service
	 */
	SentService getSentService();

	/**
	 * Obtains a service suitable for querying the inbox for messages
	 * @return the service
	 */
	InboxService getInboxService();

	/**
     * This feature has now been deprecated in the new major version.
     * It will be completely removed on 04/06/2016.
     *
     * @deprecated Please make a local copy of your contacts and re-create using the new major version of the SDK.
	 */
    @Deprecated
	ContactService getContactService();

}