package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.request.OptOutRequest;
import esendex.sdk.java.model.transfer.optout.FromAddressDto;
import esendex.sdk.java.model.transfer.optout.OptOutRequestDto;

public class OptOutRequestAssembler {

    public OptOutRequestDto createOptOutDto(OptOutRequest optOutRequest) {

        OptOutRequestDto dto = new OptOutRequestDto();

        FromAddressDto fromAddress = new FromAddressDto();
        fromAddress.setPhoneNumber(optOutRequest.getFromAddress().getPhoneNumber());

        dto.setFromAddress(fromAddress);
        dto.setAccountReference(optOutRequest.getAccountReference());

        return dto;
    }
}
