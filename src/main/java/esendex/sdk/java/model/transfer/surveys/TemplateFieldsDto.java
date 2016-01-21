package esendex.sdk.java.model.transfer.surveys;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.Dto;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("templatefields")
public class TemplateFieldsDto extends Dto {

    @XStreamImplicit(itemFieldName = "templatefield")
    private List<TemplateFieldDto> templateFields = new ArrayList();

    public void setTemplateField(List<TemplateFieldDto> templateFields) {
        this.templateFields = templateFields;
    }
}
