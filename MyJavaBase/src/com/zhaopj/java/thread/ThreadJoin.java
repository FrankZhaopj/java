package com.zhaopj.java.thread;

/**
 * 三个线程，t1执行完成后执行t2,t2执行完成后执行t3
 * @param args
 * @throws InterruptedException
 */
public class ThreadJoin {
	
	static Thread t1 = new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i=0; i< 10 ;i++) {
				System.out.println(Thread.currentThread().getName() + "--" + i);
			}
		}
	});
	static Thread t2 = new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i=0; i< 10 ;i++) {
				System.out.println(Thread.currentThread().getName() + "--" + i);
			}
		}
	});
	static Thread t3 = new Thread(new Runnable() {
		@Override
		public void run() {
			for(int i=0; i< 10 ;i++) {
				System.out.println(Thread.currentThread().getName() + "--" + i);
			}
		}
	});

	public static void main(String[] args) throws InterruptedException {
		t1.start();
		t1.join();
		t2.start();
		t2.sleep(1000);
		t2.join();
		t3.start();
	}

}
