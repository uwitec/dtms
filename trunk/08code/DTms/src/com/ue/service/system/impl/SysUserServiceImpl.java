package com.ue.service.system.impl;

import java.util.List;

import com.common.base.BaseService;
import com.common.util.PageList;
import com.common.util.Pages;
import com.ue.model.system.SysUser;
import com.ue.service.system.ISysUserService;

public class SysUserServiceImpl extends BaseService implements ISysUserService {

	public void del(Integer sysUserId) {
		// TODO Auto-generated method stub
		this.getBaseDao().delete("sysUsersql.deleteUserId", sysUserId);
	}

	public SysUser login(String userName) {
		// TODO Auto-generated method stub
		SysUser sysUser = (SysUser) this.getBaseDao().get(
				"sysUsersql.getByName", userName);
		return sysUser;
	}

	public void save(SysUser sysUser) {
		// TODO Auto-generated method stub
		this.getBaseDao().save("sysUsersql.insert", sysUser);
	}

	public void update(SysUser sysUser) {
		// TODO Auto-generated method stub
		this.getBaseDao().update("sysUsersql.updates", sysUser);
	}

	public PageList getByPage(Pages pages, Integer sysRoleId) {
		int count = 0;
		int i = pages.getCPage();
		if (i == 0) {
			i = 1;
		}
		SysUser sysUser = new SysUser();
		sysUser.setSysRoleId(sysRoleId);
		PageList pageList = new PageList();
		List list = null;
		count = this.getCount(sysRoleId);
		pages.setAllRecord(count);
		pages.doPage();
		list = this.getBaseDao().find("sysUsersql.pageSelect", sysUser,
				(i - 1) * pages.getPageSize(), pages.getPageSize());
		pageList.setPage(pages);
		pageList.setObjectList(list);
		return pageList;
	}

	public int getCount(Integer sysRoleId) {
		Integer i = 0;
		SysUser sysUser = new SysUser();
		sysUser.setSysRoleId(sysRoleId);
		i = (Integer) this.getBaseDao().get("sysUsersql.count", sysUser);
		return i;
	}

	public SysUser getById(Integer sysUserId) {
		return (SysUser) this.getBaseDao().get("sysUsersql.getById", sysUserId);
	}
}
