package com.zhaopj.java.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 创建动态代理对象
 * 特点:
 * 	动态代理不需要实现接口，但是需要指定接口类型
 * 	代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 * 	动态代理也叫做:JDK代理,接口代理
 * JDK中生成代理对象的API（代理类所在包:java.lang.reflect.Proxy）
 * 	static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h )
 * 		ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
 * 		ClassLoader loader,:指定当前目标对象使用类加载器,获取加载器的方法是固定的
 * 		InvocationHandler h:事件处理,执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
 * 代码示例:
 * 	接口类IUserDao.java以及接口实现类,目标对象UserDao是一样的,没有做修改.
 * 	在这个基础上,增加一个代理工厂类(ProxyFactory.java),将代理类写在这个地方,
 * 	然后在测试类(需要使用到代理的代码)中先建立目标对象和代理对象的联系,然后代用代理对象的中同名方法
 */
public class ProxyFactory {
	
	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}
	
	public Object getProxyInstance() {
		Object obj = null;
		/*
		 * ClassLoader loader类加载器
		 * Class<?>[] interfaces接口类型
		 * InvocationHandler h代理实现
		 */
		obj = Proxy.newProxyInstance(
				target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开始事物...");
						Object o = method.invoke(target, args);
						System.out.println("结束事物...");
						return o;
					}
					
				});
		return obj;
	}
	
}
