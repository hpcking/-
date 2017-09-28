package com.txl.server;

import java.util.List;

import com.txl.entity.School;


public interface SchoolService extends BaseService<School> {
    
	//验证班级是否重复
	School validateSchoolInfo(School school);
	//查询该班级成员
	School selectSchoolById(Object schoolid);
	//查询模糊班级
	List<School> selectSchoolByName(Object schoolname);
	
}
