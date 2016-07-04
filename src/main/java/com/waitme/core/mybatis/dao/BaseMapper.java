package com.waitme.core.mybatis.dao;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.Mapper;

/**
 * 持久层基础接口
 * 
 */
public interface BaseMapper<T> extends Mapper<T>, ConditionMapper<T> {

}