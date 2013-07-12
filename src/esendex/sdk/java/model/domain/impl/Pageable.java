package esendex.sdk.java.model.domain.impl;

public interface Pageable {

	/**
	 * Gets the startindex of child elements
	 * @return the startindex
	 */
	Integer getStartIndex();

	/**
	 * Gets the count of child elements
	 * @return the count
	 */
	Integer getCount();

	/**
	 * Gets the totalcount of all elements available to be paged.
	 * @return the totalcount
	 */
	Integer getTotalCount();

}