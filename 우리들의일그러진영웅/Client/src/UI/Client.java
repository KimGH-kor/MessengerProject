package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {
	
	public Client() {
		recive();
	}
	
	public void recive() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						BufferedReader in = homeUI.in;
							if(homeUI.ia.equals("5")) {
								System.out.println("전송 받음2");
								String line = in.readLine();
								System.out.println(line);
								ChattU.textArea.append(line + "\n");	
							}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		};
		thread.start();
	}

	public static void send() {
				try {
					PrintWriter out = new PrintWriter(new OutputStreamWriter(userLogin.socket.getOutputStream()));
					out.println(ChattU.reciuser);
					out.println("<" + userLogin.myName + ">" + ChattU.textField.getText());
					ChattU.textField.setText("");
					out.flush();
					System.out.println("보낸 후");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
}
