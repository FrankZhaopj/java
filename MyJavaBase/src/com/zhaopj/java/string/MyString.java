package com.zhaopj.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * 
 */
public class MyString {
	
	public static void main(String[] args) {
		fun22();
	}
	
	/**
	 * 返回指定字符串的每个字符在该字符串中出现的次数，排序输出
	 * by zhaopj
	 */
	public void fun1(String str) {
		str = "abbssedssatashjf";
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
	
	/**
	 * 返回指定字符串的每个字符在该字符串中出现的次数，排序输出
	 * by chunf
	 */
	public static Map<String, Integer> fun21(String string) {
		Map<String, Integer> dataMap = new HashMap<>();
		String[] array = string.split("");
		for (String str: array) {
			Integer i = dataMap.get(str);
			if (i == null) {
				dataMap.put(str, 1);
			} else {
				dataMap.put(str, i + 1);
			}
		}
		return dataMap;
	}
	
	/**
	 * 返回指定字符串的每个字符在该字符串中出现的次数，排序输出
	 * by chunf
	 */
	public static void fun22() {
		String string = "abbssedssatashjf";
		Map<String, Integer> dataMap = fun21(string);
		Set<Entry<String, Integer>> entrySet = dataMap.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<>();
		list.addAll(entrySet);
		Collections.sort(list, new Comparator<Entry<String, Integer>>(){
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				if (o1.getValue() > o2.getValue())
					return -1;
				else
					return 0;
			}
		});
		for (Entry<String, Integer> e: list) {
			String str = e.getKey();
			Integer i = e.getValue();
			String result = str + " - " + i;
			System.out.println(result);
		}
	}
	
}
