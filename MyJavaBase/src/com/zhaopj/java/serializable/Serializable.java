package com.zhaopj.java.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
