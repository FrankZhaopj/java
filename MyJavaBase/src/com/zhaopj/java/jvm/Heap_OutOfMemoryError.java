package com.zhaopj.java.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 爆掉堆内存
 * 		不断的往指定结合赋值，使得堆内存溢出
 * 
 * @author Administrator
 *
 */
public class Heap_OutOfMemoryError {

	/**
	 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	 * 堆内存溢出
	 * @param args
	 */
	public static void main(String[] args) {
		List list = new ArrayList();
		while(true) {
			list.add("zhaopj");
		}
	}

}
