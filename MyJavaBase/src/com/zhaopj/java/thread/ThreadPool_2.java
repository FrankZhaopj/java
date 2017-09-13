package com.zhaopj.java.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 */
public class ThreadPool_2 {
	
	static String str = "zhaopengjun";

	public static void main(String[] args) {
		String[] arr = str.split("");
		for(String s : arr) {
			System.out.print(s + "-");
		}
//		// 创建线程池
//		ExecutorService threadPool = Executors.newCachedThreadPool();
//		//创建线程
//		threadPool.execute(new Runnable() {
//			@Override
//			public void run() {
//				for(String s : arr) {
//					System.out.println(s);
//				}
//			}
//		});
	}
}
