
package esendex.sdk.java.parser;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * Date converter that converts empty elements to null.
 * @author Mike Whittaker
 */
public class EmptyToNullDateConverter extends DateConverter {
	
	/**
	 * Instantiates a new empty to null date converter.
	 * @param format the format
	 */
	public EmptyToNullDateConverter(String format) {
		super(format, new String[]{});
	}
	
	/**
	 * Parses xml date element as per DateConverter except that
	 * empty elements are converted to null.
	 * @param str The element data to convert
	 * @return an Object of type {@link java.util.Date}
	 */
	@Override
	public Object fromString(String str) {	
		if ("".equals(str)) return null;
		return super.fromString(str);
	}
	
}
