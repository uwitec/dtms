package com.ue.service.system;

import java.util.List;

import com.ue.model.system.SysRole;

public interface ISysRoleService {
	public void save(SysRole sysRole);

	public void update(SysRole sysRole);

	public void del(Integer sysRoleId);

	public List getByList();

	public SysRole getById(Integer sysRoleId);

	public int getLike(String sysRoleJur);
}
