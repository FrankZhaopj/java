package com.zhaopj.java.io.byteStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 传统IO SocketClinet
 * @author Administrator
 * 字节流客户端
 */
public class IOSocketClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888);
			OutputStream out = socket.getOutputStream();
			System.out.print("请输入: \t");
			InputStream in = System.in;
			byte[] b = new byte[1024];
			while (true) {
				int data = in.read(b);
				if (data != -1) {
					out.write(b);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
