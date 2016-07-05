package com.waitme.core.hibernate.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;

import com.waitme.core.hibernate.page.Page;

public class BaseDao<T> extends HibernateDaoSupport implements IDao<T>{

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

	@Override
	public List<T> findByCriteria(final DetachedCriteria detachedCriteria) {
		return getHibernateTemplate().execute(new HibernateCallback<List<T>>(){
			@SuppressWarnings("unchecked")
			public List<T> doInHibernate(Session session) throws HibernateException {
				CriteriaImpl criteria = (CriteriaImpl) detachedCriteria.getExecutableCriteria(session);
				return criteria.list();
			}
		});
	}

	@Override
	public Page<T> findByCriteria(final DetachedCriteria detachedCriteria, final int pageNum, final int pageSize) {
		return getHibernateTemplate().execute(new HibernateCallback<Page<T>>(){
			@SuppressWarnings("unchecked")
			public Page<T> doInHibernate(Session session) throws HibernateException {
				CriteriaImpl criteria = (CriteriaImpl) detachedCriteria.getExecutableCriteria(session);
				 long total = (Long) criteria.setProjection(Projections.rowCount()).uniqueResult();
		         criteria.setProjection(null);
		         criteria.setFirstResult((pageNum - 1) * pageSize);
		         criteria.setMaxResults(pageSize);
		     	 return new Page<T>(pageNum, pageSize, total, criteria.list());
			}
		});
	}
	
	@Override
	public int executeUpdate(final String sql) {
		Assert.notNull(sql);
    	return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException {
            	SQLQuery query = session.createSQLQuery(sql);
                return query.executeUpdate();
            }
        });
	}

	@Override
	public int executeUpdate(final String sql,final Map<String, Object> params) {
		Assert.notNull(sql);
    	return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException {
            	SQLQuery query = session.createSQLQuery(sql);
            	for (Map.Entry<String,Object> entry : params.entrySet()){
            		query.setParameter(entry.getKey(), entry.getValue());
            	}
                return query.executeUpdate();
            }
        });
	}

	@Override
	public int executeUpdate(final String sql, final List<Object> params) {
		Assert.notNull(sql);
    	return (Integer) getHibernateTemplate().execute(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException {
            	SQLQuery query = session.createSQLQuery(sql);
            	for (int i = 0 ; i <params.size() ; i++){
            		query.setParameter(i, params.get(i));
            	}
                return query.executeUpdate();
            }
        });
	}

	@Override
	public int executeUpdate(String sql, Object... params) {
		if (params.length == 0) {
			return this.executeUpdate(sql);
		}
		List<Object> list = new ArrayList<Object>();
		for (Object obj : params) {
			list.add(obj);
		}
		return executeUpdate(sql, list);
	}

	
}
