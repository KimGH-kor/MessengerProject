package server.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import server.objec.work;

public class User extends Thread {
	private String uID;
	private String pw;
	private String uName;
	private String uTel;
	Socket socket;
	BufferedReader in = null; // 입력 담당 클래스
	PrintWriter out = null; // 출력 담당 클래스
	work u = new work();

	public User(String uID, String pw, String uName, String uTel) {
		this.uID = uID;
		this.pw = pw;
		this.uName = uName;
		this.uTel = uTel;

	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	// 리시브스레드
	public void recive() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						String ia = in.readLine();
						if (ia.equals("MSG")) {
							System.out.println("전송 받음");
							String reciuser = in.readLine();
							System.out.println(reciuser);
							String str = in.readLine();
							System.out.println(str);// 전체인지 개인인지

							ArrayList<String> ft = new ArrayList<String>();
							ft.add(uID);
							ft.add(reciuser);
							ft.sort(null);

							u.userDAO.setMsg(ft.get(0) + "/" + ft.get(1), uID, str);

							send(str, reciuser);
							System.out.println("전송 완료");
						} 
						else if (ia.equals("6")) {
							out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
							String reciuser = in.readLine();
							ArrayList<String> ft = new ArrayList<String>();
							ft.add(uID);
							ft.add(reciuser);
							ft.sort(null);
							
							ArrayList<messageDTO> arr = work.userDAO.selMsg(ft.get(0) + "/" + ft.get(1));
							out.println("6");
							out.println(reciuser);
							out.println(arr.size());
							if (arr.size() > 0) {
								for (int i = arr.size()-1; i >= 0; i--) {
									out.println(arr.get(i).getFROM_ID() + "/" + arr.get(i).getMSG_TEXT());
								}
							}
							
							out.flush();
						
						}

					} catch (Exception e) {
						System.out.println(e);
						try {
							System.out.println(uID + "유저가 나감");
							UserDAO.hash.remove(uID);
							socket.close();
							System.out.println("u리스트 다시보냄");
							u.ulist();
							break;
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							System.out.println(e1);
						}
					}
				}
			}
		};
		thread.start();

	}

	public void send(String massege, String reciuser) {
		try {
			// 개인
			for (String i : UserDAO.hash.keySet()) {
				out = new PrintWriter(new OutputStreamWriter(UserDAO.hash.get(i).getSocket().getOutputStream()));
				if (i.equals(reciuser)) {
					out.println("5");
					out.println(uID+"/"+"<"+uID+"> "+massege);
					out.flush();
					System.out.println("상대 샌드 메서드 실행 완료");
				} else if (i.equals(uID)) {
					out.println("5");
					out.println(reciuser+"/"+"<"+uID+"> "+massege);
					out.flush();
					System.out.println("자신 샌드 메서드 실행 완료");
				}
			}

		} catch (IOException e) {
			System.out.println(e);
			try {
				System.out.println("전송 실패 소켓 제거");
				UserDAO.hash.remove(this.uID);
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1);
			}
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
