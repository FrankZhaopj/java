package com.zhaopj.java.socket.socket1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyServer extends Thread {

	private ServerSocket ss = null;
	private final int PORT = 9999;
	
	public MyServer() {
		try {
			ss = new ServerSocket(this.PORT);
			ss.setSoTimeout(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			try {
				System.out.println("等待远程连接，端口号为：" + ss.getLocalPort() + "...");
	            Socket s = ss.accept();
	            System.out.println("远程主机地址：" + s.getRemoteSocketAddress());
	            DataInputStream in = new DataInputStream(s.getInputStream());
	            System.out.println(in.readUTF());
	            DataOutputStream out = new DataOutputStream(s.getOutputStream());
	            out.writeUTF("谢谢连接我：" + s.getLocalSocketAddress() + "\nGoodbye!");
	            s.close();
			} catch (SocketTimeoutException e) {
				System.out.println("Socket timed out!");
	            break;
			}catch (Exception e) {
				e.printStackTrace();
	            break;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new MyServer();
		t.start();
	}

}
