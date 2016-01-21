
package esendex.sdk.java.model.transfer.message;

import java.util.Date;
import java.util.List;

/**
 * The Class MessageCollectionRequestDto.
 */
public class MessageCollectionRequestDto extends AbstractMessageRequestDto {
	
	private Date sendat;		
	private String accountreference;
	private List<MessageRequestDto> messages;

	public MessageCollectionRequestDto(List<MessageRequestDto> messages) {
		this.messages = messages;
	}
	
	/**
	 * Sets the accountreference.
	 * @param accountreference the new accountreference
	 */
	public void setAccountreference(String accountreference) {
		this.accountreference = accountreference;
	}
	
	/**
	 * Sets the sendat.
	 * @param sendat the new sendat
	 */
	public void setSendat(Date sendat) {
		this.sendat = sendat;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() + 
			"\naccountreference: " + accountreference +
			"\nsendat: " + sendat +
			"\nmessages: " + messages;
	}
	
}
