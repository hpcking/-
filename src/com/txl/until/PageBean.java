package com.txl.until;

public class PageBean {

	private int pageNo;
	private boolean firstPage;
	private boolean lastPage;
	private int sumPage;
	private int pageSize;
	private int totalResult;

	public void setSumPage(int sumPage) {
		this.sumPage = sumPage;
	}

	public int getSumPage() {
		return sumPage;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;

	}

	public int getPageNo() {
		return pageNo;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;

	}

	public boolean getFirstPage() {
		return firstPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

	public boolean getLastPage() {
		return lastPage;
	}

	/**
	 * 获得每页的记录数
	 * 
	 * @return int
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * 设置每页的记录数
	 * 
	 * @param i
	 *            int 记录�?
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

}
