package esendex.sdk.java.model.domain.response;

import java.util.Date;
import java.util.Map;

public interface StandardReportRow {
    String getRecipient();
    String getDeliveryStatus();
    String getQuestionLabel();
    Date getQuestionDateTime();
    String getAnswerLabel();
    Date getAnswerDateTime();
    String getAnswerText();
    Map<String, String> getRecipientData();
}
