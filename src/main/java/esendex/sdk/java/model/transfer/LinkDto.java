package esendex.sdk.java.model.transfer;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("link")
public class LinkDto {

    @XStreamAlias("rel")
    @XStreamAsAttribute
    private String rel;

    @XStreamAlias("href")
    @XStreamAsAttribute
    private String href;
}
