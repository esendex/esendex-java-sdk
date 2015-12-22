package esendex.sdk.java.model.transfer.contact;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

@XStreamAlias("contact")
public class NewContactDto {

    @XStreamAlias("firstname")
    private String firstname;

    @XStreamAlias("lastname")
    private String lastname;

    @XStreamAlias("quickname")
    private String quickname;

    @XStreamAlias("phonenumber")
    private String phonenumber;

    @XStreamAlias("accountreference")
    private String accountreference;

    @XStreamOmitField
    private String link;
}
