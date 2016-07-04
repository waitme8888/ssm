package com.waitme.core.hibernate.dao;

import java.io.Serializable;
import java.util.List;

public interface IDao<T> {

    public void save(T entity);

    public void delete(T entity);

    public void delete(Class<T> clazz, Serializable id);
    
    public void update(T entity);
    
    public void saveOrUpdate(T entity);

    public List<T> findAll(Class<T> clazz);
    
    public T get(Class<T> clazz, final Serializable id);

}
