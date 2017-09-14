package com.zhaopj.java.thread.thread3;

import com.zhaopj.java.thread.thread3.Animal.Calltoback;

public class LetOneStop implements Calltoback {

	Animal animal;
	
	public LetOneStop(Animal animal) {
		this.animal = animal;
	}
	
	@Override
	public void win() {
		this.animal.stop();
	}

}
