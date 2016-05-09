
package esendex.sdk.java.model.transfer.optout;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@XStreamAlias("optout")
public class OptOutResponseDto extends Dto {

    @XStreamAlias("accountreference")
    private String accountreference;

    @XStreamAlias("receivedat")
    private Date receivedat;

    @XStreamAlias("from")
    private FromAddressDto from;

    @XStreamImplicit(itemFieldName = "link")
    private List link = new ArrayList();

    public String getAccountReference() {
        return accountreference;
    }

    public Date getReceivedAt() {
        return receivedat;
    }

    public FromAddressDto getFrom() {
        return from;
    }
}