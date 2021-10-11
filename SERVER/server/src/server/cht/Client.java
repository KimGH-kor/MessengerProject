package server.cht;

import java.net.*;

public class Client {
	public static void main(String[] args) {
		Socket socket = null;
		try {
			socket = new Socket("192.168.0.78",9001);
			Thread thread1 = new SenderThread(socket);
			Thread thread2 = new ReceiverThread(socket);
			thread1.start();
			thread2.start();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
