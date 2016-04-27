package esendex.sdk.java.model.transfer.optout;

import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.PageableDto;

import java.util.ArrayList;
import java.util.List;

public class OptOutCollectionResponseDto extends PageableDto {

    @XStreamImplicit(itemFieldName = "optout")
    private List optouts = new ArrayList();

    @XStreamImplicit(itemFieldName = "link")
    private List link = new ArrayList();

    public OptOutCollectionResponseDto(List<OptOutResponseDto> optouts) {
        this.optouts = optouts;
    }

    public List getLink() {
        return link;
    }

    public void setLink(List link) {
        this.link = link;
    }

    public List<OptOutResponseDto> getOptouts() {
        return optouts;
    }

}
