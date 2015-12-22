
package esendex.sdk.java.model.transfer.contact;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import esendex.sdk.java.model.transfer.Dto;

/**
 * Base class for contact requests and responses.  This class directly holds the
 * parsed xml data. Subclasses should merely allow selective access.
 * @author Mike Whittaker
 */
public class ContactDto extends Dto {

	private String firstname;
	private String lastname;
	private String quickname;
	private String phonenumber;
    private String accountreference;

    @XStreamOmitField
    private String link;

	public ContactDto() {
	}


	/**
	 * The first name of this Contact. This may not be returned if the property
	 * has not been set for the Contact.
	 * @return the contacts first name
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * The last name of this Contact. This may not be returned if
	 * the property has not been set for the Contact.
	 * @return the contacts last name
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * This is the human-friendly shortcut for the Contact and can be used as
	 * a Message recipient instead of a telephone number. Where firstname
	 * and lastname have been set when the Contact was created, it may be a
	 * concatenation of these two values.
	 * @return the contacts quickname
	 */
	public String getQuickname() {
		return quickname;
	}

	/**
	 * The telephone number associated with this Contact.
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phonenumber;
	}

    /**
     * The accountReference associated with this Contact.
     * @return the Account Reference
     */
    public String getAccountReference() {return accountreference; }

	/**
	 * Sets the firstname.
	 * @param firstname the first name to set
	 * @see #getFirstname()
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Sets the lastname.
	 * @param lastname the last name to set
	 * @see #getLastname()
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Sets the quickname.
	 * @param quickname the quick name to set
	 * @see #getQuickname()
	 */
	public void setQuickname(String quickname) {
		this.quickname = quickname;
	}

	/**
	 * Sets the phonenumber.
	 * @param phonenumber the mobile number to set
	 * @see #getPhoneNumber()
	 */
	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

    /**
     * Sets the type.
     * @param accountReference the accountReference to set
     * @see #getAccountReference() ()
     */
    public void setAccountReference(String accountReference) {
        this.accountreference = accountReference;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

        return super.toString() +
                "\nfirstname:" + firstname +
                "\nlastname:" + lastname +
                "\nquickname:" + quickname +
                "\nmobilenumber:" + phonenumber +
                "\naccountreference:" + accountreference;
    }
}
