package esendex.sdk.java.model.domain.response;

import java.util.Date;

import esendex.sdk.java.model.domain.impl.MessageResponse;

public interface SentMessageResponse extends MessageResponse {
	
	public Date getSentat();

	public Date getDeliveredAt();

	public Date getLastStatusAt();

	public Date getSubmittedAt();

	public String getUserName();
}
