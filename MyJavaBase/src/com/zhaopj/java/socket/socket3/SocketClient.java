package com.zhaopj.java.socket.socket3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {

	public static final String ADDRESS = "localhost";
	public static final int PORT = 11113;
	
	public static void main(String[] args) {
		System.out.println("client start ... \n");
		System.out.println("if send \"EXIT\" then quit ... \n");
		
		while(true) {
			Socket socket = null;
			try {
				socket = new Socket(ADDRESS, PORT);
				DataInputStream input = new DataInputStream(socket.getInputStream());
				DataOutputStream output = new DataOutputStream(socket.getOutputStream());

				//send message to server
				System.out.println("please write message : \t");
				String clientMessage = new BufferedReader(new InputStreamReader(System.in)).readLine();
				output.writeUTF(clientMessage);
				
				//get message from server
				String serverMessage = input.readUTF();
				System.out.println("server message : " + serverMessage);
				if("EXIT".equalsIgnoreCase(serverMessage)) {
					System.out.println("client will shutdown ... ");
					Thread.sleep(1000);
					break;
				}
				//
				input.close();
				output.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				if (socket != null) {
					try {
						socket.close();
					} catch (IOException e) {
						socket = null;
						System.out.println("客户端 finally 异常:" + e.getMessage());
					}
				}
			}
		}
	}

}