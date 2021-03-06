package com.zhaopj.java.thread.thread3;

/**
 * 示例三：龟兔赛跑问题
 * 	1.兔子每秒5米的速度，每跑20米休息1秒
 * 	2.乌龟每秒跑1米，不休息
 * 	3.其中一个跑到终点后另一个不跑了
 * 程序分析
 * 	1.创建一个Animal动物类，继承Thread，编写一个running抽象方法，重写run方法，把running方法在run方法里面调用
 * 	2.创建Rabbit兔子类和Tortoise乌龟类，继承动物类
 * 	3.两个子类重写running方法
 * 	4.本题的第3个要求涉及到线程回调。需要在动物类创建一个回调接口，创建一个回调对象
 * 
 *	http://blog.csdn.net/wenzhi20102321/article/details/52524545
 */
public class MyThread extends Thread {

	public static void main(String[] args) {
		Rabbit r = new Rabbit();
		Tortoies t = new Tortoies();
		LetOneStop rStop = new LetOneStop(r);
		LetOneStop tStop = new LetOneStop(t);
		r.calltoback = tStop;
		t.calltoback = rStop;
		r.start();
		t.start();
	}
	 
}
