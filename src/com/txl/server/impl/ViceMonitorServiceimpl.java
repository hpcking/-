package com.txl.server.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.txl.dao.BaseDao;
import com.txl.entity.ViceMonitor;
import com.txl.server.ViceMonitorService;


@Service("viceMonitorService")
public class ViceMonitorServiceimpl extends BaseServiceimpl<ViceMonitor> implements ViceMonitorService{

	@Resource(name = "viceMonitorDao")
	@Override
	public void setBaseDao(BaseDao<ViceMonitor> baseDao) {
		super.setBaseDao(baseDao);
	}

	@Override
	public List<ViceMonitor> selectViceMonitor(Object schoolid) {
		String hql="from ViceMonitor where classid=?";
		List<ViceMonitor> viceMonitor=this.findEntiyByHql(hql, schoolid);
		return viceMonitor;
	}

	@Override
	public ViceMonitor selectViceMonitorPerson(Object schoolid, Object userid) {
		String hql="from ViceMonitor where classid=? and userid=?";
		List<ViceMonitor> viceMonitors=this.findEntiyByHql(hql, schoolid,userid);
		return viceMonitors.get(0);
	}

}
