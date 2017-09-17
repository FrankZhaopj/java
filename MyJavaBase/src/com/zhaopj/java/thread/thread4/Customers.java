package com.zhaopj.java.thread.thread4;

public class Customers extends Thread {

	KFC kfc;
	
	public Customers(KFC kfc) {
		this.kfc = kfc;
	}
	
	@Override
	public void run() {
		int size = 1+(int)(Math.random() * 3);
		while(true) {
			kfc.delete(size);
		}
	}
	
}
