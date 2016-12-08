
package esendex.sdk.java.parser;

import esendex.sdk.java.parser.xstream.SurveysXStreamParser;

/**
 * Factory for creating and obtaining XmlParsers.
 * The instances are cached.
 * @author Mike Whittaker loves unnecessary layers of abstraction.
 */
public class SurveysXmlParserFactory {

	private static final XmlParser parser = new SurveysXStreamParser();

	/**
	 * Creates an XmlParser
	 * @return the XmlParser
	 */
	public static XmlParser getInstance() {
		return parser;
	}

}
