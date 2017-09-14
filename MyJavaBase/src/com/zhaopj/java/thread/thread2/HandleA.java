package com.zhaopj.java.thread.thread2;

/**
 * A 通过柜台取款 每次取500元
 * @author Administrator
 *
 */
public class HandleA extends Thread {

	Bank bank;
	
	public HandleA(Bank bank){
		this.bank = bank;
	}
	
	@Override
	public void run() {
		while(bank.money >= 500) {
			bank.counter(500);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
