package com.ue.service.system;

import com.ue.model.system.SiteConfig;

public interface ISiteConfigService {
	public void update(SiteConfig siteConfig);

	public SiteConfig getById(Integer configId);
}
