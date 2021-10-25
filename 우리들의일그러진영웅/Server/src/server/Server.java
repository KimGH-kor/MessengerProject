package server;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import server.User.UserDAO;
import server.objec.work;

public class Server {
	public static LinkedList<Socket> list = new LinkedList<>();
	public static UserDAO user = new UserDAO();
	public static void main(String[] args) {
		ServerSocket serversocket = null; 
		Socket socket = null;
		BufferedReader in = null;		// �Է� ��� Ŭ����
		PrintWriter out = null;		// ��� ��� Ŭ����
		String name;
		work thread;
		
			try {
				System.out.println("������ ���۵Ǿ����ϴ�.");
				thread = new work();
				thread.login();
				serversocket = new ServerSocket(9000);
				while(true) {
					socket = serversocket.accept();
					System.out.println("[�α��� �õ�]"
							+socket.getRemoteSocketAddress() // ���� ������ Ŭ���� ip�ּҿ� ���� �ּ����� ���
							+": "+Thread.currentThread().getName());// �������� ���� ���� ���(������ �̸�)
					list.addLast(socket);
					Thread.sleep(100);
				}
				}catch(Exception e) {//��� �����忡 �־����
					System.out.println(e);
					System.out.println("������ ���� ����.");
					try {
						if(UserDAO.hash.isEmpty()) {
						socket.close();
						serversocket.close();
						}
					}catch (Exception e1) {
						System.out.println(e1);
					}
				}
		}	
	}

