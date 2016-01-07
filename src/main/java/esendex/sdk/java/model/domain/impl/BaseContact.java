package esendex.sdk.java.model.domain.impl;

public class BaseContact {

	private String id;
	private String firstName;
	private String lastName;
	private String quickName;
	private String mobileNumber;
    private String accountReference;

	public BaseContact() {
	}

	public String getId() {
		return id;
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

    public String getAccountReference() {return accountReference;}

	protected void setId(String id) {
		this.id = id;
	}

    protected void setAccountReference(String accountReference) {this.accountReference = accountReference; }

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

}
