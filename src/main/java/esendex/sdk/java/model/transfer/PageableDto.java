
package esendex.sdk.java.model.transfer;

/**
 * A PageableDto is a base xml resource class. This is a dataholder for xml 
 * attributes relating to resource pageing.
 * 
 * @author Mike Whittaker
 */
public class PageableDto extends Dto {

	private Integer startindex;
	private Integer count;
	private Integer totalcount;
	
	public PageableDto() {
		super();
	}
	
	/**
	 * Gets the startindex of child elements
	 * @return the startindex
	 */
	public Integer getStartindex() {
		return startindex;
	}
	
	/**
	 * Gets the count of child elements
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}
	
	/**
	 * Gets the totalcount of all elements available to be paged.
	 * @return the totalcount
	 */
	public Integer getTotalcount() {
		return totalcount;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nstartindex: " + startindex +
			"\ncount: " + count +
			"\ntotalcount: " + totalcount;
	}
}
