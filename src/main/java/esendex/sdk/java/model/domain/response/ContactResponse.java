package esendex.sdk.java.model.domain.response;

import esendex.sdk.java.model.types.ContactType;

public interface ContactResponse {
	
	/**
	 * The unique identifier for the Contact. Each Contact returned will 
	 * include a non-empty GUID id value. It will be a stable GUID that 
	 * will not change. 
	 * @return the id
	 */
	String getId();
	
	String getConcurrencyId();

	String getFirstName();

	String getLastName();

	String getQuickName();

	String getMobileNumber();

	ContactType getType();
}
