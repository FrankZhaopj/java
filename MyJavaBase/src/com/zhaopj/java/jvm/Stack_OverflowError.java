package com.zhaopj.java.jvm;

/**
 * 爆掉栈内存
 * 		指定一个无限长的方法链，使得栈内存溢出
 * @author Administrator
 *
 */
public class Stack_OverflowError {

	/**
	 * 测试栈内存方法出口（方法连）
	 */
	public static void fun() {
		fun();
	}
	
	/**
	 * Exception in thread "main" java.lang.StackOverflowError
	 * 栈内存方法链长度过长
	 * @param args
	 */
	public static void main(String[] args) {
		fun();
	}

}
