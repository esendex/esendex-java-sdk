
package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.service.auth.Authenticator;

/**
 * An XmlRequesterResource is a resource that sends
 * XML data, it does not receive it.
 *
 * @param <Q> the Dto type expected in the request
 *
 * @author Mike Whittaker
 */
public abstract class XmlRequesterResource<Q extends Dto> extends Resource {

	private XmlRequester<Q> requester;

	/**
	 * Instantiates a new xml requester resource.
	 * @param auth the authenticator
	 * @param account the account
	 * @param id the id
	 * @param query the query
	 */
	public XmlRequesterResource(Authenticator auth, String account, String id, HttpQuery query) {
		super(auth, account, id, query, "1.0");
	}

    public XmlRequesterResource(Authenticator auth, String account, String id, HttpQuery query, String version) {
        super(auth, account, id, query, version);
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
}
