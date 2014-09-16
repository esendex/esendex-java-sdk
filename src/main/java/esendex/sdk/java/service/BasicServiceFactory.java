
package esendex.sdk.java.service;

import esendex.sdk.java.service.impl.IServiceFactory;


/**
 * A factory for creating BasicService objects.
 */
public interface BasicServiceFactory extends IServiceFactory {

	SessionService getSessionService();

}