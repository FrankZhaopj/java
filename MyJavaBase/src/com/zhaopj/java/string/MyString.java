package com.zhaopj.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyString {
	
	
	public static void main(String[] args) {
		String str = "abbssedssatashjf";
		char[] arr = str.toCharArray();
		Set<String> set = new HashSet();
		int count;
		for(char a : arr) {
			count = 0;
			for(int i=0; i<arr.length; i++) {
				if(a == str.charAt(i))
					count++;
			}
			set.add(a + " - " + count);
			count = 0;
		}
		List<String> list1 = new ArrayList<String>(set); 
		Collections.sort(list1);
		for(String s : list1) {
			System.out.println(s);
		}
	}

}
