package com.ue.action.system;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.common.base.BaseAction;
import com.common.util.ClientGetIp;
import com.common.util.MD5;
import com.common.util.NowDate;
import com.common.util.PageList;
import com.common.util.Pages;
import com.common.util.Vcode;
import com.ue.model.system.SysRole;
import com.ue.model.system.SysUser;
import com.ue.service.system.ISysJurService;
import com.ue.service.system.ISysRoleService;
import com.ue.service.system.ISysUserService;

public class RootAction extends BaseAction {
	private ISysUserService sysUserService;
	private ISysRoleService sysRoleService;
	private ISysJurService sysJurService;

	public String login() throws Exception {
		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		String staffNbr = request.getParameter("staffNbr");
		String password = request.getParameter("password");
		String vcodes = request.getParameter("vcodes");

		if (staffNbr != null && staffNbr.length() > 0 && password != null
				&& password.length() > 0 && vcodes != null
				&& vcodes.length() > 0) {

			if (session.getAttribute("codes") != null) {
				String codes = session.getAttribute("codes").toString();
				if (vcodes.equals(codes)) {
					SysUser user = sysUserService.login(staffNbr);
					if (user != null
							&& user.getSysUserPwd().equals(MD5.toMD5(password))) {
						String dates = NowDate.getStringDateShortHSS();
						String ips = ClientGetIp.getIpAddr(request);
						user.setLoginIp(ips);
						user.setLoginDate(dates);
						sysUserService.update(user);
						SysRole sysRole = sysRoleService.getById(user
								.getSysRoleId());
						if (sysRole != null) {
							String[] roles = sysRole.getSysRoleJur().split(",");
							request.setAttribute("roles", roles);
						}

						session.setAttribute("login", "1");
						session.setAttribute("user", user);
						session.removeAttribute("codes");
						session.removeAttribute("images");

						request.setAttribute("indexurl",
								"/ueadmin_ue/include/JSP.jsp");
						str = "success";
					} else {
						request.setAttribute("codeError", "用户名或密码错误！");
						str = "intdex";
					}
				} else {
					request.setAttribute("codeError", "验证码错误！");
					str = "intdex";
				}
			} else {
				request.setAttribute("codeError", "验证码错误！");
				str = "intdex";
			}
		} else {
			String userNameError = "用户名或密码不能为空！";
			request.setAttribute("userNameError", userNameError);
			str = "intdex";
		}
		return str;
	}

	public String logout() throws Exception {

		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		if (session.getAttribute("login") != null) {
			session.removeAttribute("user");
			session.removeAttribute("login");
			session.removeAttribute("role");

		}
		return "logout";
	}

