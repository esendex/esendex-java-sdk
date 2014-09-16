
package esendex.sdk.java.parser;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * Date converter that converts empty elements to null.
 * @author Mike Whittaker
 */
public class EmptyToNullDateConverter extends DateConverter {

    private static final String UTCDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String LocalDateFormat = "yyyy-MM-dd'T'HH:mm:ss";

	/**
	 * Instantiates a new empty to null date converter.
	 * @param format the format
	 */
	public EmptyToNullDateConverter() {
		super(UTCDateFormat, new String[]{LocalDateFormat});
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
