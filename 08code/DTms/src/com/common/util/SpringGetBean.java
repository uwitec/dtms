package com.common.util;

/**
 * 获取spring加载的xml里面的bean申明
 * 2014年4月21日21:26:31
 */
import java.util.HashMap;
import java.util.Map;



public class SpringGetBean {


	public static Object getBean(String beanName) {
		Object obj = null;
		Map<String, Object> map = new HashMap();
		obj = map.get(beanName);
		return obj;
	}
}
