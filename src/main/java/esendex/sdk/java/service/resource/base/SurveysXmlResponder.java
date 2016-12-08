
package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.parser.SurveysXmlParserFactory;
import esendex.sdk.java.parser.XmlParser;
import esendex.sdk.java.parser.XmlParserFactory;
import esendex.sdk.java.parser.XmlPrettyPrinter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class XmlResponder.
 * @param <S> the expected type of the response object
 */
public class SurveysXmlResponder<S> {

	private Log log = LogFactory.getLog(SurveysXmlResponder.class);
	private String responseContent;
	private S responseDto;
	private XmlParser parser;

	/**
	 * Instantiates a new xml responder.
	 * @param responseContent the response content
	 * @throws EsendexException the esendex exception
	 */
	public SurveysXmlResponder(String responseContent) throws EsendexException {
		if (responseContent == null)
			throw new NullPointerException("Argument must not be null");

		this.responseContent = responseContent;
		this.parser = SurveysXmlParserFactory.getInstance();
		createResponseObject();
	}

    @SuppressWarnings("unchecked")
	private void createResponseObject() throws EsendexException {
		log.info("Response: " + XmlPrettyPrinter.format(responseContent));
		responseDto = (S) parser.fromXml(responseContent);
		log.info("Response class: " + responseDto.getClass().getSimpleName());
	}

	/**
	 * Gets the response object.
	 * @return the response object
	 */
	public S getResponseObject() {
		return responseDto;
	}
}
