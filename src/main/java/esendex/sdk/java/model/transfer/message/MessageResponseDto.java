
package esendex.sdk.java.model.transfer.message;

import java.util.Date;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.model.types.MessageDirection;
import esendex.sdk.java.model.types.MessageType;
import esendex.sdk.java.model.types.Status;

/**
 * A MessageResponse is the base class for all Message responses.
 * This class directly holds the parsed xml data. Subclasses should 
 * merely allow selective access.
 */
public class MessageResponseDto extends Dto {
	
	private String reference;			    // all
	private Status status;				    // all
	private Date sentat;				    // outbound
	private Date deliveredat;			    // outbound
	private Date receivedat;			    // inbound
	private MessageType type;			    // all
	private MessageContactDto to;		    // all
	private MessageContactDto from;		    // all
	private Date laststatusat;			    // outbound
	private Date submittedat;  			    // outbound
	private String summary;				    // all
	private BodyDto body;				    // all
	private MessageDirection direction;	    // all
	private Integer parts;				    // all
	private String username;			    // outbound
	private Date readat;				    // inbound
	private String readby;				    // inbound
	private FailureReasonDto failurereason; // outbound
	private BatchDto batch;

	public MessageResponseDto() {
		super();
	}
	
	/**
	 * Gets the reference.
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * Gets the status.
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * Gets the sentat.
	 * @return the sentat
	 */
	public Date getSentat() {
		return sentat;
	}

	/**
	 * Gets the deliveredat.
	 * @return the deliveredat
	 */
	public Date getDeliveredat() {
		return deliveredat;
	}

	/**
	 * Gets the receivedat.
	 * @return the receivedat
	 */
	public Date getReceivedat() {
		return receivedat;
	}

	/**
	 * Gets the type.
	 * @return the type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * Gets the to.
	 * @return the to
	 */
	public MessageContactDto getTo() {
		return to;
	}

	/**
	 * Gets the from.
	 * @return the from
	 */
	public MessageContactDto getFrom() {
		return from;
	}

	/**
	 * Gets the laststatusat.
	 * @return the laststatusat
	 */
	public Date getLaststatusat() {
		return laststatusat;
	}

	/**
	 * Gets the submittedat.
	 * @return the submittedat
	 */
	public Date getSubmittedat() {
		return submittedat;
	}

	/**
	 * Gets the summary.
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Gets the body.
	 * @return the body
	 */
	public BodyDto getBody() {
		return body;
	}

	/**
	 * Gets the direction.
	 * @return the direction
	 */
	public MessageDirection getDirection() {
		return direction;
	}

	/**
	 * Gets the parts.
	 * @return the parts
	 */
	public Integer getParts() {
		return parts;
	}

	/**
	 * Gets the username.
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the readat.
	 * @return the readat
	 */
	public Date getReadat() {
		return readat;
	}

	/**
	 * Gets the readby.
	 * @return the readby
	 */
	public String getReadby() {
		return readby;
	}

	public FailureReasonDto getFailureReason() {
        return failurereason;
    }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return 
			super.toString() +
			"\nreference: " + reference +
			"\nstatus: " + status +
			"\nsentat: " + sentat +
			"\nreceivedat: " + receivedat +
			"\ndeliveredat: " + deliveredat +
			"\ntype: " + type +
			"\nto: " + to +
			"\nfrom: " + from +
			"\nlastStatusAt: " + laststatusat +
			"\nsubmittedAt: " + submittedat +   
			"\nsummary: " + summary +
			"\nbody: " + body +
			"\ndirection: " + direction +
			"\nparts: " + parts +
			"\nusername: " + username +
			"\nreadat: " + readat +
			"\nreadby: " + readby;
	}

	public BatchDto getBatch() {
		return batch;
	}
}
