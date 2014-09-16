
package esendex.sdk.java.http;

import java.net.URL;

import esendex.sdk.java.service.auth.Authenticator;

/**
 * An HttpConnector connects to an Http resource sending an optional request 
 * and receiving a response.
 * @author Mike Whittaker
 */
public interface HttpConnector {
	
	/**
	 * Connects to a URL and obtains a response. Optional data can be sent on
	 * the connection. An Authenticator is used to write out the correct
	 * authentication headers.
	 * 
	 * @param url the endpoint of the request
	 * @param method the Http method to use for the connection
	 * @param data any data that forms the request and which may be null
	 * @param authenticator the Authenticator with which to 
	 *	authenticate the connection
	 * @return a response that wraps the status and any response data
	 * @throws HttpException if there are any IO problem during 
	 *	the underlying connection or the status code is not 200 (Http okay)
	 */
	HttpResponse connect(
			URL url, 
			HttpRequestMethod method,
			String data, 
			Authenticator authenticator)
			throws HttpException;

}
