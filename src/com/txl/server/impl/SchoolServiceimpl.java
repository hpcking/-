package com.txl.server.impl;


import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;


import com.txl.dao.BaseDao;
import com.txl.entity.School;
import com.txl.server.SchoolService;

import com.txl.until.ValidateUtils;

@Service("schoolService")
public class SchoolServiceimpl extends BaseServiceimpl<School> implements SchoolService{

	@Resource(name = "schoolDao")
	@Override
	public void setBaseDao(BaseDao<School> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public School validateSchoolInfo(School school) {
		// TODO 自动生成的方法存根
		String hql = "from School where schoolname=?";
		String schoolname = school.getSchoolname();
		List<School> schools = this.findEntiyByHql(hql, schoolname);
		return ValidateUtils.isValidate(schools) ? schools.get(0) : null;
	}

	@Override
	public School selectSchoolById(Object schoolid) {
		String hql="from School where schoolid=?";
		List<School> schools=this.findEntiyByHql(hql, schoolid);
		return ValidateUtils.isValidate(schools) ? schools.get(0) : null;
	}

	@Override
	public List<School> selectSchoolByName(Object schoolname) {
		// TODO 自动生成的方法存根
		String hql="from School where schoolname like '%"+(String)schoolname+"%'";
		List<School> schools=this.findEntiyByHql(hql);
		return schools;
	}	
}
