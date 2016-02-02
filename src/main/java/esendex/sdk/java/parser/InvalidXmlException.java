
package esendex.sdk.java.parser;

import esendex.sdk.java.EsendexException;


/**
 * Exception to indicate that data could not be treated as xml, 
 * probably due to not being well formed.
 * 
 * @author Mike Whittaker
 */
public class InvalidXmlException extends EsendexException {

	private static final long serialVersionUID = 20100211L;
	
	/**
	 * Instantiates a new invalid xml exception.
	 */
	public InvalidXmlException() {
	}

	/**
	 * Instantiates a new invalid xml exception.
	 * @param message the message
	 */
	public InvalidXmlException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new invalid xml exception.
	 * @param cause the cause
	 */
	public InvalidXmlException(Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new invalid xml exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public InvalidXmlException(String message, Throwable cause) {
		super(message, cause);
	}

}
