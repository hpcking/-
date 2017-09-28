package com.txl.server;


import java.util.List;

import com.txl.entity.ViceMonitor;

public interface ViceMonitorService extends BaseService<ViceMonitor> {

	
	//查询所有副班长userid
		List<ViceMonitor> selectViceMonitor(Object schoolid);
	//查询对应个人副班
		ViceMonitor selectViceMonitorPerson(Object schoolid,Object userid);

}
