package com.zhaopj.java.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import javafx.beans.property.SetProperty;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException {
		StringBuffer sf = new StringBuffer("select ");
		//反射类对象
		Class<?> c = Class.forName("com.zhaopj.java.annotation.UserEntity");
		//获取类所有注解
		Annotation[] annotations = c.getAnnotations();
		for(Annotation a : annotations) {
			System.out.println(a.toString());
		}
		//获取表名注解对象
		CreateTable ct = c.getAnnotation(CreateTable.class);
		//获取注解值也就是表名
		String tableName = ct.value();
		String colName = "";
		//获取类的所有属性
		Field[] f = c.getDeclaredFields();
		//遍历所有属性
		for (int i = 0; i < f.length; i++) {
			//获取属性的所有注解
			Annotation[] annotations2 = f[i].getAnnotations();
			//遍历注解
			for(Annotation ann : annotations2) {
				//判断是不是要处理的注解
				if(ann.annotationType().equals(Class.forName("com.zhaopj.java.annotation.CreateProperty"))) {
					System.out.println(ann.toString());
					CreateProperty annotation = (CreateProperty)f[i].getAnnotation(ann.annotationType());
					//获取name
					colName = annotation.name();
				}
			}
			sf.append(colName);
			if(i == f.length - 1) {
				sf.append(" from ");
			}else {
				sf.append(", ");
			}
		}
		sf.append(tableName);
		System.out.println(sf.toString());
	}

}
