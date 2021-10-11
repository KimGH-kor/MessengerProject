package server.objec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import server.Server;
import server.User.User;
import server.User.UserDAO;

public class work extends Thread{
	BufferedReader in = null; // �Է� ��� Ŭ����
	PrintWriter out = null; // ��� ��� Ŭ����
	UserDAO user = new UserDAO();


	// �α��� �� ȸ������ ��� ������ �޼���
	public void login() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					if (!Server.list.isEmpty()) {
						try {
							Socket socket = Server.list.removeFirst();
							in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
							out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

							String ia = in.readLine();

							if (ia.equals("1")) {
								String id = in.readLine();
								String pass = in.readLine();
								int log = user.logUser(id, pass);
								out.println(log);
								if(log != -1) {
									System.out.println("1"+socket);
									UserDAO.hash.put(UserDAO.list.get(log), socket);
									ulist();
								}
								out.flush();
							}
							if (ia.equals("2")) {
								String id = in.readLine();
								String pass = in.readLine();
								String name = in.readLine();
								String tel = in.readLine();
								int log = user.regUser(id, pass,name,tel);
								out.println(log);
								out.flush();
								System.out.println("�Ѻ��� ȸ������ �ϼ̽��ϴ�. : "+user.list.size());
								socket.close();
								}

							
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		thread.start();
	}
	
	//�α��� ������ �α��� �� ����� ����Ʈ ����ֱ�
	public void ulist() {
		Thread thread = new Thread() {
			public void run() {
					//��ο��� ������ �����ش�.
					for(User a : UserDAO.hash.keySet()) {
						try {
								in = new BufferedReader(new InputStreamReader(UserDAO.hash.get(a).getInputStream()));
								out = new PrintWriter(new OutputStreamWriter(UserDAO.hash.get(a).getOutputStream()));
								out.println("3");//rest
								out.println(UserDAO.hash.size());//�������	
		    					for(User b : UserDAO.hash.keySet()) {
		    						out.println(b.getuID());
			    					out.println(b.getuName());	
		    					}
		    					out.flush();	
						} catch (IOException e) {
							e.printStackTrace();
						}
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		};
		thread.start();
	}
}
