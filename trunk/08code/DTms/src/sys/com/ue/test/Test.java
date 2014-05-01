package sys.com.ue.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.common.util.NowDate;
import com.common.util.PageList;
import com.common.util.Pages;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("/resources/config/spring/applicationContext.xml");
		/*ISysUserService sysUserService = (ISysUserService) cont.getBean("sysUserService");
		System.out.println(sysUserService.getCount(3));*/
		/*SysUser sysUser = new SysUser();
		for(int i =0;i<30;i++){
			sysUser.setSysUserName(""+i+"");
			sysUserService.save(sysUser);
		}
		System.out.println(sysUserService.getCount(null));
		*/
	/*	
		ISysRoleService sysRoleService = (ISysRoleService) cont.getBean("sysRoleService");
		System.out.println(sysRoleService.getById(3).getSysRoleName());*/
		/*ISiteConfigService siteConfigService = (ISiteConfigService) cont.getBean("siteConfigService");
		SiteConfig siteConfig = siteConfigService.getById(1);
		System.out.println("siteConfig="+siteConfig.getSiteName());
		siteConfig.setSiteName("3535356");
		siteConfigService.update(siteConfig);
		siteConfig = siteConfigService.getById(1);
		System.out.println("siteConfig="+siteConfig.getSiteName());*/
		
		System.out.println(System.getProperty("file.encoding")); 

	}

}
