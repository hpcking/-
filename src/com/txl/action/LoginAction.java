package com.txl.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txl.entity.User;
import com.txl.server.UserService;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware {

	private static final long serialVersionUID = 1L;

	@Resource
	private UserService userService;

	private Map<String, Object> session;

	public String index() {
		return "index";
	}

	public void validateIndex() {
		User user = userService.validateUserInfo(model);
		if (user != null) {
			session.put("user", user);
		} else {
			addActionError("�û������������");
		}
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
