
package esendex.sdk.java.parser;

import esendex.sdk.java.parser.xstream.SurveysXStreamParser;

public class SurveyParserFactory {

	private static final XmlParser parser = new SurveysXStreamParser();

	/**
	 * Creates an XmlParser
	 * @return the XmlParser
	 */
	public static XmlParser getInstance() {
		return parser;
	}

}
