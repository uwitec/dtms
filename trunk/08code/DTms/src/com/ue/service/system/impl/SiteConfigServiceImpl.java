package com.ue.service.system.impl;

import com.common.base.BaseService;
import com.ue.model.system.SiteConfig;
import com.ue.service.system.ISiteConfigService;

public class SiteConfigServiceImpl extends BaseService implements
		ISiteConfigService {

	public void update(SiteConfig siteConfig) {
		// TODO Auto-generated method stub
		this.baseDao.update("siteConfigSql.updates", siteConfig);
	}

	public SiteConfig getById(Integer configId) {
		return (SiteConfig) this.getBaseDao().get("siteConfigSql.getById",
				configId);
	}

}
