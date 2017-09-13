package com.zhaopj.java.constructor;

public class Son extends Father {
	
	static {
		System.out.println("Son Static");
	}
	
	{
		System.out.println("Son No Static");
	}
	
	public Son() {
		System.out.println("Son Constructor");
	}

}
