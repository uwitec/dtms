package com.ue.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.common.base.BaseAction;
import com.ue.model.system.SysJur;
import com.ue.model.system.SysRole;
import com.ue.service.system.ISysJurService;
import com.ue.service.system.ISysRoleService;

public class SysJurAction extends BaseAction {
	private ISysJurService sysJurService;
	private ISysRoleService sysRoleService;

	public String add() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		return "add";
	}

	public String list() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		List list = sysJurService.getByList();
		request.setAttribute("list", list);
		return "list";
	}

	public String del() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		String sysJurId = request.getParameter("sysJurId");
		SysJur sysJur = null;
		if (sysJurId != null && sysJurId.length() > 0) {
			sysJur = sysJurService.getById(Integer.parseInt(sysJurId));
			if (sysJur != null) {
				int count = 0;
				count = sysRoleService.getLike(sysJur.getSysJurCode());
				if (count > 0) {
					request.setAttribute("str", "删除失败,该权限正在使用不能删除！");
				} else {
					sysJurService.del(sysJur.getSysJurId());
					request.setAttribute("str", "删除成功！");
				}
			} else {
				request.setAttribute("str", "操作失败！");
			}
		} else {
			request.setAttribute("str", "操作失败！");
		}
		List list = sysJurService.getByList();
		request.setAttribute("list", list);
		return "list";
	}

	public String save() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysJurName = request.getParameter("sysJurName");
		String sysJurCode = request.getParameter("sysJurCode");
		if (sysJurName != null && sysJurName.length() > 0 && sysJurCode != null
				&& sysJurCode.length() > 0) {
			int i = 0;
			i = sysJurService.count(sysJurCode);
			if (i > 0) {
				request.setAttribute("str", "权限代码已存在不能添加！");
			} else {
				SysJur sysJur = new SysJur();
				sysJur.setSysJurName(sysJurName);
				sysJur.setSysJurCode(sysJurCode);
				sysJurService.save(sysJur);
				request.setAttribute("str", "添加成功！");
			}
		} else {
			request.setAttribute("str", "权限名称或权限代码不能为空！");
		}
		List list = sysJurService.getByList();
		request.setAttribute("list", list);
		return "list";
	}

	public String getById() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysJurId = request.getParameter("sysJurId");
		SysJur sysJur = null;
		List list = null;
		String str = "list";
		if (sysJurId != null && sysJurId.length() > 0) {
			sysJur = sysJurService.getById(Integer.parseInt(sysJurId));
			if (sysJur != null) {
				str = "updates";
				request.setAttribute("sysJur", sysJur);
			} else {
				request.setAttribute("str", "操作失败！");
				list = sysJurService.getByList();
			}
		} else {
			request.setAttribute("str", "操作失败！");
			list = sysJurService.getByList();
		}
		request.setAttribute("list", list);
		return str;
	}

	public String updates() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysJurId = request.getParameter("sysJurId");
		String sysJurName = request.getParameter("sysJurName");
		SysJur sysJur = null;
		List list = null;
		String str = "list";
		if (sysJurId != null && sysJurId.length() > 0) {
			sysJur = sysJurService.getById(Integer.parseInt(sysJurId));
			if (sysJur != null) {
				if (sysJurName != null && sysJurName.length() > 0) {
					sysJur.setSysJurName(sysJurName);
				}
				sysJurService.update(sysJur);
				request.setAttribute("str", "修改成功！");
			} else {
				request.setAttribute("str", "操作失败！");
			}
		} else {
			request.setAttribute("str", "操作失败！");
		}
		list = sysJurService.getByList();
		request.setAttribute("list", list);
		return str;
	}

	public String power() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysRoleId = request.getParameter("sysRoleId");
		List list = null;
		String str = "power";
		SysRole sysRole = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			sysRole = sysRoleService.getById(Integer.parseInt(sysRoleId));

			if (sysRole != null) {

				List<String> pwList = new ArrayList();
				if (sysRole.getSysRoleJur() != null
						&& sysRole.getSysRoleJur().length() > 0) {
					String power = sysRole.getSysRoleJur();
					String[] pw = power.split(",");
					for (int i = 0; i < pw.length; i++) {

						pwList.add(pw[i]);

					}
				}
				request.setAttribute("pwList", pwList);
				request.setAttribute("sysRole", sysRole);
			} else {
				request.setAttribute("str", "操作失败！");
				str = "role";
			}
		} else {
			request.setAttribute("str", "操作失败！");
			str = "role";
		}
		list = sysJurService.getByList();
		request.setAttribute("list", list);
		request.setAttribute("sysRoleId", sysRoleId);
		return str;
	}

	public String typePower() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysRoleId = request.getParameter("sysRoleId");
		String powerId = request.getParameter("powerId");

		List list = null;
		String str = "power";
		SysRole sysRole = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			sysRole = sysRoleService.getById(Integer.parseInt(sysRoleId));
			if (sysRole != null) {
				sysRole.setSysRoleJur(powerId);
				sysRoleService.update(sysRole);
				List<String> pwList = new ArrayList();
				if (sysRole.getSysRoleJur() != null
						&& sysRole.getSysRoleJur().length() > 0) {
					String power = sysRole.getSysRoleJur();
					String[] pw = power.split(",");
					for (int i = 0; i < pw.length; i++) {

						pwList.add(pw[i]);

					}
				}
				request.setAttribute("pwList", pwList);
				request.setAttribute("sysRole", sysRole);
			} else {
				request.setAttribute("str", "操作失败！");
				str = "role";
			}
		} else {
			request.setAttribute("str", "操作失败！");
			str = "role";
		}
		list = sysJurService.getByList();
		request.setAttribute("list", list);
		request.setAttribute("sysRoleId", sysRoleId);
		return str;
	}

	public ISysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(ISysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public ISysJurService getSysJurService() {
		return sysJurService;
	}

	public void setSysJurService(ISysJurService sysJurService) {
		this.sysJurService = sysJurService;
	}
}
