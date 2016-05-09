package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
import esendex.sdk.java.model.domain.response.OptOutResponse;
import esendex.sdk.java.model.transfer.optout.OptOutCollectionResponseDto;
import esendex.sdk.java.model.transfer.optout.OptOutResponseDto;

import java.util.ArrayList;
import java.util.List;

public class OptOutResponseAssembler {

    public OptOutResponse createResponse(OptOutResponseDto dto) {

        OptOutResponseImpl response = new OptOutResponseImpl();

        response.setId(dto.getId());
        response.setAccountReference(dto.getAccountReference());
        response.setReceivedAt(dto.getReceivedAt());

        FromAddress from = new FromAddress();
        from.setPhoneNumber(dto.getFrom().getPhoneNumber());
        response.setFrom(from);

        return response;
    }

    public OptOutCollectionResponse createCollectionResponse(OptOutCollectionResponseDto col) {

        List<OptOutResponse> optouts = new ArrayList<>();
        if (col.getOptouts() != null) {
            for (OptOutResponseDto dto : col.getOptouts()) {
                optouts.add(this.createResponse(dto));
            }
        }

        OptOutCollectionResponseImpl response = new OptOutCollectionResponseImpl(optouts);
        response.setCount(col.getCount());
        response.setStartIndex(col.getStartindex());
        response.setTotalCount(col.getTotalcount());

        return response;
    }
}
