package com.zhaopj.java.thread.thread1;

/**
 * 示例一：三个售票窗口同时出售20张票
 * 程序分析
 * 	1.票数要使用同一个静态值
 * 	2.为保证不会出现卖出同一个票数，要java多线程同步锁
 * 设计思路
 * 	1.创建一个站台类Station，继承Thread，重写run方法，在run方法里面执行售票操作！
 * 		售票要使用同步锁：即有一个站台卖这张票时，其他站台要等这张票卖完
 * 	2.创建主方法调用类
 * 
 *	http://blog.csdn.net/wenzhi20102321/article/details/52524545
 */
public class MyThread extends Thread {
	
	// 为了保持票数的一致，票数要静态
    static int ticket = 20; //volatile
    static int ticketCount = 0;
    
	// 创建一个静态钥匙
    static Object key = "key";//值是任意的

	// 通过构造方法给线程名字赋值
	public MyThread(String name) {
		super(name);// 给线程名字赋值
	}
	
	@Override
	public void run() {
		int threadTicketCount = 0;
		while(ticketCount < ticket) {
			// 这个很重要，必须使用一个锁，
			synchronized (key) {
				// 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if(ticketCount < ticket) {
					threadTicketCount++;
					ticketCount++;
					System.out.println(getName() + "卖出了第" + ticketCount + "张票,本窗口共卖了"+threadTicketCount+"张票.");
				}else {
					System.out.println("票卖完了");
				}
				try {
					sleep(500); //休息0.5秒
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MyThread myThread1 = new MyThread("窗口1");
		MyThread myThread2 = new MyThread("窗口2");
		MyThread myThread3 = new MyThread("窗口3");
		myThread1.start();
		myThread2.start();
		myThread3.start();
	}
	
}
