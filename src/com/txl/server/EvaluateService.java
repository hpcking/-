package com.txl.server;


import java.util.List;

import com.txl.entity.Evaluate;

public interface EvaluateService extends BaseService<Evaluate> {

    //查询所有班级对我的评价
	List<Evaluate> seleteEvaluate(Object schoolid,Object userid);

}
