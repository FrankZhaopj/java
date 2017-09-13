package com.zhaopj.java.io.byteStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统IO SocketServer
 * @author Administrator 
 * 字节流服务端
 */
public class IOSocketServer {

	public static void main(String[] args) {
		try {
			// 第一个阻塞点：初始化服务器socket
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("服务端启动了...");
			while (true) {
				// 获取socket客户端 套接字
				Socket socket = ss.accept();
				System.out.println("新客户端连接上来了...");
				// 获取客户端输入流
				InputStream in = socket.getInputStream();
				// 定义缓冲区1K
				byte[] b = new byte[1024];
				while (true) {
					// 第二个阻塞点：读取客户端输入流
					int data = in.read(b);
					// 判断是否读取到数据
					if (data != -1) {
						// 将byte[]转为字符串并进行转码
						String info = new String(b, 0, data, "GBK");
						System.out.println(info);
					} else {
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
