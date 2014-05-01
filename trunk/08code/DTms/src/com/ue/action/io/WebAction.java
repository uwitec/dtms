package com.ue.action.io;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.common.base.BaseAction;
import com.common.util.PageList;
import com.common.util.Pages;

import com.ue.model.system.SiteConfig;
import com.ue.service.system.ISiteConfigService;

public class WebAction extends BaseAction {
	private ISiteConfigService siteConfigService;
	public String index() throws Exception {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		//加载网站基本配置信息
		SiteConfig siteConfig = siteConfigService.getById(1);		
		session.setAttribute("siteConfig", siteConfig);

		
		return "index";
	}
	public ISiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(ISiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	
	
}
