
package esendex.sdk.java.model.domain.impl;

import java.util.Date;

import esendex.sdk.java.model.domain.response.InboxMessageResponse;

/**
 * An InboxMessageResponse.
 */
public class InboxMessageResponseImpl extends MessageResponseImpl implements InboxMessageResponse {

	private Date receivedAt;
	private Date readAt;
	private String readBy;
	
	public InboxMessageResponseImpl() {
	}

	public Date getReceivedAt() {
		return receivedAt;
	}

	public Date getReadAt() {
		return readAt;
	}

	public String getReadBy() {
		return readBy;
	}

	protected void setReceivedAt(Date receivedAt) {
		this.receivedAt = receivedAt;
	}

	protected void setReadAt(Date readAt) {
		this.readAt = readAt;
	}

	protected void setReadBy(String readBy) {
		this.readBy = readBy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			super.toString() +
			"\nreceivedat: " + getReceivedAt() +
			"\nreadat: " + getReadAt() +
			"\nreadby: " + getReadBy();
	}

}
