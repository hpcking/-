package com.txl.server;


import java.util.List;

import com.txl.entity.Evaluate;

public interface EvaluateService extends BaseService<Evaluate> {

    //��ѯ���а༶���ҵ�����
	List<Evaluate> seleteEvaluate(Object schoolid,Object userid);

}
