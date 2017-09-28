package com.txl.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.txl.dao.BaseDao;
import com.txl.entity.School;
import com.txl.entity.Verify;
import com.txl.server.VerifyService;


@Service("verifyService")
public class VerifyServiceimpl extends BaseServiceimpl<Verify> implements VerifyService{

	@Resource(name = "verifyDao")
	@Override
	public void setBaseDao(BaseDao<Verify> baseDao) {
		super.setBaseDao(baseDao);
	}
	@Override
	public List<Verify> selectVerifie(Object classid) {
		String hql="from Verify where classid=?";
		List<Verify> verifies=this.findEntiyByHql(hql,classid);
		return verifies;
	}
	@Override
	public List<Verify> selectVerifiePerson(Object classid, Object userid) {
		String hql="from Verify where classid=? and userid=?";
		List<Verify> verifies=this.findEntiyByHql(hql,classid,userid);
		return verifies;
	}


}
