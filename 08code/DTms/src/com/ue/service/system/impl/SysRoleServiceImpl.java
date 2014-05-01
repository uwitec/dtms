package com.ue.service.system.impl;

import java.util.List;

import com.common.base.BaseService;
import com.ue.model.system.SysRole;
import com.ue.service.system.ISysRoleService;

public class SysRoleServiceImpl extends BaseService implements ISysRoleService {

	public void del(Integer sysRoleId) {
		// TODO Auto-generated method stub
		this.getBaseDao().delete("sysRoleSql.del", sysRoleId);
	}

	public List getByList() {
		// TODO Auto-generated method stub
		return this.getBaseDao().find("sysRoleSql.getByList", null);
	}

	public void save(SysRole sysRole) {
		// TODO Auto-generated method stub
		this.getBaseDao().save("sysRoleSql.save", sysRole);
	}

	public void update(SysRole sysRole) {
		// TODO Auto-generated method stub
		this.getBaseDao().update("sysRoleSql.updates", sysRole);
	}

	public SysRole getById(Integer sysRoleId) {
		return (SysRole) this.getBaseDao().get("sysRoleSql.getById", sysRoleId);
	}

	public int getLike(String sysRoleJur) {
		Integer i = 0;
		i = (Integer) this.getBaseDao().get("sysRoleSql.count", sysRoleJur);
		return i;
	}
}
