
package esendex.sdk.java.http;

/**
 * Factory for the single HttpConnector of choice.
 * @author Mike Whittaker
 */
public class HttpConnectorFactory {

	private static HttpConnector defaultConnector = new HttpConnectorImpl();
	private static HttpConnector connector = defaultConnector;
	
	/**
	 * Gets the default connector.
	 * @return the connector
	 */
	public static HttpConnector getDefaultConnector() {
		return defaultConnector;
	}
	
	/**
	 * Gets the connector of choice.
	 * @return the connector
	 */
	public static HttpConnector getConnector() {
		return connector;
	}

	/**
	 * Sets the connector of choice.
	 * @param con the connector to set
	 */
	public static void setConnector(HttpConnector con) {
		connector = con;
	}

}
