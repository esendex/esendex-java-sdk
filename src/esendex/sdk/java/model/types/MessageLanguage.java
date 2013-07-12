
package esendex.sdk.java.model.types;

// TODO: Auto-generated Javadoc
/**
 * The Enum MessageLanguage.
 */
public enum MessageLanguage {

	EN_GB ("en-GB"),
	EN_AU ("en-AU"),
	FR_FR ("fr-FR"),
	ES_ES ("es-ES");
	
	private String representation;

	private MessageLanguage(String representation) {
		this.representation = representation;
	}
	
	/**
	 * To string.
	 * @return the string {@inheritDoc}
	 */
	@Override
	public String toString() {
		return representation;
	}
	

}
