
package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.BaseContact;

/**
 * A request object suitable for creating and updating a Contact resource.
 * @author Mike Whittaker
 */
public class ContactRequest extends BaseContact {

	/**
	 * Creates a ContactRequest with the mandatory fields of quickname and
	 * mobile number.
	 * @param quickName the quickname
	 * @param mobileNumber the mobile number
     * @param accountReference the account reference
	 */
	public ContactRequest(String quickName, String mobileNumber, String accountReference) {
		if (quickName == null || mobileNumber == null || accountReference == null)
			throw new NullPointerException("arguments can not be null");

		setQuickName(quickName);
		setMobileNumber(mobileNumber);
        setAccountReference(accountReference);
        setFirstName("");
        setLastName("");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFirstName(String firstName) {
		super.setFirstName(firstName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setId(String id) {
		super.setId(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setLastName(String lastName) {
		super.setLastName(lastName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setMobileNumber(String mobileNumber) {
		super.setMobileNumber(mobileNumber);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setQuickName(String quickName) {
		super.setQuickName(quickName);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAccountReference(String accountReference) {
        super.setAccountReference(accountReference);
    }

}
