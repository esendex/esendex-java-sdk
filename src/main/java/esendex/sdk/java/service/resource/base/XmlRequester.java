
package esendex.sdk.java.service.resource.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.parser.XmlParser;
import esendex.sdk.java.parser.XmlParserFactory;

/**
 * The Class XmlRequester.
 * @param <Q> the generic type
 */
public class XmlRequester<Q extends Dto> {

	private Log log = LogFactory.getLog(XmlRequester.class);
	private Q requestDto;
	private XmlParser parser;

	/**
	 * Instantiates a new xml requester.
	 * @param requestDto the request dto
	 */
	public XmlRequester(Q requestDto) {
		if (requestDto == null)
			throw new NullPointerException("Argument must not be null");

		log.info("Request class: " + requestDto.getClass().getSimpleName());
		this.parser = XmlParserFactory.getInstance();
		this.requestDto = requestDto;
	}

	/**
	 * Provide the request data that is required by the end point of this service.
	 * @return the request data to submit
	 */
	public String getRequestData() {
		log.info("request dto: " + requestDto);
		return parser.toXml(requestDto);
	}
}
