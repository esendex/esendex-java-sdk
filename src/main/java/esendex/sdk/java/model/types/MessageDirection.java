
package esendex.sdk.java.model.types;

/**
 * Indicates whether the message header was Inbound (received) or Outbound
 * (sent).
 * @author Mike Whittaker
 */
public enum MessageDirection {

	INBOUND ("Inbound"),
	OUTBOUND ("Outbound");

	private String representation;

	private MessageDirection(String representation) {
		this.representation = representation;
	}

	/**
	 * To string.
	 * @return the string {@inheritDoc}
	 */
	public String toString() {
		return representation;
	}
}
