
package esendex.sdk.java;

/**
 * An EsendexException is thrown to indicate a problem 
 * during execution of a service.
 */
public class EsendexException extends Exception {

	private static final long serialVersionUID = 20100223L;

	/**
	 * Instantiates a new esendex exception.
	 */
	public EsendexException() {
		super();
	}

	/**
	 * Instantiates a new esendex exception.
	 * @param message the message
	 * @param cause the cause
	 */
	public EsendexException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new esendex exception.
	 * @param message the message
	 */
	public EsendexException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new esendex exception.
	 * @param cause the cause
	 */
	public EsendexException(Throwable cause) {
		super(cause);
	}
	
	

}
