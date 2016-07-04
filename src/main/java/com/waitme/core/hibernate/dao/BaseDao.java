package com.waitme.core.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

public class BaseDao<T> extends HibernateDaoSupport implements IDao<T>{
	
//    protected Class<T> entityClass;
//    
//    @SuppressWarnings("unchecked")
//	public BaseDao() {
//    	this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }

	@Override
	public void save(T entity) {
		 Assert.notNull(entity);
		 getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().delete(entity);
	}

	@Override
	public void delete(Class<T> clazz, Serializable id) {
		Assert.notNull(id);
		delete(get(clazz, id));
	}

	@Override
	public T get(Class<T> clazz, Serializable id) {
		Assert.notNull(id);
		return (T)getHibernateTemplate().get(clazz, id);
	}

	@Override
	public void update(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		Assert.notNull(entity);
		getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public List<T> findAll(Class<T> clazz) {
		return (List<T>)getHibernateTemplate().loadAll(clazz);
	}
	
}
