package esendex.sdk.java.model.transfer.optout;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import esendex.sdk.java.model.transfer.Dto;

@XStreamAlias("optout")
public class OptOutRequestDto extends Dto {

    @XStreamAlias("from")
    private FromAddressDto fromAddress;

    @XStreamAlias("accountreference")
    private String accountReference;

    public void setFromAddress(FromAddressDto fromAddress) {
        this.fromAddress = fromAddress;
    }

    public FromAddressDto getFromAddress() {
        return fromAddress;
    }

    public void setAccountReference(String accountReference) {
        this.accountReference = accountReference;
    }

    public String getAccountReference() {
        return accountReference;
    }
}
