package esendex.sdk.java.model.domain.impl;

import java.util.List;

import esendex.sdk.java.model.domain.response.MessageResultResponse;
import esendex.sdk.java.model.domain.response.ResourceLinkResponse;

public class MessageResultResponseImpl implements MessageResultResponse {
	
	private String batchId;
	private List<ResourceLinkResponse> messageIds;

	public MessageResultResponseImpl(List<ResourceLinkResponse> messageIds) {
		this.messageIds = messageIds;
	}
	
	public String getBatchId() {
		return batchId;
	}

	protected void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public List<ResourceLinkResponse> getMessageIds() {
		return messageIds;
	}
	
	

}
