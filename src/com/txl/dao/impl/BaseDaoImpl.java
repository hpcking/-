package com.txl.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.txl.dao.BaseDao;
import com.txl.until.PageInfo;


@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	private Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		this.clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	@Resource
	private SessionFactory sessionFactory;

	@Override
	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	@Override
	public void saveOrUpdate(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	@Override
	public void delteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	@Override
	public void newEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void batchEntityByHql(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}

	@Override
	public T getEntity(Serializable id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public T loadEntity(Serializable id) {
		return (T) sessionFactory.getCurrentSession().load(clazz, id);
	}

	@Override
	public List<T> findEntiyByHql(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		return query.list();
	}

	@Override
	public List<T> findByPageInfo(String hql, PageInfo pageInfo) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		pageInfo.setTotalResult(query.list().size());
		query.setFirstResult(pageInfo.getBeginResult());
		query.setMaxResults(pageInfo.getPageSize());
		return query.list();
	}

	@Override
	public Object getUniqueResult(String hql, Object... objects) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		return query.uniqueResult();
	}
}
