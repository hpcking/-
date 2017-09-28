package com.txl.action;

import java.lang.reflect.ParameterizedType;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.txl.until.PageInfo;

@SuppressWarnings("unchecked")
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, ServletRequestAware {

	private static final long serialVersionUID = 1L;

	protected T model;
	protected HttpServletRequest requset;
	protected PageInfo pageInfo;

	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class<T> clazz = (Class<T>) type.getActualTypeArguments()[0];
			this.model = clazz.newInstance();
			requset = ServletActionContext.getRequest();
			pageInfo = new PageInfo(requset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public T getModel() {
		return model;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.requset = request;

	}

}
