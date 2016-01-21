package esendex.sdk.java.model.domain.impl;

public class TemplateFields {

    private String name;
    private String value;

    public TemplateFields(String name, String value)
    {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }


    public String getValue() {
        return value;
    }

}


