package com.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class BaseDao<E, PK extends Serializable> extends SqlMapClientDaoSupport {
	protected final Log log = LogFactory.getLog(super.getClass());

	public Object get(String sqlId, PK primaryKey) {
		Object object = getSqlMapClientTemplate().queryForObject(sqlId,
				primaryKey);
		return object;
	}

	public Object get(String sqlId, Object primaryKey) {
		Object object = getSqlMapClientTemplate().queryForObject(sqlId,
				primaryKey);
		return object;
	}

	public Object get(String sqlId, Map param) {
		Object object = getSqlMapClientTemplate().queryForObject(sqlId, param);
		return object;
	}

	public void delete(String sqlId, PK id) {
		getSqlMapClientTemplate().delete(sqlId, id);
	}

	// 批量删除
	public void deleteBatch(String sqlId, E entity) {
		getSqlMapClientTemplate().delete(sqlId, entity);
	}

	public List find(String sqlId, Map parameterMap) {
		return getSqlMapClientTemplate().queryForList(sqlId, parameterMap);
	}

	/**
	 * 一个参数
	 * 
	 * @param sqlId
	 * @param parameterInt
	 * @return
	 */
	public List find(String sqlId, Object parameterObject) {
		return getSqlMapClientTemplate().queryForList(sqlId, parameterObject);
	}

	public List find(String statementName, Object parameterObject,
			int firstResult, int pageSize) {
		List list = getSqlMapClientTemplate().queryForList(statementName,
				parameterObject, firstResult, pageSize);
		return list;
	}

	public void save(String sqlId, E entity) {
		prepareObjectForSaveOrUpdate(entity);
		Object primaryKey = getSqlMapClientTemplate().insert(sqlId, entity);
	}

	public void update(String sqlId, E entity) {
		prepareObjectForSaveOrUpdate(entity);
		Object primaryKey = Integer.valueOf(getSqlMapClientTemplate().update(
				sqlId, entity));
	}

	protected void prepareObjectForSaveOrUpdate(E o) {

	}

}