package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class homeUI extends JPanel {
	static DefaultListModel<String> m = new DefaultListModel<>();
	static JLabel myName;
	static JLabel myId;
	static BufferedReader in;
	static String ia;

	// 회원 정보 추가
	public static void add() {
		Thread thread = new Thread() {
			public void run() {
				while (true) {
					try {
						// 유저 정보 받아오기 유저 정보인 2개 이름 아이디를 받아옴 그걸 리스트에 넣어서 꺼냄
						in = new BufferedReader(new InputStreamReader(userLogin.socket.getInputStream()));
						ia = in.readLine();
						if (ia.equals("3")) {
							m.removeAllElements();
							int size = Integer.parseInt(in.readLine());
							for (int i = 0; i < size; i++) {
								String id = in.readLine();
								String name = in.readLine();
								if (id.equals(userLogin.myName)) {
									System.out.println(userLogin.myName);
									myName.setText("이름 : " + name);
									myId.setText("ID : " + userLogin.myName);
								} else {
									System.out.println(id + name);
									m.addElement("이름 : " + name + " ID : " + id);
								}
							}
						} else if (ia.equals("5")) {
							System.out.println("전송 받음2");
							String line = in.readLine();
							System.out.println(line);
							ChattU.textArea.append(line + "\n");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
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

	/**
	 * Create the panel.
	 */
	MainFrame frmMain;
	JPanel thispan = this;

	public homeUI(MainFrame frmMain) {
		this.frmMain = frmMain;
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 380, 129);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("img");
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 81, 81);
		panel.add(lblNewLabel_1);
/////////////////////////////////////////////////////////////////////
		myName = new JLabel();
		myName.setBounds(105, 10, 120, 30);
		panel.add(myName);

		myId = new JLabel();
		myId.setBounds(105, 61, 120, 30);
		panel.add(myId);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 128, 380, 26);
		add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton = new JButton("+");
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 13));
		btnNewButton.setBounds(346, 1, 22, 26);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("\uCE5C\uAD6C\uBAA9\uB85D");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel.setBounds(12, 0, 100, 26);
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 152, 380, 466);
		add(panel_2);
		panel_2.setLayout(null);
		JScrollPane p = new JScrollPane();
		p.setBounds(0, 456, 377, -456);
		panel_2.add(p);

		JList list = new JList(m);

		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					Rectangle r = list.getCellBounds(0, list.getLastVisibleIndex());
					if (r != null && r.contains(evt.getPoint())) {
						int index = list.locationToIndex(evt.getPoint());
						ChattU chat = new ChattU();
						chat.setVisible(true);
						System.out.println("몇번쨰 유저? : " + index);
						String recive[] = list.getSelectedValue().toString().split(": ");
						ChattU.reciuser = recive[2];

					}

				}
			}
		});

		list.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.add(list);
		list.setBounds(10, 10, 358, 436);
	}
}
