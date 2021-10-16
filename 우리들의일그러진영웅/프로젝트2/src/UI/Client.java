package UI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Client {
	
	public void recive() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						System.out.println("??????????");
						BufferedReader in = new BufferedReader(new InputStreamReader(userLogin.socket.getInputStream()));
							System.out.println("전송 받음");
							String num = in.readLine();
							if(num.equals("5")) {
								System.out.println("전송 받음2");
								ChattU.textArea.append(in.readLine() + "\n");	
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
		Thread thread = new Thread() {
			public void run() {
				try {
					System.out.println("보내기 전");
					PrintWriter out = new PrintWriter(new OutputStreamWriter(userLogin.socket.getOutputStream()));
					out.println("<" + userLogin.myName + ">" + ChattU.textField.getText());
					ChattU.textField.setText("");
					out.flush();
					System.out.println("보낸 후");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		thread.start();
	}
}
