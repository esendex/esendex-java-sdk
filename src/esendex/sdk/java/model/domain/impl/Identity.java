package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.ResourceLinkResponse;
import esendex.sdk.java.model.domain.response.SessionResponse;

public class Identity implements SessionResponse, ResourceLinkResponse {
	
	private String id;
	private String uri;
	
	public String getId() {
		return id;
	}
	
	public String getUri() {
		return uri;
	}
	
	protected void setId(String id) {
		this.id = id;
	}

	protected void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return super.toString() +
			"\nid: " + id +
			"\nuri: " + uri;
	}
	

}
