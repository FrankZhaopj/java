package com.zhaopj.java.generics;

/**
 * 泛型
 */
public class GenericsT {
	
	public static <T extends Comparable<T>> T comp(T x, T y, T z) {
		T max = x;
		if(y.compareTo(max) > 0) {
			max = y;
		}
		if(z.compareTo(max) > 0) {
			max = z;
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(comp(1,2,3));
		System.out.println(comp("a","b","c"));
	}

}
