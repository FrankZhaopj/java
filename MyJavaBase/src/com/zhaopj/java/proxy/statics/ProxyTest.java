package com.zhaopj.java.proxy.statics;

/**
 * 静态代理测试
 * 	可以做到在不修改目标对象的功能前提下,对目标功能扩展.
 * 	自己理解：
 * 		静态代理，就是目标类与代理类要实现同一个接口，代理类增加有参构造，传入接口对象，
 * 		实现接口方法时可以通过接口对象调用接口方法（这里是java多态的应用体现）
 * 		实例化代理类时，传入目标类，调用代理类的方法即可调用目标类的方法，同时还可以做其他操作
 * 		好处：代理模式是为了安全起见，不改变代理类的同时，实现代理类的调用
 * 		缺点：必须实现代理类且必须实现同一接口
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
		userDaoProxy.del();
	}

}
