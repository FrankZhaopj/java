package com.zhaopj.java.constructor;

public class Father extends GrandFather {

	static {
		System.out.println("Father Static");
	}
	
	{
		System.out.println("Father No Static");
	}
	
	public Father() {
		System.out.println("Father Constructor");
	}
	
}
