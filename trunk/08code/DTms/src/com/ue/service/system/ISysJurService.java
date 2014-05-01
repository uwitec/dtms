package com.ue.service.system;

import java.util.List;

import com.ue.model.system.SysJur;

public interface ISysJurService {
	public void save(SysJur sysJur);

	public void update(SysJur sysJur);

	public void del(Integer sysJurId);

	public List getByList();

	public SysJur getById(Integer sysJurId);

	public int count(String sysJurCode);
}
