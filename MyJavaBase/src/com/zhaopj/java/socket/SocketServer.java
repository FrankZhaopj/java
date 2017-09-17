package com.zhaopj.java.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	public static final int PORT = 11113;
	
	public static void main(String[] args) {
		System.out.println("server start ... \n");
		SocketServer ss = new SocketServer();
		ss.init();
	}
	
	@SuppressWarnings("resource")
	public void init() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				Socket client = serverSocket.accept();
				new HandleThread(client);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private class HandleThread implements Runnable{

		private Socket socket;
		
		public HandleThread(Socket socket) {
			socket = socket;
			new Thread(this).start();
		}
		
		public void run() {
			try {
				//send message to client
				DataInputStream input = new DataInputStream(socket.getInputStream());
				String clientMessage = input.readUTF();
				System.out.println("client message : " + clientMessage);
				
				//get message from client
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());
				System.out.println("please write message : \t");
				String serverMessage = new BufferedReader(new InputStreamReader(System.in)).readLine();
				output.writeUTF(serverMessage);
				//release resource
				output.close();
				input.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						socket = null;
						System.out.println("服务端 finally 异常:" + e.getMessage());
					}
				}
			}
		}
	}
	
}
