package com.txl.server;

import java.util.List;

import com.txl.entity.Verify;


public interface VerifyService extends BaseService<Verify> {
    
	//��ѯ��֤��Ϣ
	List<Verify> selectVerifie(Object classid);
	//��ѯĳ�������֤��Ϣ
	List<Verify> selectVerifiePerson(Object classid,Object userid);
}
