package com.zhaopj.java.thread.thread2;

/**
 * 示例二：三种途径操作一个账户
 * 	A:柜台操作,每次500、B:ATM操作,每次100、C:通过手机银行操作,每次10
 * 程序分析
 * 	钱的数量要设置成一个静态的变量。三种方式要取的同一个对象值
 * 
 *	http://blog.csdn.net/wenzhi20102321/article/details/52524545
 */
public class MyThread extends Thread {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Bank bank = new Bank();
		HandleA handleA = new HandleA(bank);
		HandleB handleB = new HandleB(bank);
		HandleC handleC = new HandleC(bank);
		handleA.start();
		handleB.start();
		handleC.start();
	}
	
}
