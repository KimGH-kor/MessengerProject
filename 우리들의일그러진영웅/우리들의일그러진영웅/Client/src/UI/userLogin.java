package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class userLogin extends JPanel {
	private JTextField textField;
	private JTextField idFeild;
	private JPasswordField pwField;
	static Socket socket;
	BufferedReader in;
	PrintWriter out;
	static String myName;
	/**
	 * Create the panel.
	 */

	MainFrame frmMain;
	JPanel thispan = this;

	// 정보 넘기기
	public void startClient() throws UnknownHostException, IOException {
		// Create socket connection

	}

	// 화면 구성
	public userLogin(MainFrame frmMain) {
		this.frmMain = frmMain;

		setLayout(null);

		JPanel logoPan = new JPanel();
		logoPan.setLayout(null);
		logoPan.setBounds(0, 0, 380, 237);
		add(logoPan);

		textField = new RoundJTextField(15);
		textField.setText("String");
		textField.setSelectionColor(Color.BLACK);
		textField.setSelectedTextColor(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("굴림", Font.PLAIN, 30));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.RED);
		textField.setBounds(80, 75, 213, 113);
		logoPan.add(textField);

		JPanel regPan = new JPanel();
		regPan.setLayout(null);
		regPan.setBounds(0, 247, 380, 343);
		add(regPan);

		JLabel uId = new JLabel("ID");
		uId.setHorizontalAlignment(SwingConstants.CENTER);
		uId.setFont(new Font("굴림", Font.BOLD, 18));
		uId.setBounds(12, 74, 77, 32);
		regPan.add(uId);

		idFeild = new JTextField();
		uId.setLabelFor(idFeild);
		idFeild.setColumns(10);
		idFeild.setBounds(145, 74, 223, 35);
		regPan.add(idFeild);

		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("굴림", Font.BOLD, 18));
		pw.setBounds(12, 135, 77, 32);
		regPan.add(pw);

		pwField = new JPasswordField();
		pw.setLabelFor(pwField);
		pwField.setBounds(145, 135, 223, 35);
		regPan.add(pwField);

		JButton registPageBtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		registPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain.SetReg(thispan);
			}
		});
		registPageBtn.setForeground(Color.WHITE);
		registPageBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		registPageBtn.setBorder(UIManager.getBorder("TextField.border"));
		registPageBtn.setBackground(Color.RED);
		registPageBtn.setBounds(215, 245, 100, 25);
		regPan.add(registPageBtn);

		// 누르면 클라이언트 시작
		JButton loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("127.0.0.1", 9000);
					out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

					String ia = "1";
					out.println(ia);

					String username = idFeild.getText();
					myName = username;
//							System.out.println(myName);
					out.println(username);

					String password = String.valueOf(pwField.getPassword());
					out.println(password);

					out.flush();

					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String response = in.readLine();
					System.out.println("DB에서 " + response + "번째 유저입니다.");
					if (response.equals("-1")) {
						frmMain.SetLog(thispan);
					} else {
						homeUI.add();
						frmMain.SetHome(thispan);
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					try {
						socket.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("굴림", Font.PLAIN, 15));
		loginBtn.setBorder(UIManager.getBorder("TextField.border"));
		loginBtn.setBackground(Color.RED);
		loginBtn.setBounds(55, 245, 100, 25);
		regPan.add(loginBtn);
		frmMain.getRootPane().setDefaultButton(loginBtn);

	}
}
