package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.domain.response.StandardReportRow;

import java.util.Date;
import java.util.Map;

public class StandardReportRowImpl implements StandardReportRow {
    private String recipient;
    private String deliveryStatus;
    private String questionLabel;
    private Date questionDateTime;
    private String answerLabel;
    private Date answerDateTime;
    private String answerText;
    private Map<String, String> recipientData;

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getQuestionLabel() {
        return questionLabel;
    }

    public void setQuestionLabel(String questionLabel) {
        this.questionLabel = questionLabel;
    }

    public Date getQuestionDateTime() {
        return questionDateTime;
    }

    public void setQuestionDateTime(Date questionDateTime) {
        this.questionDateTime = questionDateTime;
    }

    public String getAnswerLabel() {
        return answerLabel;
    }

    public void setAnswerLabel(String answerLabel) {
        this.answerLabel = answerLabel;
    }

    public Date getAnswerDateTime() {
        return answerDateTime;
    }

    public void setAnswerDateTime(Date answerDateTime) {
        this.answerDateTime = answerDateTime;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public Map<String, String> getRecipientData() {
        return recipientData;
    }

    public void setRecipientData(Map<String, String> recipientData) {
        this.recipientData = recipientData;
    }
}
