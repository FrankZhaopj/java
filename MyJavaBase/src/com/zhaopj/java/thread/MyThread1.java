package com.zhaopj.java.thread;

/**
 * 使用多线程实现卖票
 * 100张票，五个窗口同时卖票
 * @author Administrator
 *	http://blog.csdn.net/wenzhi20102321/article/details/52524545
 */
public class MyThread1 extends Thread {
	
	// 为了保持票数的一致，票数要静态
    static int ticket = 10;
    
	// 创建一个静态钥匙
    static Object key = "key";//值是任意的

	// 通过构造方法给线程名字赋值
	public MyThread1(String name) {
		super(name);// 给线程名字赋值
	}
	
	@Override
	public void run() {
		int ticketCount = 0;
		while(ticket > 0) {
			// 这个很重要，必须使用一个锁，
			synchronized (key) {
				// 进去的人会把钥匙拿在手上，出来后才把钥匙拿让出来
				if(ticket > 0) {
					ticketCount++;
					System.out.println(getName() + "卖出了第" + ticket + "张票,本窗口共卖了"+ticketCount+"张票.");
					ticket--;
				}else {
					System.out.println("票卖完了");
				}
				try {
					sleep(1000); //休息一秒
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
		MyThread1 myThread1 = new MyThread1("窗口1");
		MyThread1 myThread2 = new MyThread1("窗口2");
		MyThread1 myThread3 = new MyThread1("窗口3");
		MyThread1 myThread4 = new MyThread1("窗口4");
		MyThread1 myThread5 = new MyThread1("窗口5");
		myThread1.start();
		myThread2.start();
		myThread3.start();
		myThread4.start();
		myThread5.start();
	}
	
}
