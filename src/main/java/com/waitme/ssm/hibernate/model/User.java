package com.waitme.ssm.hibernate.model;

public class User implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5748133581228675541L;
	
	private Long id;
	private String name;
	private Integer age;
	private Integer gender;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, Integer age, Integer gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

}
