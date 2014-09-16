
package esendex.sdk.java.model.transfer.session;

import esendex.sdk.java.model.transfer.Dto;

/**
 * Data holder for session entities.  This class directly holds the parsed 
 * xml data. A SessionDto holds the session ID to be used for subsequent
 * session authenticated requests to other resources.
 * 
 * @author Mike Whittaker
 */
public class SessionDto extends Dto {
		
	private String id;

	/**
	 * {@inheritDoc}
	 */
	public String getId() {
		return id;
	}

}
