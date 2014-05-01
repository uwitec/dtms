package com.ue.action.system;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.common.base.BaseAction;
import com.ue.model.system.SiteConfig;
import com.ue.service.system.ISiteConfigService;

public class SiteConfigAction extends BaseAction {
	private ISiteConfigService siteConfigService;

	public String updates() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		String str = null;

		String configId = request.getParameter("configId");
		if (configId != null && configId.length() > 0) {

		} else {
			configId = "1";
		}
		String siteName = request.getParameter("SiteName");
		String siteUrl = request.getParameter("SiteUrl");
		String siteIcp = request.getParameter("SiteIcp");
		/* String siteClose = request.getParameter("SiteClose"); */
		String siteCloseNote = request.getParameter("siteCloseNote");
		String siteMeta1 = request.getParameter("SiteMeta1");
		String siteMeta2 = request.getParameter("SiteMeta2");
		/* String indNewZp = request.getParameter("IndNewZp"); */
		String indNewJl = request.getParameter("IndNewJl");

		String companyName = request.getParameter("CompanyName");
		String addr = request.getParameter("Addr");
		String tel = request.getParameter("Tel");
		String fax = request.getParameter("Fax");
		String siteQq = request.getParameter("SiteQQ");
		String email = request.getParameter("Email");
		String newPerSh = request.getParameter("newPerSh");
		String perRegClose = request.getParameter("perRegClose");
		String newComSh = request.getParameter("newComSh");
		String perRegCloseNote = request.getParameter("perRegCloseNote");

		String mailSmtp = request.getParameter("mailSmtp");
		String mailUserName = request.getParameter("mailUserName");
		String mailPassWord = request.getParameter("mailPassWord");

		/*
		 * String comRegClose = request.getParameter("ComRegClose"); String
		 * comRegCloseNote = request.getParameter("ComRegCloseNote");
		 */
		/* String regNoName = request.getParameter("RegNoName"); */
		String jianjie1 = request.getParameter("jianjie1");
		String jianjie2 = request.getParameter("jianjie2");
		String jianjie3 = request.getParameter("jianjie3");
		/*
		 * String jianjie4 = request.getParameter("jianjie4"); String jianjie5 =
		 * request.getParameter("jianjie5"); String jianjie6 =
		 * request.getParameter("jianjie6"); String jianjie7 =
		 * request.getParameter("jianjie7");
		 */
		SiteConfig siteConfig = null;
		int id = 0;
		if (configId != null && configId.length() > 0) {
			id = Integer.parseInt(configId);

			siteConfig = siteConfigService.getById(id);
			if (siteConfig != null) {
				siteConfig.setSiteName(siteName);
				siteConfig.setSiteUrl(siteUrl);
				siteConfig.setSiteIcp(siteIcp);
				if (session.getAttribute("companyLogon") != null) {
					if (session.getAttribute("companyLogon").toString()
							.length() > 0) {
						siteConfig.setSiteLogo(session.getAttribute(
								"companyLogon").toString());
						session.removeAttribute("companyLogon");
					}
				}
				siteConfig.setSiteMeta1(siteMeta1);
				siteConfig.setSiteMeta2(siteMeta2);
				if (indNewJl != null && indNewJl.length() > 0) {
					siteConfig.setIndNewJl(Integer.parseInt(indNewJl));
				} else {
					siteConfig.setIndNewJl(0);
				}

				siteConfig.setCompanyName(companyName);
				siteConfig.setAddr(addr);
				siteConfig.setTel(tel);
				siteConfig.setFax(fax);
				siteConfig.setSiteQq(siteQq);
				siteConfig.setEmail(email);
				siteConfig.setNewComSh(newComSh);
				siteConfig.setNewPerSh(newPerSh);
				siteConfig.setPerRegClose(perRegClose);
				siteConfig.setPerRegCloseNote(perRegCloseNote);
				siteConfig.setMailSmtp(mailSmtp);
				siteConfig.setMailUserName(mailUserName);
				siteConfig.setMailPassWord(mailPassWord);
				siteConfig.setJianjie1(jianjie1);
				siteConfig.setJianjie2(jianjie2);
				siteConfig.setJianjie3(jianjie3);
				siteConfig.setSiteCloseNote(siteCloseNote);

				siteConfigService.update(siteConfig);
				str = "success";
				request.setAttribute("str", "修改成功！");
			} else {
				str = "success";
				request.setAttribute("str", "修改失败！");
			}
		} else {
			str = "success";
			request.setAttribute("str", "修改失败！");
		}
		request.setAttribute("siteConfig", siteConfig);
		return str;
	}

	public String getById() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		SiteConfig siteConfig = null;

		siteConfig = siteConfigService.getById(1);
		request.setAttribute("siteConfig", siteConfig);
		return "success";
	}

	public ISiteConfigService getSiteConfigService() {
		return siteConfigService;
	}

	public void setSiteConfigService(ISiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}

}
