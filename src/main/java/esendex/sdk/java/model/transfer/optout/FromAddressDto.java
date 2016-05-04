package esendex.sdk.java.model.transfer.optout;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import esendex.sdk.java.model.transfer.Dto;

@XStreamAlias("from")
public class FromAddressDto extends Dto {

    @XStreamAlias("phonenumber")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}