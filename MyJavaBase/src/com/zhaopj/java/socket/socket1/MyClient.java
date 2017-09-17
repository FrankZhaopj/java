package com.zhaopj.java.socket.socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient extends Thread {

	static private final String ADDRESS = "localhost";
	static private final int PORT = 9999;

	public static void main(String[] args) {
		try {
			System.out.println("连接到主机：" + ADDRESS + " ，端口号：" + PORT);
			Socket s = new Socket("localhost", PORT);
			System.out.println("远程主机地址：" + s.getRemoteSocketAddress());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF("Hello from " + s.getLocalSocketAddress());
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			System.out.println("服务器响应： " + in.readUTF());
			s.close();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
