package esendex.sdk.java.http;

import esendex.sdk.java.EsendexException;

/**
 * Thrown to indicate an Http Response code is out of the okay range 200-299.
 * @author Mike Whittaker
 */
public class HttpException extends EsendexException {

	private static final long serialVersionUID = 20100215;

	/**
	 * Instantiates a new http exception.
	 */
	public HttpException() {
		super();
	}

	/**
	 * Instantiates a new http exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public HttpException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new http exception.
	 * @param message the message
	 */
	public HttpException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new http exception.
	 * @param cause the cause
	 */
	public HttpException(Throwable cause) {
		super(cause);
	}
	
	

}
