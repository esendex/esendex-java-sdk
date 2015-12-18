
package esendex.sdk.java.service.resource.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import esendex.sdk.java.EsendexException;
import esendex.sdk.java.EsendexProperties;
import esendex.sdk.java.http.HttpConnectorFactory;
import esendex.sdk.java.http.HttpException;
import esendex.sdk.java.http.HttpQuery;
import esendex.sdk.java.http.HttpRequestMethod;
import esendex.sdk.java.http.HttpResponse;
import esendex.sdk.java.parser.XmlPrettyPrinter;
import esendex.sdk.java.service.auth.Authenticator;

/**
 * A generalised Resource for connecting to the URL resource configured by.
 * {@link EsendexProperties} Optional fields for Esendex account and id may be
 * set for subclasses to utilise.
 * @author Mike Whittaker
 */
public abstract class Resource {

	private static final Log log = LogFactory.getLog(Resource.class);

    private String version;
    private HttpResponse httpResponse;
	private String account;
	private String id;
	private HttpQuery query;
	private String baseUrl;
	private Authenticator authenticator;


	public Resource(Authenticator auth, String account, String id, HttpQuery query, String version) {

		this.account = account;
		this.id = id;
		this.query = query;
		this.authenticator = auth;
        this.version = version;
		baseUrl = createParentEndpoint();
	}

    /**
     * Create a Resource service with optional account, id and/or query.
     * @param auth a ResourceAuthenticator that is appropriate for this Resource
     * @param account the Esendex account to access, may be null
     * @param id the unique identifier for a particular resource eg a message or
     *	contact ID. May be null
     * @param query the query, may be null
     */
    public Resource(Authenticator auth, String account, String id, HttpQuery query) {

        this.account = account;
        this.id = id;
        this.query = query;
        this.authenticator = auth;
        baseUrl = createParentEndpoint();
    }

	private String createParentEndpoint() {
		EsendexProperties props = EsendexProperties.instance();
		StringBuilder builder = new StringBuilder();
		builder.append("http://");
		builder.append(props.getProperty(EsendexProperties.Key.DOMAIN));
		builder.append("/");
        if(this.version != null)
		    builder.append(this.version);
        else
            builder.append(props.getProperty(EsendexProperties.Key.VERSION));
		return builder.toString();
	}

	/**
	 * Create the endpoint URL that this service will submit a request to.
	 * @return the URL that is the endpoint
	 */
	public URL getEndpoint() {
		StringBuilder builder = new StringBuilder(baseUrl);
		builder.append("/");
		builder.append(getEndpointChild());

		if (query != null) {
			builder.append('?');
			builder.append(query.toString());
		}

		try {
			return new URL(builder.toString());
		} catch (MalformedURLException ex) {
			throw new Error("Bad Endpoint", ex);
		}
	}

	/**
	 * Gets the child portion of the url required to access the resource.
	 * The child part is appended to the base url and must not start with a '/'
	 * The base url is of the form 'http://api.esendex.com/{version}/'
	 * where version maybe similar to 'v1.0'
	 *
	 * @return the child portion of the url required to access this resource
	 */
	protected abstract String getEndpointChild();

	/**
	 * Gets the HttpRequestMethod that this service
	 * stipulates eg GET, POST, PUT, DELETE.
	 * @return the required HttpRequestMethod
	 */
	protected abstract HttpRequestMethod getRequestMethod();

	/**
	 * Gets any account that is set
	 * @return the account or null if not set
	 */
	protected String getAccount() {
		return account;
	}

	/**
	 * Gets any resource id that is set
	 * @return the id or null if not set
	 */
	protected String getId() {
		return id;
	}

	/**
	 * Gets the response.
	 * @return the response
	 */
	public HttpResponse getResponse() {
		return httpResponse;
	}

	/**
	 * Retrieves the request data if any in raw String form. By default returns
	 * null
	 * @return the request data in raw form
	 */
	protected String getRequestData() {
		return null;
	}

	/**
	 * Makes and completes the connection to the resource.
	 * @throws EsendexException If there is a problem during the connection or
	 *	the HTTP response is outside the 200-299 range.
	 */
	public void execute() throws EsendexException {

		URL url = getEndpoint();
		HttpRequestMethod method = getRequestMethod();
		String data = getRequestData();

		log.info(getClass().getSimpleName());
		log.info(method + " to: " + url);
		log.info("Request: " + XmlPrettyPrinter.format(data));

		httpResponse = HttpConnectorFactory.getConnector().connect(
				url,
				method,
				data,
				authenticator);

		log.info("Response: " + httpResponse);

		if (! isHttpOkay()) throw new HttpException(
				"Status code: " + httpResponse.getStatusCode());
	}

	/**
	 * Is the Http response status code in the 200-299 range?.
	 * @return true if there is a response yet and that
	 *	!HttpResponse#isHttpOkay() returns true, else false
	 */
	public boolean isHttpOkay() {
		return httpResponse != null && httpResponse.isHttpOkay();
	}

}
