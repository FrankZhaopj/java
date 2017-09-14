package com.zhaopj.java.thread.thread2;

/**
 * 银行
 * @author Administrator
 */
public class Bank {

	public static int money = 3000;
	
	/**
	 * 柜台取款
	 * @param money
	 */
	public void counter(int money) {
		Bank.money = Bank.money - money;
		System.out.println("柜台取款"+money+"元；余额"+Bank.money+"元");
	}
	
	/**
	 * ATM取款
	 * @param money
	 */
	public void atm(int money) {
		Bank.money = Bank.money - money;
		System.out.println("ATM取款"+money+"元；余额"+Bank.money+"元");
	}
	
	/**
	 * 手机银行转账
	 * @param money
	 */
	public void phoneBank(int money) {
		Bank.money = Bank.money - money;
		System.out.println("手机银行转账"+money+"元；余额"+Bank.money+"元");
	}

}
