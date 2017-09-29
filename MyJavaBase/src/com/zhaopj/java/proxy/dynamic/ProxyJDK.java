package com.zhaopj.java.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyJDK {

	private Object target;
	
	public ProxyJDK(Object target) {
		this.target = target;
	}
	
	public Object getInstance() {
		Object obj = null;
		obj = Proxy.newProxyInstance(
				target.getClass().getClassLoader(),
				target.getClass().getInterfaces(),
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("JDK动态代理前置通知；可以处理事务、日志、请求等。");
						//执行被代理对象的方法
						Object o = method.invoke(target, args);
						//后置通知
						System.out.println("JDK动态代理后置通知；可以处理事务、日志、响应等。");
						return o;
					}
				});
		return obj;
	}
	
}
