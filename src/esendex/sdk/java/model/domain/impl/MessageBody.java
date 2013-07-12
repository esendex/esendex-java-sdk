package esendex.sdk.java.model.domain.impl;


public class MessageBody extends Identity {

	private String bodyText;

	/**
	 * Gets the body text of the message.
	 * @return the text
	 */
	public String getBodyText() {
		return bodyText;
	}
	
	protected void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}

	@Override
	public String toString() {
		return super.toString() + 
			"\nbodyText: " + bodyText;
	}
}
