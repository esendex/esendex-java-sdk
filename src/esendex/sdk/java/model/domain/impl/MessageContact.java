package esendex.sdk.java.model.domain.impl;


public class MessageContact extends Identity {

	private String phoneNumber;
	private String displayName;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getDisplayName() {
		return displayName;
	}

	protected void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	protected void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	@Override
	public String toString() {
		return super.toString() +
			"\ndisplayName: " + displayName + 
			"\nphoneNumber: " + phoneNumber;
	}

}
