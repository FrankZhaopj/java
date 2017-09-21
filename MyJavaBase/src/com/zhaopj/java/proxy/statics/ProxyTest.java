package com.zhaopj.java.proxy.statics;

/**
 * 静态代理测试
 * 	可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 	缺点：
 * 		因为代理对象需要与目标对象实现一样的接口,所以会有很多代理类,类太多.同时,一旦接口增加方法,目标对象与代理对象都要维护
 */
public class ProxyTest {

	public static void main(String[] args) {
		//目标对象
		UserDao userDao = new UserDao();
		//代理对象,把目标对象传给代理对象,建立代理关系
		UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
		//执行代理对象的方法
		userDaoProxy.save();
	}

}
