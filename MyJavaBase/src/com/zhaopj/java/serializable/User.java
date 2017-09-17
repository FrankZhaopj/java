package com.zhaopj.java.serializable;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * serialVersionUID适用于Java的序列化机制
	 * 简单来说，Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的
	 * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，
	 * 	如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
	 */
	//private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private transient int age;

	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void show() {
		System.out.println("User:" + getUsername() +"-"+ getPassword() +"-"+ getAge());
	}

}
