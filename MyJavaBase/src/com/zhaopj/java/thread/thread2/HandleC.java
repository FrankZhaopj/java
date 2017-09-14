package com.zhaopj.java.thread.thread2;

/**
 * C 通过手机银行转账 每次转账200元
 * @author Administrator
 *
 */
public class HandleC extends Thread {

	Bank bank;
	
	public HandleC(Bank bank){
		this.bank = bank;
	}
	
	@Override
	public void run() {
		while(bank.money >= 200) {
			bank.phoneBank(200);
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
