
package esendex.sdk.java.model.domain.impl;

import esendex.sdk.java.model.types.MessageType;
import esendex.sdk.java.model.types.Status;

/**
 * A MessageResponse is the base class for all Message responses.
 */
public abstract class MessageResponseImpl extends Identity implements MessageResponse {

	private String reference;
	private Status status;
	private MessageType type;
	private MessageContact to;
	private MessageContact from;
	private String summary;
	private MessageBody body;
	private Integer parts;
	private Identity batch;

	public MessageResponseImpl() {
	}

	public String getReference() {
		return reference;
	}

	public Status getStatus() {
		return status;
	}

	public MessageType getType() {
		return type;
	}

	public MessageContact getTo() {
		return to;
	}

	public MessageContact getFrom() {
		return from;
	}

	public String getSummary() {
		return summary;
	}

	public MessageBody getBody() {
		return body;
	}

	public Integer getParts() {
		return parts;
	}

	public Identity getBatch() { return batch; }

	protected void setReference(String reference) {
		this.reference = reference;
	}

	protected void setStatus(Status status) {
		this.status = status;
	}

	protected void setType(MessageType type) {
		this.type = type;
	}

	protected void setTo(MessageContact to) {
		this.to = to;
	}

	protected void setFrom(MessageContact from) {
		this.from = from;
	}

	protected void setSummary(String summary) {
		this.summary = summary;
	}

	protected void setBody(MessageBody body) {
		this.body = body;
	}

	protected void setParts(Integer parts) {
		this.parts = parts;
	}

	protected void setBatch(Identity batch) { this.batch = batch; }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			super.toString() +
			"\nreference: " + reference +
			"\nstatus: " + status +
			"\ntype: " + type +
			"\nto: " + to +
			"\nfrom: " + from +
			"\nsummary: " + summary +
			"\nbody: " + body +
			"\nparts: " + parts;
	}

	
}
