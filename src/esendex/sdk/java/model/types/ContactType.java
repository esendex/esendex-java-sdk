
package esendex.sdk.java.model.types;

// TODO: Auto-generated Javadoc
/**
 * The Enum ContactType.
 */
public enum ContactType {
	
	ESENDEX ("Esendex"), 
	MOBILE ("Mobile");

	private String representation;

	private ContactType(String representation) {
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
