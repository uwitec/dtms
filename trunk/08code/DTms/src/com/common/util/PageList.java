package com.common.util;

import java.util.List;

public class PageList {

	private Pages page = null; // 分页对象
	private List objectList = null; // 对象集合
	private String pageStr = ""; // 分页字符串

	public List getObjectList() {
		return objectList;
	}

	public void setObjectList(List objectList) {
		this.objectList = objectList;
	}

	public Pages getPage() {
		return page;
	}

	public void setPage(Pages page) {
		this.page = page;
		pageStr = page.getLastPageBreak();
	}

	public String getPageStr() {
		return pageStr;
	}

	public void setPageStr(String pageStr) {
		this.pageStr = pageStr;
	}
}
