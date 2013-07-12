
package esendex.sdk.java.model.types;
// TODO: Auto-generated Javadoc
/**
 * The status code refers to the current state of the Message. The possible values are:
 * <br/>
 * Submitted - Message is being processed by Esendex <br/>
 * Sent - Message has been passed on to the Mobile Networks  <br/>
 * Delivered - Message has been delivered to the Recipient  <br/>
 * Expired - Message could not be delivered within the validity period  <br/>
 * Failed - Message could not be delivered  <br/>
 * FailedAuthorisation - Premium message could not be authorised to this Recipient  <br/>
 * Acknowledged - Voice Message has been acknowledged by the Recipient  <br/>
 * Connecting - Voice message is currently being delivered to the customer
 * 
 * @author Mike Whittaker
 */
public enum Status {
	
	SUBMITTED ("Submitted"), 
	SENT ("Sent"),
	DELIVERED ("Delivered"),
	EXPIRED ("Expired"),
	FAILED ("Failed"),
	FAILEDAUTHORISATION ("FailedAuthoristaion"),
	ACKNOWLEDGED ("Acknowledged"),
	CONNECTING ("Connecting"),
	SCHEDULED ("Scheduled");
	
	private String representation;

	private Status(String representation) {
		this.representation = representation;
	}
	
	/**
	 * To string.
	 * @return the string {@inheritDoc}
	 */
	public String toString() {
		return representation;
	}
}
