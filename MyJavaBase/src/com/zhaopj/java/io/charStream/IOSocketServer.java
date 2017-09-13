package com.zhaopj.java.io.charStream;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 传统IO SocketServer
 * @author Administrator
 * 字符流服务端
 */
public class IOSocketServer {

	public static void main(String[] args) {
		try {
			//第一个阻塞点：初始化服务器socket
			ServerSocket ss = new ServerSocket(8888);
			System.out.println("服务端启动了...");
			while(true) {
				//获取socket客户端 套接字
				Socket socket = ss.accept();
				System.out.println("新客户端连接上来了...");
				//获取客户端输入流
				InputStreamReader in = new InputStreamReader(socket.getInputStream());
				char[] c = new char[1024];
				//读取输入流数据
				int data = in.read(c);
				if(data != -1) {
					// 将char[]转为字符串并进行转码
					String info = new String(c);
					System.out.println(info);
				}else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
