package com.txl.server;


import java.util.List;

import com.txl.entity.ViceMonitor;

public interface ViceMonitorService extends BaseService<ViceMonitor> {

	
	//��ѯ���и��೤userid
		List<ViceMonitor> selectViceMonitor(Object schoolid);
	//��ѯ��Ӧ���˸���
		ViceMonitor selectViceMonitorPerson(Object schoolid,Object userid);

}
