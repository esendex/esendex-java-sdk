package esendex.sdk.java.service.resource.message;

import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.model.transfer.message.MessageCollectionRequestDto;
import esendex.sdk.java.model.transfer.message.MessageCollectionResponseDto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.XmlRequesterResponderResource;

/**
 * The Message Dispatcher resource can be used to send one or more SMS and 
 * Voice messages either straight away or scheduled in the future at a later 
 * point. The XML request object will contain the details of the message(s) 
 * to be sent and will generate a URI to allow the tracking of future changes 
 * to the object.
 * 
 * @author Mike Whittaker
 */
public class MessageDispatcherResource extends XmlRequesterResponderResource
		<MessageCollectionRequestDto, MessageCollectionResponseDto> {

	/**
	 * Instantiates a new message dispatcher resource.
	 * @param auth the Authenticator to use
	 */
	public MessageDispatcherResource(Authenticator auth) {
		super(auth, null, null, null);
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	protected String getEndpointChild() {
		return "messagedispatcher";
	}

	/** 
	 * {@inheritDoc}
	 */
	@Override
	protected HttpRequestMethod getRequestMethod() {
		return HttpRequestMethod.POST;
	}	
	
}
