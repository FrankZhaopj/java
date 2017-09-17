package com.zhaopj.java.thread.thread4;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.SliderUI;


public class KFC {

	//食物的种类
	String[] names = {"汉堡","薯条","可乐","鸡肉卷","全家桶"};
	
	//食物的种类
	static final int max = 20;
	
	//
	List<Food> foods = new ArrayList<Food>();
	
	//生产食物
	public void create(int size) {
		synchronized (this) {
			while(foods.size() > max) {
				System.out.println("food enough");
				this.notifyAll();
				try {
					String name = Thread.currentThread().getName();
					this.wait();
					System.out.println("生产者:" + name);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			//create food
			for(int i=0; i<size; i++) {
				System.out.print("开始生产食物 ");
				Food food = new Food(names[(int)(Math.random()*5)]);
				foods.add(food);
				System.out.println(food.getName() +" -- "+ foods.size());
			}
		}
	}
	
	//消费食物
	public void delete(int size) {
		synchronized (this) {
			while(foods.size() < size) {
				System.out.println("not have food");
				this.notifyAll();
				try {
					String name = Thread.currentThread().getName();
					this.wait();
					System.out.println("消费者:" + name);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//delete food
			for(int i=0;i<size;i++) {
				System.out.print("开始消费食物 ");
				Food food = foods.remove(foods.size() - 1);
				System.out.println(food.getName() + foods.size());
			}
		}
	}
	
}
