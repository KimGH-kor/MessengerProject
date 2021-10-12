package server.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class User extends Thread{
	private String uID;
	private String pw;
	private String uName;
	private String uTel;
	Socket socket;
	BufferedReader in = null; // �Է� ��� Ŭ����
	PrintWriter out = null; // ��� ��� Ŭ����
	
	public User(String uID, String pw, String uName, String uTel) {
		this.uID = uID;
		this.pw = pw;
		this.uName = uName;
		this.uTel = uTel;
		
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	//���ú꽺����
	public void run() {
		while(true) {
			try {
				in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				System.out.println("recv");
				String str = in.readLine();
				System.out.println("recv2");
				System.out.println(str);//��ü���� ��������
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public void send(String massege) {
		try {
			out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			out.println(massege);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public Socket getSocket() {
		return socket;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuTel() {
		return uTel;
	}
	public void setuTel(String uTel) {
		this.uTel = uTel;
	}

}
