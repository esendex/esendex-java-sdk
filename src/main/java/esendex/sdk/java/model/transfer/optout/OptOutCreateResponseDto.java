package esendex.sdk.java.model.transfer.optout;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class OptOutCreateResponseDto {

    @XStreamAlias("optout")
    private OptOutResponseDto optOut;

    public OptOutResponseDto getOptOut() {
        return optOut;
    }
}