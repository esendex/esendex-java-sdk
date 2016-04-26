package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.model.transfer.optout.OptOutResponseDto;

public class OptOutResponseAssembler {

    public OptOutResponse createResponse(OptOutResponseDto dto) {

        OptOutResponseImpl resp = new OptOutResponseImpl();

        resp.setId(dto.getId());
        resp.setAccountReference(dto.getAccountReference());
        resp.setReceivedAt(dto.getReceivedAt());

        FromAddressImpl from = new FromAddressImpl();
        from.setPhoneNumber(dto.getFrom().getPhoneNumber());
        resp.setFrom(from);

        return resp;
    }
}
