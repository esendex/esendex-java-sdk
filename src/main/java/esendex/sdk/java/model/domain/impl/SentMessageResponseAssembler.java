package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.SentMessageResponse;
import esendex.sdk.java.model.transfer.message.FailureReasonDto;
import esendex.sdk.java.model.transfer.message.MessageResponseDto;

public class SentMessageResponseAssembler extends MessageResponseAssembler {

	public SentMessageResponseAssembler(MessageResponseDto dto) {
		super(dto);
	}
	
	public SentMessageResponse createResponse() {
		SentMessageResponseImpl response = new SentMessageResponseImpl();
		populateResponse(response);
		return response;
	}

	protected void populateResponse(SentMessageResponseImpl response) {
		super.populateResponse(response);
		response.setDeliveredAt(dto.getDeliveredat());
		response.setLastStatusAt(dto.getLaststatusat());
		response.setSentAt(dto.getSentat());
		response.setSubmittedAt(dto.getSubmittedat());
		response.setUserName(dto.getUsername());

		if (dto.getFailureReason() != null) {
			FailureReasonDto reason = dto.getFailureReason();
			response.setFailureReason(new FailureReason(reason.getCode(), reason.getDescription(), reason.isPermanentFailure()));
		}
	}
}
