
package esendex.sdk.java.model.transfer.contact;

import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.types.ContactType;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * Base class for contact requests and responses.  This class directly holds the
 * parsed xml data. Subclasses should merely allow selective access.
 * @author Mike Whittaker
 */
public class ContactDto extends Dto {
	
	private String concurrencyid;
    private String owner;
	private String firstname;
	private String lastname;
	private String quickname;
	private String mobilenumber;
	private ContactType type;
	//private List<ContactGroupSummaryDto> groups;
	
	public ContactDto() {		
	}
	
	/**
	 * This unique identifier GUID should change each time the Contact details 
	 * are amended. It can be used to help identify when a Contact has changed.
	 * @return the concurrency id
	 */
	public String getConcurrencyid() {
		return concurrencyid;
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
	 * @return the mobile number
	 */
	public String getMobilenumber() {
		return mobilenumber;
	}

	/**
	 * The type of Contact indicates where it was created from. Esendex means 
	 * it was generated from within the Echo application. Mobile means it 
	 * was generated from a mobile phone synchronisation. Within this Java API
	 * this should always return {@link esendex.sdk.java.model.types.ContactType}
	 * @return the contact type
	 */
	public ContactType getType() {
		return type;
	}

//	/**
//	 * This element lists links to the Contact Groups that this Contact
//	 * is associated with.
//	 * @return the contact groups
//	 */
//	public List<ContactGroupSummaryDto> getGroups() {
//		return groups;
//	}
	
	
	/**
	 * Sets the concurrencyid.
	 * @param concurrencyid the concurrencyid to set
	 * @see #getConcurrencyid()
	 */
	public void setConcurrencyid(String concurrencyid) {
		this.concurrencyid = concurrencyid;
	}

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
	 * Sets the mobilenumber.
	 * @param mobilenumber the mobile number to set
	 * @see #getMobilenumber()
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	/**
	 * Sets the type.
	 * @param type the contact type to set
	 * @see #getType()
	 */
	public void setType(ContactType type) {
		this.type = type;
	}

//	/**
//	 * Sets the groups.
//	 * @param groups the groups to set
//	 * @see #getGroups()
//	 */
//	public void setGroups(List<ContactGroupSummaryDto> groups) {
//		this.groups = groups;
//	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {

		return super.toString() +
			"\nconcurrencyid:" + concurrencyid +
			"\nfirstname:" + firstname +
			"\nlastname:" + lastname +
			"\nquickname:" + quickname +
			"\nmobilenumber:" + mobilenumber +
			"\ntype:" + type +
            "\nowner:" + owner;
	}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
