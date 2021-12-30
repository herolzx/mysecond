package com.situ.util;

/**
 * 页面信息
 */
public final class PaginateInfo {
	private static final Integer DEFAULT_PAGENO = 1;
	private static final Integer DEFAULT_PAGESIZE = 5;
	// 查询全部
	public static final PaginateInfo MAX_LINIT = new PaginateInfo(DEFAULT_PAGENO, Integer.MAX_VALUE);
	public static final PaginateInfo DEFAULT = new PaginateInfo(DEFAULT_PAGENO, DEFAULT_PAGESIZE);

	private Integer pageNo; // 第几页/当前页
	private Integer pageSize;// 每页显示多少行
	private Integer count;// 总行数
	private Integer pages;// 总页数
	private Integer navItemCount = 4;// 页导航

	public PaginateInfo(Integer pageNo, Integer pageSize) {
		super();
		setPageNo(pageNo);
		setPageSize(pageSize);
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
		if (pageNo == null) {
			this.pageNo = DEFAULT_PAGENO;
		} else {
			this.pageNo = pageNo < 1 ? 1 : pageNo;
		}
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
	}

	public Integer getPages() {
		return pages;

	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Integer getNavItemCount() {
		return navItemCount;
	}

	public void setNavItemCount(Integer navItemCount) {
		this.navItemCount = navItemCount;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getCount() {
		return count;

	}

	/**
	 * 设置总记录数
	 */
	public void setCount(Integer count) {
		this.count = count;
		this.pages = count / getPageSize();// 总页数
		if (count % getPageSize() > 0) {
			this.pages += 1;
		}
		// 重新修正当前页码，当总页大于0且当前页码大于总页时
		if (this.pages > 0 && this.pageNo > pages) {// 1>0时会把 当前页码会变成0
			this.pageNo = pages;
		}
	}

	/**
	 * 从第几个位置开始查
	 */
	public Integer getOffset() {//
		return (this.pageNo - 1) * this.pageSize;
	}

	/**
	 * 查询多少条
	 */
	public Integer getLimit() {
		return this.getPageSize();
	}

	/**
	 * 导航页起始值
	 */
	public int getNavItemStart() {
		int cnt = this.navItemCount / 2;
		int start = this.pageNo - cnt;
		if (start < 1) {
			start = 1;
		}
		return start;
	}

	/**
	 * 导航页结束值
	 */
	public int getNavItemEnd() {
		int end = getNavItemStart() + navItemCount - 1;
		if (end > this.pages) {
			end = this.pages;
		}
		return end;
	}

	/**
	 * 获取总页数
	 */
	public Integer getTotalPages() {
		return pages;
	}

}
