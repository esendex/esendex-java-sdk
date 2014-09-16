
package esendex.sdk.java.model.transfer.message;

import esendex.sdk.java.model.transfer.Dto;

/**
 * Data holder for location entities.  This class directly holds the
 * parsed xml data. 
 * @author Mike Whittaker
 */
public class MessageContactDto extends Dto {
	
	private String phonenumber;
	private String displayname;

	/**
	 * Gets the phonenumber.
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}

	/**
	 * Gets the displayname.
	 * @return the displayname
	 */
	public String getDisplayname() {
		return displayname;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			"displayname: " + displayname + 
			"phonenumber: " + phonenumber;
	}

}
