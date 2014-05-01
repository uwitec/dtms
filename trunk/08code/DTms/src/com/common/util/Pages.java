package com.common.util;

import javax.servlet.http.HttpServletRequest;

public class Pages {

	private String fileName = "";
	private int pageSize = 10; // 页大小

	private int allPage = 1; // 总页数

	private int cPage = 1; // 当前页

	private int sPage = 1; // 当前页开始记录数
	private int allRecord = 1; // 总记录数
	private String lastPageBreak = ""; // 分页字符串

	private int recordNum = 0;// 返回记录数

	public Pages() {

	}

	public Pages(String fileName, HttpServletRequest request) {
		if (request != null) {
			this.fileName = request.getContextPath() + fileName;
			// 获得当前页

			String cPageStr = request.getParameter("cpage") == null ? "1"
					: request.getParameter("cpage");

			int cPageInt = 0;
			try {
				cPageInt = Integer.parseInt(cPageStr);
			} catch (Exception e) {
				System.out.println("com.Pages = " + e.getMessage());
				cPageInt = 1;
			} finally {
				cPage = cPageInt;
			}
		}

	}

	// 计算总页数,判断当前页的合法性，计算当前页的开始记录数，生成分页字符串
	public void doPage() {
		// 计算总页数

		this.allPage = (int) (this.allRecord + this.pageSize - 1)
				/ this.pageSize;

		// 判断当前页的合法性

		if (this.cPage < 0) {
			this.cPage = 1;
		}
		if (this.cPage > this.allPage) {
			this.cPage = this.allPage;
		}

		// 计算当前页开始记录数
		this.sPage = (this.cPage - 1) * this.pageSize + 1;

		// 计算返回的记录数
		int temp = this.cPage * this.pageSize - this.allRecord;
		if (temp > 0) {
			this.recordNum = this.pageSize - temp;
		} else {
			this.recordNum = this.pageSize;
		}

		// 生成分页字符串

		StringBuffer str = new StringBuffer();
		// 判断是否有问号“？”

		if (this.fileName.indexOf("?") == -1) {
			this.fileName = this.fileName + "?1=1";
		}
		// 添加表单
		str.append("<form name=\"pagelist\" method=\"post\" action=\"");
		str.append(this.fileName + "\">");
		str.append("<table width=\"600\" height=\"100%\" align=\"center\" >");

		str
				.append("<tr><td width=\"100%\" height=\"100%\" align=\"center\" valign=\"middle\">");
		/*
		 * str.append("总计"+this.allRecord+"条");
		 */
		str.append("&nbsp;");
		str.append("&nbsp;");
		str.append("&nbsp;");
		str.append("&nbsp;");
		str.append("&nbsp;");
		str.append("&nbsp;");
		// 首页
		if (this.cPage > 1) {
			str.append("<a href=" + this.fileName + "&cpage=1>首页</a>");
		} else {
			str.append("<a href='#'>");
			str.append("首页");
			str.append("</a>");
		}
		// 上一页

		if (this.cPage > 1) {
			str.append("<a href=");
			str.append(this.fileName + "&cpage=");
			str.append(this.cPage - 1);
			str.append(">上一页</a>");
		} else {
			str.append("<a href='#'>");
			str.append("上一页");
			str.append("</a>");
		}
		// 第几页

		str.append("<a href='#' >");
		str.append(this.cPage);
		str.append("/");
		// 共几页
		str.append(this.allPage);
		str.append("总计" + this.allRecord + "条");
		str.append("</a>");
		// 下一页

		if (this.cPage < this.allPage) {
			str.append("<a href=");
			str.append(this.fileName + "&cpage=");
			str.append(this.cPage + 1);
			str.append(">下一页</a>");
		} else {
			str.append("<a href='#'>");
			str.append("下一页");
			str.append("</a>");
		}
		// 末页
		if (this.cPage < this.allPage) {
			str.append("<a href=");
			str.append(this.fileName + "&cpage=");
			str.append(this.allPage);
			str.append(">末页</a>");
		} else {
			str.append("<a href='#'>");
			str.append("末页");
			str.append("</a>");
		}

		// 跳转页

		str.append("<span>转到");
		str
				.append("<select name=\"cpage\" onchange=\"document.pagelist.submit()\"  class=\"input1\">");
		for (int i = 1; i <= this.allPage; i++) {
			str.append("<option value=\"");
			str.append(i);
			str.append("\"");
			if (this.cPage == i) {
				str.append(" selected");
			}
			str.append(">");
			str.append(i);
			str.append("</option>");
		}
		str.append("</select>页</span>");

		str.append("</td></tr>");
		str.append("</table>");
		str.append("</form>");
		lastPageBreak = str.toString();

	}

	public int getAllPage() {
		return allPage;
	}

	public void setAllPage(int allPage) {
		this.allPage = allPage;
	}

	public int getCPage() {
		return cPage;
	}

	public void setCPage(int page) {
		cPage = page;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getLastPageBreak() {
		return lastPageBreak;
	}

	public void setLastPageBreak(String lastPageBreak) {
		this.lastPageBreak = lastPageBreak;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSPage() {
		return sPage;
	}

	public void setSPage(int page) {
		sPage = page;
	}

	public int getAllRecord() {
		return allRecord;
	}

	public void setAllRecord(int allRecord) {
		this.allRecord = allRecord;
	}

	public int getRecordNum() {
		return recordNum;
	}

	public void setRecordNum(int recordNum) {
		this.recordNum = recordNum;
	}

}