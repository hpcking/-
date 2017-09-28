package com.txl.server;

import java.util.List;

import com.txl.entity.School;


public interface SchoolService extends BaseService<School> {
    
	//��֤�༶�Ƿ��ظ�
	School validateSchoolInfo(School school);
	//��ѯ�ð༶��Ա
	School selectSchoolById(Object schoolid);
	//��ѯģ���༶
	List<School> selectSchoolByName(Object schoolname);
	
}
