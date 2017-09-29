package com.zhaopj.java.proxy.statics;

/**
 * 代理对象,静态代理(与被代理对象实现相同接口)
 * 	静态代理在使用时,需要定义接口或者父类,被代理对象与代理对象一起实现相同的接口或者是继承相同父类
 * 案例分析
 * 	模拟保存动作,定义一个保存动作的接口:IUserDao.java,
 * 	然后目标对象实现这个接口的方法UserDao.java,
 * 	此时如果使用静态代理方式,就需要在代理对象(UserDaoProxy.java)中也实现IUserDao接口.
 * 	调用的时候通过调用代理对象的方法来调用目标对象.
 */
public class UserDaoProxy implements IUserDao {
	
	private IUserDao target;
	
	public UserDaoProxy(IUserDao target) {
		this.target = target;
	}

	/**
	 * 增加自己需要实现的内容
	 * 调用被代理类的方法
	 */
	@Override
	public void save() {
		System.out.println("前置通知：可以开启事物；可以打印日志信息；可以处理请求等操作");
		System.out.println("下面将要执行被代理的类的方法：");
		target.save();
		System.out.println("前置通知：可以提交事物；可以打印日志信息；可以处理响应等操作");
	}
	
	@Override
	public void del() {
		System.out.println("前置通知：可以开启事物；可以打印日志信息；可以处理请求等操作");
		System.out.println("下面将要执行被代理的类的方法：");
		target.del();
		System.out.println("前置通知：可以提交事物；可以打印日志信息；可以处理响应等操作");
	}

}
