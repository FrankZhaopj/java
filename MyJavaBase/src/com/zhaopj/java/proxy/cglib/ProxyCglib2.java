package com.zhaopj.java.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * cglib動態代理2
 * 
 *
 */
public class ProxyCglib2 implements MethodInterceptor {
	
	@Override
	public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("前置通知");
		Object invokeSuper = methodProxy.invokeSuper(o, args);
		System.out.println("后置通知");
		return invokeSuper;
	}
	
	
	public static void main(String[] args) {
		ProxyCglib2 proxyCglib2 = new ProxyCglib2();
		//工具類
		Enhancer en = new Enhancer();
		//設置父類
		en.setSuperclass(UserDao.class);
		//設置回調函數
		en.setCallback(proxyCglib2);
		//創建代理類
		UserDao u = (UserDao)en.create();
		//調用方法
		u.save();
	}

}
