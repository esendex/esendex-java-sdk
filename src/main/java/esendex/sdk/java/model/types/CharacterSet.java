package esendex.sdk.java.model.types;

public enum CharacterSet {

    AUTO ("Auto"),
    GSM ("GSM"),
    UNICODE ("Unicode");

    private String representation;

    private CharacterSet(String representation) {
        this.representation = representation;
    }

    /**
     * To string.
     * @return the string {@inheritDoc}
     */
    public String toString() {
        return representation;
    }
}
