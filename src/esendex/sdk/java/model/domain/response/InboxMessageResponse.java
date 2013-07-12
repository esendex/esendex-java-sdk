package esendex.sdk.java.model.domain.response;

import java.util.Date;

import esendex.sdk.java.model.domain.impl.MessageResponse;

public interface InboxMessageResponse extends MessageResponse {
	
	public Date getReceivedAt();

	public Date getReadAt();

	public String getReadBy();
}
