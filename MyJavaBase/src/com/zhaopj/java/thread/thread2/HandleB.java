package com.zhaopj.java.thread.thread2;

/**
 * B 通过ATM取款 每次取100元
 * @author Administrator
 *
 */
public class HandleB extends Thread {

	Bank bank;
	
	public HandleB(Bank bank){
		this.bank = bank;
	}
	
	@Override
	public void run() {
		while(bank.money >= 100) {
			bank.atm(100);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
