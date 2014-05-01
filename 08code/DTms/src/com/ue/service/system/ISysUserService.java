package com.ue.service.system;

import java.util.List;
import java.util.Map;

import com.common.util.PageList;
import com.common.util.Pages;
import com.ue.model.system.SysUser;

public interface ISysUserService {
	public void save(SysUser sysUser);

	public void update(SysUser sysUser);

	public void del(Integer sysUserId);

	public SysUser login(String userName);

	public PageList getByPage(Pages pages, Integer sysRoleId);

	public int getCount(Integer sysRoleId);

	public SysUser getById(Integer sysUserId);
}
