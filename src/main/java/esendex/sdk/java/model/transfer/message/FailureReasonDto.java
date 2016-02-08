package esendex.sdk.java.model.transfer.message;

import esendex.sdk.java.model.transfer.Dto;

public class FailureReasonDto extends Dto {
    private int code;
    private String description;
    private boolean permanentfailure;

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPermanentFailure() {
        return permanentfailure;
    }
}
