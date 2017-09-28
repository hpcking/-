package com.txl.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.txl.dao.BaseDao;
import com.txl.entity.Evaluate;

import com.txl.server.EvaluateService;


@Service("evaluateService")
public class EvaluateServiceimpl extends BaseServiceimpl<Evaluate> implements EvaluateService{

	@Resource(name = "evaluateDao")
	@Override
	public void setBaseDao(BaseDao<Evaluate> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public List<Evaluate> seleteEvaluate(Object schoolid, Object userid) {
		String hql="from Evaluate where classid=? and userid=?";
		List<Evaluate> Evaluates=this.findEntiyByHql(hql, schoolid,userid);
		return Evaluates;
	}

}
