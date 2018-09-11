package com.sit.commons;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class CommonSearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7263123417962419018L;
	
	private HeaderSorts[] headerSorts;
	
	@NotNull
	private int linePerPage = 10;
	
	@NotNull
	private int pageIndex = 0;
	
	private boolean isCheckMaxExceed = true;
	
	public CommonSearchCriteria() {
		
	}
	
	public HeaderSorts[] getHeaderSorts() {
		return headerSorts;
	}

	public void setHeaderSorts(HeaderSorts[] headerSorts) {
		this.headerSorts = headerSorts;
	}

	public int getLinePerPage() {
		return linePerPage;
	}

	public void setLinePerPage(int linePerPage) {
		this.linePerPage = linePerPage;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public boolean isCheckMaxExceed() {
		return isCheckMaxExceed;
	}

	public void setCheckMaxExceed(boolean isCheckMaxExceed) {
		this.isCheckMaxExceed = isCheckMaxExceed;
	}

}
