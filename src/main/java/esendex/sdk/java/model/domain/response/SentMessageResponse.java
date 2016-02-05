package esendex.sdk.java.model.domain.response;

import java.util.Date;

import esendex.sdk.java.model.domain.impl.FailureReason;
import esendex.sdk.java.model.domain.impl.MessageResponse;
import esendex.sdk.java.model.transfer.message.FailureReasonDto;

public interface SentMessageResponse extends MessageResponse {
	
	public Date getSentat();

	public Date getDeliveredAt();

	public Date getLastStatusAt();

	public Date getSubmittedAt();

	public String getUserName();

	public FailureReason getFailureReason();

}
