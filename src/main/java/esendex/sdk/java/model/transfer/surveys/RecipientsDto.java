package esendex.sdk.java.model.transfer.surveys;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.Dto;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("recipients")
public class RecipientsDto extends Dto {

    @XStreamImplicit(itemFieldName = "recipient")
    private List<RecipientDto> recipients = new ArrayList();

    public void setRecipients(List<RecipientDto> recipients) {
        this.recipients = recipients;
    }
}
