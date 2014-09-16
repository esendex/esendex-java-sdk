
package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.service.auth.Authenticator;

/**
 * An XmlRequesterResponderResource is a resource that receives and sends 
 * XML data
 * 
 * @param <Q> the Dto type expected in the request
 * @param <S> the Dto type expected in the response
 * @author Mike Whittaker
 */
public abstract class XmlRequesterResponderResource<Q extends Dto, S extends Dto> extends Resource {

	private XmlRequester<Q> requester;
	private XmlResponder<S> responder;
	
	/**
	 * Instantiates a new xml requester responder resource.
	 * @param auth the authenticator
	 * @param account the account
	 * @param id the id
	 * @param query the query
	 */
	public XmlRequesterResponderResource(Authenticator auth, String account, String id, HttpQuery query) {
		super(auth, account, id, query);
	}

	/**
	 * Sets the request object.
	 * @param requestDto the new request object
	 */
	public void setRequestObject(Q requestDto) {
		this.requester = new XmlRequester<Q>(requestDto);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getRequestData() {
		return requester.getRequestData();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws EsendexException {
		super.execute();
		responder = new XmlResponder<S>(getResponse().getContent());
	}
	
	/**
	 * Gets the response object.
	 * @return the response object
	 */
	public S getResponseObject() {
		return responder.getResponseObject();
	}

}
