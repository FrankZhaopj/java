package com.zhaopj.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author Administrator
 *
 */
public class Lambda_2 {

	public static void main(String[] args) {
		/**
		 * 用lambda表达式实现Runnable
		 */
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
//		filter(languages, (str)->str.startsWith("J"));
		languages.forEach((String s) -> System.out.println(s));
		
	}
	
	public static void filter(List<String> names, Predicate condition) {
		for(String name : names) {
			if(condition.test(name)) {
				System.out.println(name);
			}
		}
	}
	
	public static boolean startsWith(String s) {
		if("J".equals(s.indexOf(0))) {
			return true;
		}
		return false;
	}

}
