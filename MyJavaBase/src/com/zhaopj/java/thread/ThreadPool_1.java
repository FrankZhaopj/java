package com.zhaopj.java.thread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 传统IO SocketServer
 * 该服务为单线程，一次只能有一个客户端连接
 * 通过线程池实现多线程，可以同时连接多个客户端
 */
public class ThreadPool_1 {

	public static void main(String[] args) throws Exception {
		// 创建线程池
		ExecutorService threadPool = Executors.newCachedThreadPool();
		// 创建服务端
		ServerSocket serverSocket = new ServerSocket(8888);
		System.out.println("服务端启动了...");
		while (true) {
			// 第一个阻塞点：初始化服务器socket
			// 获取socket客户端 套接字
			Socket socket = serverSocket.accept();
			//创建线程
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println("新客户端连接上来了...");
					try {
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
					} catch (IOException e) {
						// TODO: handle exception
					}
				}
			});
		}
	}
}
