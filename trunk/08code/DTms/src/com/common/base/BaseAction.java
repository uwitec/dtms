package com.common.base;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.framework.util.BeanUtils;

public abstract class BaseAction extends ActionSupport implements RequestAware {
	protected Map requestMap = null;

	public void copyProperties(Object target, Object source) {
		BeanUtils.copyProperties(target, source);
	}

	public <T> T copyProperties(Class<T> destClass, Object orig) {
		return BeanUtils.copyProperties(destClass, orig);
	}

	public void setRequest(Map request) {
		this.requestMap = request;
	}

	public HttpServletRequest getRequest() {

		return ServletActionContext.getRequest();
	}

	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	private String errorMsg = "";

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}