package com.zhaopj.java.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyCglib implements MethodInterceptor {

	private Object target;
	
	public ProxyCglib(Object target) {
		this.target = target;
	}
	
	//获取cglib代理对象
	public Object getInstance() {
		Object obj = null;
		//创建工具类
		Enhancer en = new Enhancer();
		//设置父类
		en.setSuperclass(target.getClass());
		//设置回调函数
		en.setCallback(this);
		//创建子类（代理对象）
		obj = en.create();
		return obj;
	}
	
	
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		//cglib动态代理前置通知
		System.out.println("CGLIB动态代理前置通知");
		//执行代理对象的方法
		Object o = arg1.invoke(target, arg2);
		//cglib动态代理后置通知
		System.out.println("CGLIB动态代理后置通知");
		return o;
	}

}
