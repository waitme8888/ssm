package com.waitme.core.hibernate.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import com.waitme.core.hibernate.dao.IDao;

public class BaseService<T> {

	@Resource
	protected IDao<T> dao;
	
    protected Class<T> entityClass;
    
    @SuppressWarnings("unchecked")
	public BaseService() {
    	this.entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

	public void save(T entity) {
		dao.save(entity);
	}

	public void delete(T entity) {
		dao.delete(entity);
	}

	public void delete(Serializable id) {
		dao.delete(entityClass, id);
	}

	public void update(T entity) {
		dao.update(entity);
	}

	public void saveOrUpdate(T entity) {
		dao.saveOrUpdate(entity);
	}

	public List<T> findAll() {
		return dao.findAll(entityClass);
	}

	public T get(final Serializable id) {
		return dao.get(entityClass, id);
	}
}
