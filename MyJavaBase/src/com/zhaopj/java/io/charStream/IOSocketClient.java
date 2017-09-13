package com.zhaopj.java.io.charStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 传统IO SocketClinet
 * @author Administrator
 * 字符流客户端
 */
public class IOSocketClient {

	public static void main(String[] args) {
		try {
			while(true) {
				//连接服务器
				Socket socket = new Socket("localhost", 8888);
				//获取输出流
				OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream());
				System.out.print("请输入: \t");    
	            String str = new BufferedReader(new InputStreamReader(System.in)).readLine();    
	            out.write(str);
	            out.flush();
	            out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
