package com.txl.dao;

import java.io.Serializable;
import java.util.List;

import com.txl.until.PageInfo;



public interface BaseDao <T>{
	public void saveEntity(T t);

	public void saveOrUpdate(T t);

	public void updateEntity(T t);

	public void delteEntity(T t);

	public void newEntity(T t);

	public void batchEntityByHql(String hql, Object... objects);

	public T getEntity(Serializable id);

	public T loadEntity(Serializable id);

	public List<T> findEntiyByHql(String hql, Object... objects);

	public List<T> findByPageInfo(String hql, PageInfo pageInfo);

	public Object getUniqueResult(String hql, Object... objects);
}
