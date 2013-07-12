
package esendex.sdk.java.model.transfer.contact;

import java.util.ArrayList;
import java.util.List;

import esendex.sdk.java.model.transfer.PageableDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;

// TODO: Auto-generated Javadoc
/**
 * The response from certain services containing a collection of
 * ContactResponse.
 * @author Mike Whittaker
 */
public class ContactCollectionDto extends PageableDto {
	
	private List<ContactDto> contacts;
	
	private Object readResolve() {
		if (contacts == null) contacts = new ArrayList<ContactDto>();
		return this;
	}
	
	public ContactCollectionDto() {
	}
	
	/**
	 * Creates a ContactCollectionDto populated with a List of
	 * ContactDtos.
	 * @param contacts the List of contacts
	 */
	public ContactCollectionDto(List<ContactDto> contacts) {
		this.contacts = contacts;
	}

	/**
	 * Gets the contacts.
	 * @return the contacts
	 */
	public List<ContactDto> getContacts() {
		return contacts;
	}
	
	public void setContacts(List<ContactDto> contacts) {
		this.contacts = contacts;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + contacts;
	}
}
