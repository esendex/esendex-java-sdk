
package esendex.sdk.java.model.transfer.contact;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.transfer.LinkDto;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("contact")
public class ContactDto extends Dto {

	@XStreamAlias("firstname")
	private String firstname;

	@XStreamAlias("lastname")
	private String lastname;

	@XStreamAlias("quickname")
	private String quickname;

	@XStreamAlias("phonenumber")
	private String phonenumber;

	@XStreamAlias("accountreference")
	private String accountreference;

	@XStreamImplicit(itemFieldName = "link")
	private List link = new ArrayList();


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getQuickname() {
		return quickname;
	}

	public void setQuickname(String quickname) {
		this.quickname = quickname;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAccountReference() {
		return accountreference;
	}

	public void setAccountReference(String accountreference) {
		this.accountreference = accountreference;
	}
}