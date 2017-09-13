package com.zhaopj.java.jvm;

/**
 * 1,程序计数器：简单来说就是让jvm知道下一步该操作什么区域
 * 2,java的堆内存和栈内存
 * 		栈内存(stack)：
 * 			局部变量表（变量的内存地址）
 * 			方法出口（方法连）
 * 		堆内存(heap)：真正的对象
 */
public class JVMStackHeap {

	/**
	 * 如果接受的参数是基本类型，那么是：值传递
	 * @param a
	 */
	public static void fun(int a) {
		a = 2;
	}
	
	/**
	 * 如果接受的参数是对象，那么是：引用传递（也叫作：内存地址传递）
	 * @param arr
	 */
	public static void fun(int[] arr) {
		arr[0] = -1;
	}
	
	/**
	 * 如果接受的参数是String，那么是：副本传递
	 * @param str
	 */
	public static void fun(String str) {
		str = "papapa";
	}
	
	/**
	 * java：值传递、引用传递、副本传递
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * 值传递
		 */
		System.out.println("-----------值传递-----------");
		int a = 1;
		fun(a);
		System.out.println(a);
		//引用传递
		System.out.println("-----------值传递-----------");
		/*
		 * 引用传递
		 */
		System.out.println("-----------引用传递-----------");
		int[] arr = {1,2,3,4,5};
		fun(arr);
		for(int i : arr) {
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println("-----------引用传递-----------");
		/*
		 * 副本传递
		 */
		System.out.println("-----------副本传递-----------");
		String str = "memeda";
		fun(str);
		System.out.println(str);
		System.out.println("-----------副本传递-----------");
	}

}
