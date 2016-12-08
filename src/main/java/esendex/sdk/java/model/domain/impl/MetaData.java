package esendex.sdk.java.model.domain.impl;

public class MetaData {

    private String name;
    private String value;

    public MetaData(String name, String value) {
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
