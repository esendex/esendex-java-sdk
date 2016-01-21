
package esendex.sdk.java.model.transfer.message;

/**
 * The Class MessageRequest.
 */
public class MessageRequestDto extends AbstractMessageRequestDto {

	private String to;	
	private String body;
	
	public MessageRequestDto() {
	}
	
	/**
	 * Sets the to.
	 * @param to the new to
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * Sets the body.
	 * @param body the new body
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nto: " + to +
			"\nbody: " + body;
	}

}
