package esendex.sdk.java.model.transfer.surveys;

import esendex.sdk.java.model.transfer.Dto;

import java.util.*;

public class StandardReportRowDto extends Dto {
    public StandardReportRowDto() {
        super();
    }

    private String recipient;
    private String status;
    private String questionlabel;
    private Date questiondatetime;
    private String answerlabel;
    private Date answerdatetime;
    private String answertext;
    private Map<String, String> recipientdata = new HashMap<String, String>();

    public String getRecipient() {
        return recipient;
    }

    public String getDeliveryStatus() {
        return status;
    }

    public String getQuestionLabel() {
        return questionlabel;
    }

    public Date getQuestionDateTime() {
        return questiondatetime;
    }

    public String getAnswerLabel() {
        return answerlabel;
    }

    public Date getAnswerDateTime() {
        return answerdatetime;
    }

    public String getAnswerText() {
        return answertext;
    }

    public Map<String,String> getRecipientData() {
        return recipientdata;
    }
}
