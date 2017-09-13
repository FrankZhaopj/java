package com.zhaopj.java.constructor;

public class GrandFather {

	static {
		System.out.println("GrandFather Static");
	}
	
	{
		System.out.println("GrandFather No Static");
	}
	
	public GrandFather() {
		System.out.println("GrandFather Constructor");
	}

}
