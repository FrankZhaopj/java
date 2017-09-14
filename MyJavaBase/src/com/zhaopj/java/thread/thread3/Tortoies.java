package com.zhaopj.java.thread.thread3;

/**
 * 
 * @author Administrator
 *
 */
public class Tortoies extends Animal {
	
	public Tortoies() {
		setName("乌龟");
	}

	@Override
	public void runing() {
		int l = 1;
		length = length - l;
		if(length <= 0) {
			length = 0;
			System.out.println("乌龟胜利了。");
			// 给回调对象赋值，让兔子不要再跑了
			if(calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("乌龟跑了" + l + "米，距离终点还有" + length + "米");
	}

}
