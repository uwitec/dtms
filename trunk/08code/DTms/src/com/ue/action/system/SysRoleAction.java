package com.ue.action.system;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.common.base.BaseAction;
import com.ue.model.system.SysRole;
import com.ue.service.system.ISysRoleService;
import com.ue.service.system.ISysUserService;

public class SysRoleAction extends BaseAction {
	private ISysRoleService sysRoleService;
	private ISysUserService sysUserService;

	public String list() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String methods = "save";
		String strs = "添加角色";
		request.setAttribute("methods", methods);
		request.setAttribute("strs", strs);
		List list = sysRoleService.getByList();
		request.setAttribute("list", list);
		return "list";
	}

	public String save() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String methods = "save";
		String strs = "添加角色";
		String sysRoleId = request.getParameter("sysRoleId");
		String sysRoleName = request.getParameter("sysRoleName");
		String sysRoleJur = request.getParameter("sysRoleJur");
		String sysRoleContent = request.getParameter("sysRoleContent");

		SysRole sysRole = new SysRole();
		sysRole.setSysRoleName(sysRoleName);
		sysRole.setSysRoleContent(sysRoleContent);
		sysRole.setSysRoleJur(",,");// 角色权限默认为空，否则会出现无法回去字符串数组问题
		sysRoleService.save(sysRole);
		List list = sysRoleService.getByList();
		request.setAttribute("methods", methods);
		request.setAttribute("strs", strs);
		request.setAttribute("list", list);
		request.setAttribute("str", "添加成功！");
		return "list";
	}

	public String getById() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String methods = "save";
		String strs = "添加角色";
		String sysRoleId = request.getParameter("sysRoleId");

		SysRole sysRole = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			sysRole = sysRoleService.getById(Integer.parseInt(sysRoleId));

			if (sysRole != null) {
				methods = "updates";
				strs = "修改角色";
				request.setAttribute("sysRole", sysRole);
			} else {
				request.setAttribute("str", "操作失败！");
			}
		} else {
			request.setAttribute("str", "操作失败！");
		}
		List list = sysRoleService.getByList();
		request.setAttribute("methods", methods);
		request.setAttribute("strs", strs);
		request.setAttribute("list", list);
		return "list";
	}

	public String updates() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String methods = "save";
		String strs = "添加角色";
		String sysRoleId = request.getParameter("sysRoleId");
		String sysRoleName = request.getParameter("sysRoleName");
		String sysRoleContent = request.getParameter("sysRoleContent");
		SysRole sysRole = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			sysRole = sysRoleService.getById(Integer.parseInt(sysRoleId));
			if (sysRole != null) {
				sysRole.setSysRoleName(sysRoleName);
				sysRole.setSysRoleContent(sysRoleContent);
				sysRoleService.update(sysRole);
				request.setAttribute("str", "修改成功！");
			} else {
				request.setAttribute("str", "操作失败！");
			}
		} else {
			request.setAttribute("str", "操作失败！");
		}

		List list = sysRoleService.getByList();
		request.setAttribute("methods", methods);
		request.setAttribute("strs", strs);
		request.setAttribute("list", list);
		return "list";
	}

	public String del() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String methods = "save";
		String strs = "添加角色";
		String sysRoleId = request.getParameter("sysRoleId");
		SysRole sysRole = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			sysRole = sysRoleService.getById(Integer.parseInt(sysRoleId));
			if (sysRole != null) {
				int count = 0;
				count = sysUserService.getCount(sysRole.getSysRoleId());
				if (count > 0) {
					request.setAttribute("str", "删除失败,该角色下有所属用户不能删除！");
				} else {
					sysRoleService.del(sysRole.getSysRoleId());
					request.setAttribute("str", "删除成功！");
				}
			} else {
				request.setAttribute("str", "操作失败！");
			}
		} else {
			request.setAttribute("str", "操作失败！");
		}

		List list = sysRoleService.getByList();
		request.setAttribute("methods", methods);
		request.setAttribute("strs", strs);
		request.setAttribute("list", list);
		return "list";
	}

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public ISysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(ISysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

}
