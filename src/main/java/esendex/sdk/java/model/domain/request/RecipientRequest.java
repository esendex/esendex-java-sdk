package esendex.sdk.java.model.domain.request;

import esendex.sdk.java.model.domain.impl.TemplateFields;

import java.util.List;

public class RecipientRequest {

    private String phonenumber;
    private List<TemplateFields> templateFields;

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

    public List<TemplateFields> getTemplateFields() { return templateFields;  }

    public void setTemplateFields(List<TemplateFields> templateFields) {
        this.templateFields = templateFields;
    }
}
