package com.zhaopj.java.generics;

/**
 * 泛型类
 */
public class Generics2<T> {

	private T t;
	
	public void add(T t) {
		this.t = t;
	}
	
	public T get() {
		return this.t;
	}
	
	public static void main(String[] args) {
		Generics2<Integer> integer = new Generics2<Integer>();
		Generics2<String> string = new Generics2<String>();
	 
		integer.add(new Integer(10));
		string.add(new String("zhaopj"));
	 
	    System.out.printf("整型值为 : %d\n", integer.get());
	    System.out.printf("字符串为 : %s\n", string.get());
	}

}
