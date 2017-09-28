package com.txl.until;

import javax.servlet.http.HttpServletRequest;

/**
 * �?要注入HttpServletRequest对象，用于封装界面上的分页参�?
 * 
 * @author Administrator
 * 
 */
public class PageInfo {
	// HTTP请求
	private HttpServletRequest req;
	// 每页的记录数
	private int pageSize = 10;
	// 当前�?
	private int currentPageNo = 1;
	// �?始记录数
	private int beginResult = 0;
	// 总记录数
	private int totalResult = 0;
	// 总页�?
	private int totalPage = 0;

	private PageBean page = null;

	/**
	 * 初始�?
	 * 
	 * @param req
	 *            HttpServletRequest HTTP请求
	 */
	public PageInfo(HttpServletRequest req) {
		this.currentPageNo = req.getParameter("pageNO") != null && !req.getParameter("pageNO").equals("")
				? new Integer(req.getParameter("pageNO")).intValue() : 1;
		this.pageSize = req.getParameter("pagesize") != null && !req.getParameter("pagesize").equals("")
				? new Integer(req.getParameter("pagesize")).intValue() : 10;
		if (this.pageSize <= 0) {

			this.pageSize = 10;

		}
		this.req = req;
	}

	public PageInfo() {
		this.currentPageNo = 1;
		this.pageSize = 10;

	}

	public PageInfo(int currentPageNo) {

		this.currentPageNo = currentPageNo;
		this.pageSize = 10;

	}

	/**
	 * 计算总页�?
	 */
	private void countPages() {
		if (totalResult == 0) {
			this.totalPage = 1;
		} else {
			this.totalPage = (totalResult / pageSize); // 总共几页
			if ((totalResult % pageSize) != 0)
				this.totalPage = this.totalPage + 1;
		}
	}

	public boolean isFirstPage() {

		if (this.currentPageNo <= 1) {

			return true;
		} else {
			return false;
		}
	}

	public boolean isLastPage() {

		if (this.currentPageNo >= this.totalPage) {

			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获得当前�?
	 * 
	 * @return int 当前�?
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
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
	 * 获得总记录数
	 * 
	 * @return int
	 */
	public int getTotalResult() {
		return totalResult;
	}

	/**
	 * 设置当前�?
	 * 
	 * @param current
	 *            int 当前页码
	 */
	public void setCurrentPageNo(int current) {
		this.currentPageNo = current;
	}

	/**
	 * 设置每页的记录数
	 * 
	 * @param i
	 *            int 记录�?
	 */
	public void setPageSize(int i) {
		this.pageSize = i;
	}

	/**
	 * 获得�?始记录数
	 * 
	 * @return int �?始记录数
	 */
	public int getBeginResult() {
		if (totalPage != 1) {
			if (currentPageNo >= totalPage) {
				currentPageNo = totalPage;
				beginResult = (currentPageNo - 1) * pageSize;
				pageSize = totalResult - beginResult;
			} else {

				beginResult = (currentPageNo - 1) * pageSize;
			}
		}
		if (totalPage == 1) {
			currentPageNo = totalPage;

			beginResult = 0;
			pageSize = totalResult;
		}
		setRequestValue();
		return beginResult;
	}

	/**
	 * @param i
	 */
	public void setBeginResult(int i) {
		this.beginResult = i;
	}

	/**
	 * 获得总页�?
	 * 
	 * @return int 总页�?
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalResult
	 *            The totalResult to set. 设置该分页信息�?�共有多少条记录
	 */
	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
		countPages();
	}

	/**
	 * 设置序号
	 */
	private void setRequestValue() {
		page = new PageBean();
		page.setFirstPage(isFirstPage());
		page.setLastPage(isLastPage());
		page.setPageNo(currentPageNo);
		page.setPageSize(pageSize);
		page.setSumPage(totalPage);
		page.setTotalResult(totalResult);

	}

	public PageBean getPageBean() {
		return page;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * 获取request对象
	 * 
	 * @return
	 */
	public HttpServletRequest getReq() {
		return req;
	}

}
