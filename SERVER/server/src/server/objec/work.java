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

public class work extends Thread {
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
								out.flush();
								if (log != -1) {
									System.out.println("1 " + socket);
									
									User u = UserDAO.list.get(log);
									System.out.println(in);
									u.setSocket(socket);
									UserDAO.hash.put(u.getuID(), u);
									System.out.println("check1");
									ulist();
									System.out.println("check2");
									u.start();
									
								}
							}
							if (ia.equals("2")) {
								String id = in.readLine();
								String pass = in.readLine();
								String name = in.readLine();
								String tel = in.readLine();
								int log = user.regUser(id, pass, name, tel);
								out.println(log);
								out.flush();
								System.out.println("�Ѻ��� ȸ������ �ϼ̽��ϴ�. : " + user.list.size());
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

	// �α��� ������ �α��� �� ����� ����Ʈ ����ֱ�
	public void ulist() throws IOException {
		for (String a : UserDAO.hash.keySet()) {
			in = new BufferedReader(new InputStreamReader(UserDAO.hash.get(a).getSocket().getInputStream()));
			out = new PrintWriter(new OutputStreamWriter(UserDAO.hash.get(a).getSocket().getOutputStream()));
			out.println("3");// rest
			out.println(UserDAO.hash.size());// �������
			for (String b : UserDAO.hash.keySet()) {
				out.println(UserDAO.hash.get(b).getuID());
				out.println(UserDAO.hash.get(b).getuName());
			}
			out.flush();
		}
	}
}