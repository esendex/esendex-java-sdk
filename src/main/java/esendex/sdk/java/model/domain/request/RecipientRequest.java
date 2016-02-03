package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.TemplateField;

import java.util.ArrayList;
import java.util.List;

public class RecipientRequest {

    private String phonenumber;
    private List<TemplateField> templateFields = new ArrayList<TemplateField>();

    /**
     * @param phonenumber the phone number
     */
    public RecipientRequest(String phonenumber) {
        if (phonenumber == null)
            throw new NullPointerException("arguments can not be null");

        setPhonenumber(phonenumber);
    }

    public String getPhonenumber() { return phonenumber; }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<TemplateField> getTemplateFields() { return templateFields;  }

    public void setTemplateFields(List<TemplateField> templateFields) {
        this.templateFields = templateFields;
    }
}
