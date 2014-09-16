
package esendex.sdk.java.model.transfer;

/**
 * Base xml resource class. This is the superclass for all xml resources.
 * When a Dto is the root xml entity then the xml namespace (xmlns) 
 * attribute will be set. Any Dto may have a URI attribute to provide 
 * access to a more complete resource
 * 
 * @author Mike Whittaker
 */
public abstract class Dto {
	
	private String id;
	private String uri;
	private String xmlns;
	
	public Dto() {
	}

	/**
	 * Gets the unique identifier for this entity.
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the URI that can be used to obtain more detail.
	 * @return the URI
	 */
	public String getUri() {
		return uri;
	}

	/**
	 * Gets the XML name space of when this is a root entity.
	 * @return the xmlns or null if this is not a root entity
	 */
	public String getXmlns() {
		return xmlns;
	}

	/**
	 * Sets the unique identifier for querying.
	 * @param id the id to query
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Sets the uri.
	 * @param uri the new uri
	 */
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {		
		return "id: " + id +
			"\nuri: " + uri +
			"\nxmlns: " + xmlns;
	}
}
