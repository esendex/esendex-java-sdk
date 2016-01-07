package esendex.sdk.java.model.transfer.contact;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import esendex.sdk.java.model.transfer.Dto;

@XStreamAlias("response")
public class ContactResponseDto extends Dto {

    @XStreamAlias("contact")
    private ContactDto contact;

    public ContactDto getContact() {
        return contact;
    }

    public void setContact(ContactDto contact) {
        this.contact = contact;
    }
}