	public String index() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		Vcode vcode = new Vcode();
		String code = vcode.randomString();
		String[] vcodes = code.split("-");
		String codes = vcodes[0];
		String codesImage = vcodes[1];
		session.setAttribute("codes", codes);
		session.setAttribute("images", codesImage);
		str = "intdex";
		return str;
	}

	public String pwd() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		str = "pwd";
		return str;
	}

	public String updatePwd() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		String userpwd = request.getParameter("userpwd");
		if (userpwd != null && userpwd.length() > 0) {
			if (session.getAttribute("user") != null) {
				SysUser user = (SysUser) session.getAttribute("user");
				user.setSysUserPwd(MD5.toMD5(userpwd));
				sysUserService.update(user);
				session.setAttribute("user", user);
			}
		}
		request.setAttribute("str", "密码修改成功！");
		str = "pwdsuccess";
		return str;
	}

	public String list() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysRoleId = request.getParameter("sysRoleId");
		Integer i = null;
		if (sysRoleId != null && sysRoleId.length() > 0) {
			i = Integer.parseInt(sysRoleId);
		} else {
			sysRoleId = "";
		}

		// 封装分页跳转路径
		Pages page1 = new Pages("/rootAction!list.action?sysRoleId="
				+ sysRoleId, request);
		// 封装页大小
		page1.setPageSize(20);
		PageList pageList = null;
		pageList = sysUserService.getByPage(page1, i);
		List listType = sysRoleService.getByList();

		request.setAttribute("listType", listType);
		request.setAttribute("pageList", pageList);

		str = "list";
		return str;
	}

	public String del() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysUserId = request.getParameter("sysUserId");
		Integer i = null;
		if (sysUserId != null && sysUserId.length() > 0) {
			i = Integer.parseInt(sysUserId);
			sysUserService.del(i);
			str = "删除成功！";
		} else {
			str = "删除失败！";
		}
		// 封装分页跳转路径
		Pages page1 = new Pages("/rootAction!list.action?sysRoleId=", request);
		// 封装页大小
		page1.setPageSize(20);
		PageList pageList = null;
		pageList = sysUserService.getByPage(page1, null);

		List listType = sysRoleService.getByList();

		request.setAttribute("listType", listType);
		request.setAttribute("pageList", pageList);
		request.setAttribute("str", str);
		str = "list";
		return str;
	}

	public String chekout() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysUserId = request.getParameter("sysUserId");
		String isLock = request.getParameter("isLock");

		Integer i = null;
		if (sysUserId != null && sysUserId.length() > 0) {
			i = Integer.parseInt(sysUserId);
			SysUser sysUser = sysUserService.getById(i);
			if (isLock != null && isLock.length() > 0) {
				sysUser.setSysUserState(Integer.parseInt(isLock));
				sysUserService.update(sysUser);
				str = "操作成功！";
			} else {
				str = "操作失败！";
			}
		} else {
			str = "操作失败！";
		}
		// 封装分页跳转路径
		Pages page1 = new Pages("/rootAction!list.action?sysRoleId=", request);
		// 封装页大小
		page1.setPageSize(20);
		PageList pageList = null;
		pageList = sysUserService.getByPage(page1, null);

		List listType = sysRoleService.getByList();

		request.setAttribute("listType", listType);
		request.setAttribute("pageList", pageList);
		request.setAttribute("str", str);
		str = "list";
		return str;
	}

	public String mypower() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			SysUser user = null;
			user = (SysUser) session.getAttribute("user");
			if (user != null) {
				SysRole sysRole = sysRoleService.getById(user.getSysRoleId());
				List list = sysJurService.getByList();
				String[] roles = sysRole.getSysRoleJur().split(",");
				List<String> pwList = new ArrayList();
				for (int i = 0; i < roles.length; i++) {
					String roleStr = null;
					roleStr = roles[i];
					if (roleStr != null && roleStr.length() > 0) {
						pwList.add(roleStr);
					}
				}
				request.setAttribute("sysRole", sysRole);
				request.setAttribute("list", list);
				request.setAttribute("pwList", pwList);
				str = "mypower";
			} else {
				str = "intdex";
			}
		} else {
			str = "intdex";
		}
		return str;
	}

	public String save() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String sysRoleId = request.getParameter("sysRoleId");
		String sysUserName = request.getParameter("sysUserName");
		String sysUserPwd = request.getParameter("userpwd");
		if (sysRoleId != null && sysRoleId.length() > 0 && sysUserName != null
				&& sysUserName.length() > 0 && sysUserPwd != null
				&& sysUserPwd.length() > 0) {
			SysUser sysUser = null;
			sysUser = sysUserService.login(sysUserName);
			if (sysUser != null) {
				List typeList = sysRoleService.getByList();
				request.setAttribute("typeList", typeList);
				request.setAttribute("str", "用户名已存在！");
				str = "save";
			} else {
				sysUser = new SysUser();
				sysUser.setSysUserName(sysUserName);
				sysUser.setSysRoleId(Integer.parseInt(sysRoleId));
				sysUser.setSysUserState(1);
				sysUser.setSysUserPwd(MD5.toMD5(sysUserPwd));
				sysUserService.save(sysUser);
				// 封装分页跳转路径
				Pages page1 = new Pages("/rootAction!list.action?sysRoleId=",
						request);
				// 封装页大小
				page1.setPageSize(20);
				PageList pageList = null;
				pageList = sysUserService.getByPage(page1, null);

				List listType = sysRoleService.getByList();

				request.setAttribute("listType", listType);
				request.setAttribute("pageList", pageList);
				request.setAttribute("str", "开通成功！");
				str = "list";
			}
		} else {
			List typeList = sysRoleService.getByList();
			request.setAttribute("typeList", typeList);
			request.setAttribute("str", "开通失败，资料填写不完整！");
			str = "save";
		}

		return str;
	}

	public String add() throws Exception {

		String str = null;
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();

		List typeList = sysRoleService.getByList();

		str = "save";
		request.setAttribute("typeList", typeList);
		return str;
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

	public ISysJurService getSysJurService() {
		return sysJurService;
	}

	public void setSysJurService(ISysJurService sysJurService) {
		this.sysJurService = sysJurService;
	}

}
