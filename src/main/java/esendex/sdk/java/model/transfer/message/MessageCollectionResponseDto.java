
package esendex.sdk.java.model.transfer.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import esendex.sdk.java.model.transfer.PageableDto;

/**
 * The root object for message responses. Contains a collection of
 * MessageResponses.
 * @author Mike Whittaker
 */
public class MessageCollectionResponseDto extends PageableDto implements Iterable<MessageResponseDto> {

	private String batchid;
	private List<MessageResponseDto> messageheaders;
	
	// ensure none null when no messages
	private Object readResolve() {
		if (messageheaders == null) 
			messageheaders = new ArrayList<MessageResponseDto>();
		return this;
	}
	
	/**
	 * Gets the messages.
	 * @return the messages
	 */
	public List<MessageResponseDto> getMessageheaders() {
		return messageheaders;
	}
	
	public String getBatchid() {
		return batchid;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + 
			"\nmessageheaders: " + messageheaders;
	}

	@Override
	public Iterator<MessageResponseDto> iterator() {
		return messageheaders.iterator();
	}
	
	
}
