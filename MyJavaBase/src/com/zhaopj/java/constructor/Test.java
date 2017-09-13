package com.zhaopj.java.constructor;

public class Test {

	/**
	 * 总结：
	 * 	父类优先级永远高于子类
	 * 	静态代码块优先级高于其他（非静态、构造器）
	 * 	非静态优先级高于构造器
	 * 
	 * 执行结果：
		GrandFather Static
		Father Static
		Son Static
		GrandFather No Static
		GrandFather Constructor
		Father No Static
		Father Constructor
		Son No Static
		Son Constructor

		Father Static
		Son Static
		Father No Static
		Father Constructor
		Son No Static
		Son Constructor
	 * @param args
	 */
	public static void main(String[] args) {
		Son son = new Son();
	}

}
