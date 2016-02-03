package esendex.sdk.java.service.resource.base;

import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.model.transfer.Dto;
import esendex.sdk.java.service.auth.Authenticator;
import esendex.sdk.java.service.resource.base.Resource;
import esendex.sdk.java.service.resource.base.XmlRequester;

public abstract class BaseSurveysResource<Q extends Dto> extends Resource {

	private XmlRequester<Q> requester;
	private static EsendexProperties props = EsendexProperties.instance();

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

	public BaseSurveysResource(Authenticator auth, String id, HttpQuery query, String version) {
		super(auth, id, query, version, props.getProperty(EsendexProperties.Key.SURVEYS_DOMAIN), true);

	}
}
