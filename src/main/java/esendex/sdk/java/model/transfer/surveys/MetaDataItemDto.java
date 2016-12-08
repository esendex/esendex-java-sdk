package esendex.sdk.java.model.transfer.surveys;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import esendex.sdk.java.model.transfer.Dto;

@XStreamAlias("metadataitem")
public class MetaDataItemDto extends Dto {

    @XStreamAlias("name")
    public String name;

    @XStreamAlias("value")
    public String value;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return this.value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
