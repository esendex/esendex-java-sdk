
package esendex.sdk.java.http;

/**
 * Container for HTTP responses. Holds the status code, status message and any
 * content from an HTTP response.
 * 
 * @author Mike Whittaker
 */
public class HttpResponse {

	private int statusCode;
	private String statusMessage;
	private String content;

	/**
	 * Constructs an HttpResponse object.
	 * @param statusCode the HTTP status code to set
	 * @param statusMessage the HTTP status message to set
	 * @param content the content (if any) to set.
	 */
	public HttpResponse(int statusCode, String statusMessage, String content) {
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
		this.content = content;
	}

	/**
	 * Convenience method for determining if {@link #getStatusCode()} returns an
	 * OK response such that 200 <= x <= 299.
	 * @return true if response is OK otherwise false.
	 */
	public boolean isHttpOkay() {
		return 200 <= statusCode && statusCode <= 299;
	}

	/**
	 * Gets the status code.
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Gets the status message.
	 * @return the status message
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * Gets the content.
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * {@inheritDoc}
	 */
	public String toString() {
		return statusCode + ", " + statusMessage;
	}

}
