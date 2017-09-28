package com.txl.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txl.entity.User;
import com.txl.entity.Verify;
import com.txl.server.VerifyService;


@Controller
@Scope("prototype")
public class VerifyAction extends BaseAction<Verify>  {

	private static final long serialVersionUID = 1L;

	@Resource
	private VerifyService verifyService;
	public String verify()
	{
		User user=new User();
		user.setUserid(model.getUserid());
		model.setUser(user);
		verifyService.saveEntity(model);
		return "verify";
	}


}
