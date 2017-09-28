package com.txl.server.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import com.txl.dao.BaseDao;

import com.txl.server.BaseService;
import com.txl.until.PageInfo;
@SuppressWarnings("unchecked")
public abstract class BaseServiceimpl<T> implements BaseService<T>{

	private BaseDao<T> baseDao;

	private Class<T> clazz;

	public BaseServiceimpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void saveEntity(T t) {
		baseDao.saveEntity(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		baseDao.saveOrUpdate(t);
	}

	@Override
	public void updateEntity(T t) {
		baseDao.updateEntity(t);
	}

	@Override
	public void delteEntity(T t) {
		baseDao.delteEntity(t);
	}

	@Override
	public void newEntity(T t) {
		baseDao.newEntity(t);
	}

	@Override
	public void batchEntityByHql(String hql, Object... objects) {
		baseDao.batchEntityByHql(hql, objects);
	}

	@Override
	public T getEntity(Serializable id) {
		return baseDao.getEntity(id);
	}

	@Override
	public T loadEntity(Serializable id) {
		return baseDao.loadEntity(id);
	}

	@Override
	public List<T> findEntiyByHql(String hql, Object... objects) {
		return baseDao.findEntiyByHql(hql, objects);
	}

	@Override
	public List<T> findAll() {
		String hql = "from " + this.clazz.getSimpleName();
		return baseDao.findEntiyByHql(hql);
	}

	@Override
	public List<T> findByPageInfo(PageInfo pageInfo) {
		String hql = "from " + this.clazz.getSimpleName();
		return baseDao.findByPageInfo(hql, pageInfo);
	}

	@Override
	public Object getUniqueResult(String hql, Object... objects) {
		return baseDao.getUniqueResult(hql, objects);
	}
}
