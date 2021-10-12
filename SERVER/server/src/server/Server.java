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
		BufferedReader in = null;		// 입력 담당 클래스
		PrintWriter out = null;		// 출력 담당 클래스
		String name;
		work thread;

		
		System.out.println("서버가 시작되었습니다.");
		thread = new work();
		thread.login();
			try {
				serversocket = new ServerSocket(9000);
				while(true) {
					socket = serversocket.accept();
					System.out.println("[로그인 시도]"
							+socket.getRemoteSocketAddress() // 현재 접속한 클라의 ip주소와 같은 주소정보 출력
							+": "+Thread.currentThread().getName());// 스레드의 고유 정보 출력(스레드 이름)
					list.addLast(socket);
				}
				}catch(Exception e) {
					e.printStackTrace();
				}
		}	
	}

