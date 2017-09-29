package com.zhaopj.java.annotation;

@CreateTable("user_table")
public class UserEntity {

	@CreateProperty(name="user_name", length=30)
	private String userName;
	@CreateProperty(name="user_age", length=3)
	private int userAge;

}
