package esendex.sdk.java.model.transfer.contact;


import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("response")
public class ContactResponseDto {

    @XStreamAlias("contact")
    private NewContactDto contact;// = new ArrayList();

}
