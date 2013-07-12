package esendex.sdk.java.model.domain.impl;

public class PageableImpl implements Pageable {
	
	private Integer startIndex;
	private Integer count;
	private Integer totalCount;
	
	public PageableImpl() {
		super();
	}
	
	/**
	 * Gets the startindex of child elements
	 * @return the startindex
	 */
	public Integer getStartIndex() {
		return startIndex;
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
	public Integer getTotalCount() {
		return totalCount;
	}
	
	protected void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	protected void setCount(Integer count) {
		this.count = count;
	}

	protected void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return super.toString() +
			"\nstartIndex: " + startIndex +
			"\ncount: " + count +
			"\ntotalCount: " + totalCount;
	}
}
