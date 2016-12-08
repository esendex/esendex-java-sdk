
package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.service.auth.Authenticator;

/**
 * An XmlResponderResource is a resource that receives XML data
 * it does not send it.
 *
 * @param <S> the Dto type that is expected in response
 */
public abstract class SurveysXmlResponderResource<S> extends Resource {

	private SurveysXmlResponder<S> responder;

	public SurveysXmlResponderResource(Authenticator auth, String id, HttpQuery query, String version, String domain, boolean secure) {
		super(auth, id, query, version, domain, secure);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute() throws EsendexException {
		super.execute();
		responder = new SurveysXmlResponder<>(getResponse().getContent());
	}

	/**
	 * Gets the response object.
	 * @return the response object
	 */
	public S getResponseObject() {
		return responder.getResponseObject();
	}

}
