package com.zhaopj.java.thread.thread3;

/**
 * 
 * @author Administrator
 *
 */
public class Rabbit extends Animal {
	
	public Rabbit() {
		setName("兔子");
	}

	@Override
	public void runing() {
		int l = 5;
		length = length - l;
		if(length <= 0) {
			length = 0;
			System.out.println("兔子胜利了。");
			// 给回调对象赋值，让乌龟不要再跑了
			if(calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("兔子跑了" + l + "米，距离终点还有" + length + "米");
		if(length % 20 == 0) {
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
