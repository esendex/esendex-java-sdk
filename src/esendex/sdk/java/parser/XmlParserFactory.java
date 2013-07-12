
package esendex.sdk.java.parser;

import esendex.sdk.java.parser.xstream.XStreamParser;

/**
 * Factory for creating and obtaining XmlParsers. 
 * The instances are cached.
 * @author Mike Whittaker
 */
public class XmlParserFactory {
	
	private static final XmlParser parser = new XStreamParser();

	/**
	 * Creates an XmlParser
	 * @return the XmlParser
	 */
	public static XmlParser getInstance() {
		return parser;
	}

}
