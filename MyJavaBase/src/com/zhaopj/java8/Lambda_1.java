package com.zhaopj.java8;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public class Lambda_1 {

	public static void main(String[] args) {
		/**
		 * 用lambda表达式实现Runnable
		 */
		//常规方式
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("123");
			}
		}).start();
		//lanbda表达式
		new Thread(() -> System.out.println("234")).start();
		
		//
		
		
		
		
		/**
		 * 使用lambda表达式对列表进行迭代
		 */
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		//传统模式
		for (String feature : features) {
			System.out.println(feature);
		}
		//lambda表达式
		features.forEach(n -> System.out.println("lambda "+n));
		//使用Java 8的方法引用，方法引用由::双冒号操作符标示，
		features.forEach(System.out::println);
	}
	
	public void add(int a, int b) {
		System.out.println(a + b);
	}

}
