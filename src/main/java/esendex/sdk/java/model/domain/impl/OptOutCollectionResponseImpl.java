package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.OptOutCollectionResponse;
import esendex.sdk.java.model.domain.response.OptOutResponse;

import java.util.Iterator;
import java.util.List;

public class OptOutCollectionResponseImpl extends PageableImpl implements OptOutCollectionResponse {

    private List<OptOutResponse> optouts;

    public OptOutCollectionResponseImpl(List<OptOutResponse> optouts) {
        this.optouts = optouts;
    }

    public List<OptOutResponse> getOptOuts() {
        return optouts;
    }

    public void setOptouts(List<OptOutResponse> optouts) {
        this.optouts = optouts;
    }

    @Override
    public Iterator<OptOutResponse> iterator() {
        return null;
    }

}