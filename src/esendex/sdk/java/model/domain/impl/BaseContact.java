package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.ContactType;

public class BaseContact {

	private String id;
	private String concurrencyId;
	private String uri;
	private String firstName;
	private String lastName;
	private String quickName;
	private String mobileNumber;
	private ContactType type;
	
	public BaseContact() {		
	}

	public String getId() {
		return id;
	}
	
	public String getConcurrencyId() {
		return concurrencyId;
	}

	public String getUri() {
		return uri;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getQuickName() {
		return quickName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public ContactType getType() {
		return type;
	}

	protected void setId(String id) {
		this.id = id;
	}

	protected void setConcurrencyId(String concurrencyId) {
		this.concurrencyId = concurrencyId;
	}
	
	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected void setQuickName(String quickName) {
		this.quickName = quickName;
	}

	protected void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	protected void setType(ContactType type) {
		this.type = type;
	}

}
