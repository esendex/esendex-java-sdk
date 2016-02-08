
package esendex.sdk.java.model.domain.impl;

import java.util.Date;

import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.model.transfer.message.FailureReasonDto;

/**
 * A SentMessageResponse.
 */
public class SentMessageResponseImpl extends MessageResponseImpl implements SentMessageResponse {

	private Date sentAt;
	private Date deliveredAt;
	private Date lastStatusAt;
	private Date submittedAt;
	private String userName;
	private FailureReason failureReason;

	public SentMessageResponseImpl() {
	}

	public Date getSentat() {
		return sentAt;
	}

	public Date getDeliveredAt() {
		return deliveredAt;
	}

	public Date getLastStatusAt() {
		return lastStatusAt;
	}

	public Date getSubmittedAt() {
		return submittedAt;
	}

	public String getUserName() {
		return userName;
	}

	public FailureReason getFailureReason() {
		return failureReason;
	}

	protected void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	protected void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}

	protected void setLastStatusAt(Date lastStatusAt) {
		this.lastStatusAt = lastStatusAt;
	}

	protected void setSubmittedAt(Date submittedAt) {
		this.submittedAt = submittedAt;
	}

	protected void setUserName(String userName) {
		this.userName = userName;
	}

	public void setFailureReason(FailureReason failureReason) {
		this.failureReason = failureReason;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			super.toString() +
			"\nsentAt: " + getSentat() +
			"\ndeliveredAt: " + getDeliveredAt() +
			"\nlastStatusAt: " + getLastStatusAt() +
			"\nsubmittedAt: " + getSubmittedAt() +   
			"\nuserName: " + getUserName();
	}
}
