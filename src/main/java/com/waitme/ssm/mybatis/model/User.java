package com.waitme.ssm.mybatis.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.waitme.core.mybatis.model.BaseModel;

public class User extends BaseModel {
    /**
	 * 
	 */
	private static final long serialVersionUID = -5365526327154599301L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别，0：男，1：女
     */
    private Integer gender;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取性别，0：男，1：女
     *
     * @return gender - 性别，0：男，1：女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别，0：男，1：女
     *
     * @param gender 性别，0：男，1：女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }
}