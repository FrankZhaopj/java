package com.zhaopj.java.thread.thread5;

public class MyThread1 {

	public static void main(String[] args) {
		Operation o1 = new Operation(true);
		Operation o2 = new Operation(false);
		Thread t1 = new Thread(o1, "线程1");
		Thread t2 = new Thread(o1, "线程2");
		Thread t3 = new Thread(o2, "线程3");
		Thread t4 = new Thread(o2, "线程4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
	
}

class Operation implements Runnable{
	
	boolean op = false;
	
	public Operation(boolean op) {
		this.op = op;
	}
	
	static int num = 10;
	
	@Override
	public void run() {
		while(true) {
			if(op) {
				num = num + 5;
				System.out.println("add：" + num);
			}else {
				num = num - 3;
				System.out.println("minus：" + num);
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
