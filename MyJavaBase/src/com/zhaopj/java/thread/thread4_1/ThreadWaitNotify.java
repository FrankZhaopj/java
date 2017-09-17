package com.zhaopj.java.thread.thread4_1;

/**
 * 打印从1-50（两个线程，且这两个线程交替打印）
 *
 */
public class ThreadWaitNotify {

	public static void main(String[] args) {
		Print p = new Print();
		Thread t1 = new Thread(p, "Thread A");
		Thread t2 = new Thread(p, "Thread B");
		t1.start();
		t2.start();
	}
	
}

class Print implements Runnable{

	int i = 1;
	
	@Override
	public void run() {
		while(true) {
			synchronized (this) {
				notify();
				if(i <= 50) {
					System.out.println(Thread.currentThread().getName() + "-" + i);
					i++;
				}else {
					break;
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
