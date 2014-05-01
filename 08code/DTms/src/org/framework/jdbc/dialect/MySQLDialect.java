package org.framework.jdbc.dialect;

/*
 * ********************************************************************************************
 渠程博设计
 完成于2014年4月28日18:56:35
 *********************************************************************************************	
 */
public class MySQLDialect extends Dialect {

	@Override
	public String getLimitString(String sql, int offset,
			String offsetPlaceholder, int limit, String limitPlaceholder) {
		// TODO Auto-generated method stub
		sql = sql.trim();
		boolean isForUpdate = false;
		if (sql.toLowerCase().endsWith(" for update")) {
			sql = sql.substring(0, sql.length() - 11);
			isForUpdate = true;
		}

		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);

		pagingSelect.append(sql);
		pagingSelect.append(" limit " + offset + "," + limit + "");

		if (isForUpdate) {
			pagingSelect.append(" for update");
		}

		return pagingSelect.toString();
	}

	@Override
	public boolean supportsLimit() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supportsLimitOffset() {
		// TODO Auto-generated method stub
		return true;
	}

}
