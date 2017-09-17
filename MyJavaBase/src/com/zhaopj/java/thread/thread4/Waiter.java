package com.zhaopj.java.thread.thread4;

public class Waiter extends Thread {

	KFC kfc ;
	
	public Waiter(KFC kfc) {
		this.kfc = kfc;
	}
	
	@Override
	public void run() {
		int size = (int)(Math.random()*3) + 1;
		System.out.println("create number : " + size);
		while(true) {
			kfc.create(size);
		}
	}
	
}
