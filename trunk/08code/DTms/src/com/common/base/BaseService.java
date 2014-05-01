package com.common.base;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BaseService<E, PK extends Serializable> {
	protected BaseDao baseDao;

	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

	public BaseDao getBaseDao() {
		return baseDao;
	}

}