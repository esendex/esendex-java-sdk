
package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.service.auth.Authenticator;

/**
 * An XmlResponderResource is a resource that receives XML data
 * it does not send it.
 *
 * @param <S> the Dto type that is expected in response
 */
public abstract class XmlResponderResource<S extends Dto> extends Resource {

	private XmlResponder<S> responder;

	/**
	 * Instantiates a new xml responder resource.
	 * @param auth the authenticator
	 * @param account the account
	 * @param id the id
	 * @param query the query
	 */
	public XmlResponderResource(Authenticator auth, String account, String id, HttpQuery query) {
		super(auth, account, id, query, "1.0");
	}

    public XmlResponderResource(Authenticator auth, String account, String id, HttpQuery query, String version) {
        super(auth, account, id, query, version);
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
