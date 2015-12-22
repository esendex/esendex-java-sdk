
package esendex.sdk.java.model.types;

/**
 * The type of Message can be either SMS or Voice.
 * @author Mike Whittaker
 */
public enum MessageType {

	SMS ("SMS"),
	VOICE ("Voice");

	private String representation;

	private MessageType(String representation) {
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
