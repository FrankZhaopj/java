package com.zhaopj.java.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Cglib代理测试
 * 	实现：
 * 		创建代理类的实现：
			创建工具类en = new Enhancer()；设置父类en.setSuperclass(target.getClass())；
			设置回调函数en.setCallback(this)；创建代理类en.create()
 * 		调用方法的实现：
 * 			通过实现接口MethodInterceptor（重写intercept（执行arg1.invoke(target, arg2)））
 * 	优点：
 * 		与静态代理和JDK动态代理的最大好处就是，目标类不需要实现接口
 *	在Spring的AOP编程中:
 *		如果加入容器的目标对象有实现接口,用JDK代理
 *		如果目标对象没有实现接口,用Cglib代理
 */
public class App {

	public static void main(String[] args) {
		//目标对象
        UserDao target = new UserDao();
        //代理对象
//        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();
        UserDao u = (UserDao)new ProxyCglib(target).getInstance();
        u.save();
        //执行代理对象的方法
//        proxy.save();
	}

}
