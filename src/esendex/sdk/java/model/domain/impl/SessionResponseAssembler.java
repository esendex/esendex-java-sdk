package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.SessionResponse;
import esendex.sdk.java.model.transfer.session.SessionDto;

public class SessionResponseAssembler {
	
	public SessionResponse createResponse(SessionDto dto) {
		
		Identity resp = new Identity();
		resp.setId(dto.getId());
		return resp;
	}
	
	
}
