package com.zhaopj.java.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 * 	ObjectOutputStream 类用来序列化一个对象
 * 	如下实例化了一个 User 对象，并将该对象序列化到一个文件中。
 * 	该程序执行后，就创建了一个名为 user.ser 文件。
 */
public class Serializable {

	public static void main(String[] args) {
		User u = new User("zhaopj", "123456", 29);
		FileOutputStream fileOut = null;
		try {
			fileOut = new FileOutputStream("d:/user.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(u);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileOut.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("Serialized data is saved in /user.ser");
	}

}
