package com.txl.server;

import java.util.List;

import com.txl.entity.Verify;


public interface VerifyService extends BaseService<Verify> {
    
	//查询认证信息
	List<Verify> selectVerifie(Object classid);
	//查询某班个人认证信息
	List<Verify> selectVerifiePerson(Object classid,Object userid);
}
