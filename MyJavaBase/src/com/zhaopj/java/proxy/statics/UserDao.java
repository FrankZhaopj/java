package com.zhaopj.java.proxy.statics;

/**
 * 接口实现
 * 目标对象(要被代理的类,也就是保存的核心实现)
 */
public class UserDao implements IUserDao {
	
	@Override
	public void save() {
		System.out.println("我是目标类，我的功能：保存数据；我可以被代理。");
	}
	
	@Override
	public void del() {
		System.out.println("删除数据。");
	}

}
