package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import server.objec.work;

public class Server {
	public static LinkedList<Socket> list = new LinkedList<>();
	public static void main(String[] args) {
		ServerSocket serversocket = null; 
		Socket socket = null;
		BufferedReader in = null;		// �Է� ��� Ŭ����
		PrintWriter out = null;		// ��� ��� Ŭ����
		String name;
		work thread;

		
		System.out.println("������ ���۵Ǿ����ϴ�.");
		thread = new work();
		thread.login();
			try {
				serversocket = new ServerSocket(9000);
				while(true) {
					socket = serversocket.accept();
					System.out.println("[�α��� �õ�]"
							+socket.getRemoteSocketAddress() // ���� ������ Ŭ���� ip�ּҿ� ���� �ּ����� ���
							+": "+Thread.currentThread().getName());// �������� ���� ���� ���(������ �̸�)
					list.addLast(socket);
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
		}	
	}

