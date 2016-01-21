
package esendex.sdk.java.parser;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


/**
 * Pretty printer for the formating of XML in a neat indented fashion.
 * 
 * @author Mike Whittaker
 */
public class XmlPrettyPrinter {

	/**
	 * Format a String as XML in a neat indented fashion. The input is simply
	 * returned if there is any problem parseing the XML
	 * 
	 * @param input
	 *            the XML to format
	 * @param indent
	 *            the required amount indent
	 * @return neatly indented XML or input if XML could not be parsed
	 */
	public static String format(String input, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", String
							.valueOf(indent));
			transformer.transform(xmlInput, xmlOutput);
			return "\n" + xmlOutput.getWriter().toString();
		} catch (Exception e) {
			return input;
		}
	}

	/**
	 * Convenience method for {@link #format(String, int)} that defaults to an
	 * indent value of 2.
	 * 
	 * @param input
	 *            the XML to format
	 * @return neatly indented XML or input if XML could not be parsed
	 */
	public static String format(String input) {
		return format(input, 2);
	}

}