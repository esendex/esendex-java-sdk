
package esendex.sdk.java.model.transfer.message;

import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.types.CharacterSet;
import esendex.sdk.java.model.types.MessageLanguage;
import esendex.sdk.java.model.types.MessageType;

/**
 * An AbstractMessageRequest is the base class for all Message requests whether
 * that is a collection or a single message.
 * This class directly holds the parsed xml data. Subclasses should 
 * merely allow selective access.
 */
public abstract class AbstractMessageRequestDto extends Dto {

	private String from;				// all
	private MessageType type;			// all
	private MessageLanguage lang;		// voice
	private Integer retries;			// voice
	private Integer validity;			// all
	private CharacterSet characterset;   // sms

	/**
	 * Sets the alphanumeric originator for the message to 
	 * appear to originate from.
	 * @param from the originator
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * Sets the type.
	 * @param type the new type
	 */
	public void setType(MessageType type) {
		this.type = type;
	}

	/**
	 * Sets the lang.
	 * @param lang the new lang
	 */
	public void setLang(MessageLanguage lang) {
		this.lang = lang;
	}

	/**
	 * Sets the retries.
	 * @param retries the new retries
	 */
	public void setRetries(Integer retries) {
		this.retries = retries;
	}

	/**
	 * Sets the validity period for a message in hours (defaults to 
	 * 0 which indicates the MAX allowed).
	 * @param validity the period in hours
	 */
	public void setValidity(Integer validity) {
		this.validity = validity;
	}

	/**
	 * Sets the retries.
	 * @param characterSet the new retries
	 */
	public void setCharacterSet(CharacterSet characterSet) {
		this.characterset = characterSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nfrom: " + from +
			"\ntype: " + type +
			"\nlang: " + lang +
			"\nretries: " + retries +
			"\nvalidity: " + validity +
			"\ncharacterSet:" + characterset;
	}

	
	
	
	
}
