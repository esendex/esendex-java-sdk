
package esendex.sdk.java.model.transfer.contact;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.PageableDto;
import esendex.sdk.java.model.transfer.contact.ContactDto;

public class ContactCollectionDto extends PageableDto {

	@XStreamImplicit(itemFieldName = "contact")
	private List contacts = new ArrayList();

	@XStreamImplicit(itemFieldName = "link")
	private List link = new ArrayList();

	public ContactCollectionDto(List<ContactDto> contacts) {
		this.contacts = contacts;
	}

	public List getLink() {
		return link;
	}

	public void setLink(List link) {
		this.link = link;
	}

	public List<ContactDto> getContacts() {
		return contacts;
	}

	public void setContacts(List contacts) {
		this.contacts = contacts;
	}
}
