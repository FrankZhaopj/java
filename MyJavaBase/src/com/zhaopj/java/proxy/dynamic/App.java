package com.zhaopj.java.proxy.dynamic;

import java.lang.reflect.Proxy;

import com.zhaopj.java.proxy.statics.IUserDao;
import com.zhaopj.java.proxy.statics.UserDao;

/**
 * 测试动态代理类（JDK动态代理）
 * 	核心是使用java反射机制实现动态代理
 * 	自己理解：
 * 		其实就是通过反射机制动态生成与目标类实现同一个接口的代理类，
 * 		其核心与静态代理相同，只不过是将代理类自己实现变成了使用反射动态自动生成的方式
 * 		核心：
 * 			通过一下方式创建代理对象
 * 			Proxy.newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
 * 	优点：代理对象与目标对象不需要实现统一接口
 * 	缺点：
 * 		但是目标对象必须实现接口
 * 		使用反射机制，就会导致在调用的过程中效率一般（相对于cglib代理方式）
 */
public class App {

	public static void main(String[] args) {
		//要被代理的对象
		IUserDao target = new UserDao();
		//调用JDK动态代理工厂创建动态代理类
		//（有参构造传入目标代理类，返回object强转成目标代理类接口对象，这也就是为什么JDK动态代理目标类要实现接口的原因）
		IUserDao proxy = (IUserDao)new ProxyFactory(target).getProxyInstance();
		//获取代理类，调用方法
		proxy.del();
		
		
		
		
		
		
		
		
		
		
		/**
		// 目标对象
        IUserDao target = new UserDao();
        // 【原始的类型class com.zhaopj.java.proxy.statics.UserDao】
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        // 【内存中动态生成的代理对象class com.sun.proxy.$Proxy0】
        System.out.println(proxy.getClass());

        // 执行方法   【代理对象】
        proxy.save();
        **/
	}

}
