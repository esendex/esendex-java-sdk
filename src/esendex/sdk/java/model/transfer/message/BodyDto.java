
package esendex.sdk.java.model.transfer.message;

import esendex.sdk.java.model.transfer.Dto;

/**
 * Data holder for body entities.  This class directly holds the parsed 
 * xml data. Holds the body text of a message for requests and a link 
 * to the full message for repsonses.
 * 
 * @author Mike Whittaker
 */
public class BodyDto extends Dto {
	
	private String text;

	/**
	 * Gets the body text of teh message.
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	@Override
	public String getUri() {
		return super.getUri();
	}


}
