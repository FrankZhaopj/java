package com.zhaopj.java.thread;

/**
 * 使用多线程实现卖票 100张票，五个窗口同时卖票
 * 
 * @author Administrator
 *
 */
public class MyThreadRunnable implements Runnable {
	
	int ticket = 5;
	Object obj = "key";

	@Override
	public void run() {
		synchronized (obj) {
			while(ticket > 0) {
				System.out.println(Thread.currentThread().getName() + "卖1张票,余票"+ticket+"张");
				ticket--;
			}
		}
	}

	/**
	 * 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		MyThreadRunnable mt = new MyThreadRunnable();
		Thread t1 = new Thread(mt, "窗口1");
		Thread t2 = new Thread(mt, "窗口2");
		Thread t3 = new Thread(mt, "窗口3");
		t1.sleep(100);
		t1.start();
		t2.sleep(100);
		t2.start();
		t3.start();
		t3.sleep(100);
	}

}
