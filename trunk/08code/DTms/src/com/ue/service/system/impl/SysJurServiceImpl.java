package com.ue.service.system.impl;

import java.util.List;

import com.common.base.BaseService;
import com.ue.model.system.SysJur;
import com.ue.service.system.ISysJurService;

public class SysJurServiceImpl extends BaseService implements ISysJurService {

	public void del(Integer sysJurId) {
		// TODO Auto-generated method stub
		this.getBaseDao().delete("sysJurSql.del", sysJurId);
	}

	public SysJur getById(Integer sysJurId) {
		// TODO Auto-generated method stub
		return (SysJur) this.getBaseDao().get("sysJurSql.getById", sysJurId);
	}

	public List getByList() {
		// TODO Auto-generated method stub
		return this.getBaseDao().find("sysJurSql.getByList", null);
	}

	public void save(SysJur sysJur) {
		// TODO Auto-generated method stub
		this.getBaseDao().save("sysJurSql.save", sysJur);
	}

	public void update(SysJur sysJur) {
		// TODO Auto-generated method stub
		this.getBaseDao().update("sysJurSql.updates", sysJur);
	}

	public int count(String sysJurCode) {
		Integer i = 0;
		i = (Integer) this.getBaseDao().get("sysJurSql.count", sysJurCode);
		return i;
	}
}
