package esendex.sdk.java.model.domain.response;

import esendex.sdk.java.model.domain.impl.Pageable;

import java.util.List;

public interface OptOutCollectionResponse extends Pageable, Iterable<OptOutResponse> {

    List<OptOutResponse> getOptOuts();

}