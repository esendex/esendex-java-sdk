
package esendex.sdk.java.parser;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.model.transfer.Dto;

/**
 * An XML parser that is capable of conversion between XML character data, Dto
 * type Objects and vice versa.
 * @author Mike Whittaker
 */
public interface XmlParser {
	
	/**
	 * Converts if possible, a String, that must be in XML format, to a Dto.
	 * @param xml the character data to be converted
	 * @return a Dto object representing the argument
	 * @throws EsendexException if there is any problem reading or parseing the
	 *	XML.
	 */
	Dto fromXml(String xml) throws EsendexException;

	/**
	 * Converts a Dto Object to XML character data.
	 * @param obj the Dto Object to be converted.
	 * @return A String representation of the Dto argument.
	 */
	String toXml(Dto obj);

}
