package com.zhaopj.java.generics;

/**
 * 泛型方法
 * 	所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前（在下面例子中的<E>）
 * 	每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符
 * 	每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符
 * 	泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int,double,char的等）
 */
public class GenericsE {
	
	/*
	 * <E>:类型参数声明部分
	 */
	public static <E> void show(E[] arr) {
		for(E e : arr) {
			System.out.print(e + " ");
		}
	}
	
	public static void main(String[] args) {
		Integer[] arr1 = {1,2,3,4,5,6};
		Character[] arr2 = {'a','b','c','d','e','f'};
		show(arr1);
		System.out.println();
		show(arr2);
	}

}
