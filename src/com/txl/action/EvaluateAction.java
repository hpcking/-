package com.txl.action;



import javax.annotation.Resource;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.txl.entity.Evaluate;
import com.txl.server.EvaluateService;


@Controller
@Scope("prototype")
public class EvaluateAction extends BaseAction<Evaluate> {

	private static final long serialVersionUID = 1L;

	@Resource
	private EvaluateService evaluateService;
	
	public String evaluate()
	{
		evaluateService.saveEntity(model);
		return "evaluate";
	}
}
