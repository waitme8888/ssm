package com.waitme.core.hibernate.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.waitme.core.hibernate.page.Page;

public interface IDao<T> {

    public void save(T entity);

    public void delete(T entity);

    public void delete(Class<T> clazz, Serializable id);
    
    public void update(T entity);
    
    public void saveOrUpdate(T entity);

    public T get(Class<T> clazz, Serializable id);
    
    public List<T> findAll(Class<T> clazz);
    
    public List<T> findByCriteria(DetachedCriteria detachedCriteria);
    
    public Page<T> findByCriteria(DetachedCriteria detachedCriteria, int pageNum, int pageSize);
    
    public int executeUpdate(String sql);
    
    public int executeUpdate(String sql, Map<String, Object> params);
    
    public int executeUpdate(String sql, List<Object> params);
    
    public int executeUpdate(String sql, Object... params);

}
