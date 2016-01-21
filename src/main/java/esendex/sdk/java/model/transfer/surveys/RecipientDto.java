package esendex.sdk.java.model.transfer.surveys;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import esendex.sdk.java.model.transfer.Dto;

import java.util.ArrayList;
import java.util.List;

@XStreamAlias("recipient")
public class RecipientDto extends Dto {

    @XStreamAlias("phonenumber")
    private String phonenumber;

    @XStreamAlias("templatefields")
    private TemplateFieldsDto templateFields;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public TemplateFieldsDto getTemplateFields() {
        return templateFields;
    }

    public void setTemplateFields(TemplateFieldsDto templateFields) {
        this.templateFields = templateFields;
    }
}

