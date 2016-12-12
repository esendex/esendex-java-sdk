package esendex.sdk.java.model.types;

/**
 * Represents what to filter reports on
 * (sent).
 * @author Mike Whittaker
 */
public enum DateRangeType {

    QUESTION_SENT ("QuestionSent"),
    ANSWER_RECEIVED ("AnswerReceived");

    private String representation;

    private DateRangeType(String representation) {
        this.representation = representation;
    }

    public String toString() {
        return representation;
    }
}
