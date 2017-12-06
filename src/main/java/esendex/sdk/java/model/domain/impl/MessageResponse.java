package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.MessageType;
import esendex.sdk.java.model.types.Status;

public interface MessageResponse {

	String getId();
	
	String getReference();

	Status getStatus();

	MessageType getType();

	MessageContact getTo();

	MessageContact getFrom();

	String getSummary();

	MessageBody getBody();

	Integer getParts();

	Identity getBatch();

}