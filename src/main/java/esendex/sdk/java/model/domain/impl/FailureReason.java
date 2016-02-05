package esendex.sdk.java.model.domain.impl;

public class FailureReason {
    private Integer code;
    private String description;
    private boolean permanentFailure;

    public FailureReason(Integer code, String description, boolean permanentFailure) {
        this.code = code;
        this.description = description;
        this.permanentFailure = permanentFailure;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPermanentFailure() {
        return permanentFailure;
    }
}
