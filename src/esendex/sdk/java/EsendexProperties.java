
package esendex.sdk.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * The EsendexProperties.
 */
public class EsendexProperties {
	
	/**
	 * The Enum Key.
	 */
	public enum Key {
		VERSION 	("esendex.version"),
		NAMESPACE 	("esendex.namespace"),
		DOMAIN 		("esendex.domain"),
		PORT 		("esendex.port");
		
		String value;
		Key(String v) {
			value = v;
		}
	}

	private static final long serialVersionUID = 20100212L;
	private static final EsendexProperties instance = new EsendexProperties();
	private static final String PROPERTY_FILE_NAME = "esendex.properties";
	
	private Properties properties;
	
	/**
	 * Instantiates a new esendex properties.
	 */
	public EsendexProperties() {
		properties = new Properties();
		try {
			InputStream is = getClass().getResourceAsStream("/" + PROPERTY_FILE_NAME);
			if (is == null) throw new FileNotFoundException();
			properties.load(is);
		} catch (IOException e) {
			throw new RuntimeException("Could not load '" + PROPERTY_FILE_NAME 
					+ "' is it at the root of the classpath?");
		}
	}
	
	/**
	 * retrieves the instance.
	 * @return the esendex properties
	 */
	public static EsendexProperties instance() {
		return instance;
	}
	
	/**
	 * Gets the property.
	 * @param key the key
	 * @return the property
	 */
	public String getProperty(Key key) {
		String prop = properties.getProperty(key.value);
		if (prop == null) throw new NullPointerException("Key: '" + key 
				+ "' could not be found, this key is mandatory");
		return prop;
	}

}
