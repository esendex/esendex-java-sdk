
package esendex.sdk.java.parser;

import esendex.sdk.java.EsendexException;


/**
 * Exception to indicate that well formed XML could not be mapped to a
 * suitable Dto object. This may be due to configuration of the XmlParser.
 * 
 * @author Mike Whittaker
 */
public class UnmappableException extends EsendexException {

	private static final long serialVersionUID = 20100211L;

	/**
	 * Instantiates a new unmappable exception.
	 */
	public UnmappableException() {
	}

	/**
	 * Instantiates a new unmappable exception.
	 * @param message the message
	 */
	public UnmappableException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new unmappable exception.
	 * @param cause the cause
	 */
	public UnmappableException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new unmappable exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public UnmappableException(String message, Throwable cause) {
		super(message, cause);
	}

}
