package com.zhaopj.java.thread.thread3;

public abstract class Animal extends Thread {

	// 比赛路程长度
	public int length = 100;
	
	public abstract void runing();
	
	public Calltoback calltoback;
	
	@Override
	public void run() {
		super.run();
		while(length > 0) {
			runing();
		}
	}
	
	public static interface Calltoback {
		public void win();
	}

}
