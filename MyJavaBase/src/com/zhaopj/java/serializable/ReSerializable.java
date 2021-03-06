package com.zhaopj.java.serializable;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 反序列化
 * 	下面程序实例了反序列化，将user.ser 存储的 User 对象反序列化为对象。
 */
public class ReSerializable {

	public static void main(String[] args) {
		User u = null;
	      try
	      {
	         FileInputStream fileIn = new FileInputStream("d:/user.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         u = (User) in.readObject();
	         in.close();
	         fileIn.close();
	      }catch(IOException i)
	      {
	         i.printStackTrace();
	         return;
	      }catch(ClassNotFoundException c)
	      {
	         System.out.println("Employee class not found");
	         c.printStackTrace();
	         return;
	      }
	      u.show();
//	      System.out.println("Deserialized Employee...");
//	      System.out.println("Name: " + e.name);
//	      System.out.println("Address: " + e.address);
//	      System.out.println("SSN: " + e.SSN);
//	      System.out.println("Number: " + e.number);
//		System.out.printf("Serialized data is saved in /user.ser");
	}

}
