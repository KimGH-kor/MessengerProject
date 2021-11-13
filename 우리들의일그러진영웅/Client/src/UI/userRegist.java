package UI;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class userRegist extends JPanel {
	private JTextField textField;
	private JTextField uIdFeild;
	private JPasswordField uPwField;
	private JPasswordField uPwCheckField;
	private JTextField uNameField;
	private JTextField uTelField;
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	/**
	 * Create the panel.
	 */
	
	MainFrame frmMain;
	JPanel thispan = this;
	
	public userRegist(MainFrame frmMain) {
		this.frmMain = frmMain;
		
		JPanel logoPan = new JPanel();
		logoPan.setLayout(null);
		
		textField = new JTextField();
		textField.setText("\uD68C\uC6D0\uAC00\uC785");
		textField.setSelectionColor(Color.BLACK);
		textField.setSelectedTextColor(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("±¼¸²", Font.PLAIN, 30));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.RED);
		textField.setBounds(99, 49, 174, 68);
		logoPan.add(textField);
		
		JPanel regPan = new JPanel();
		regPan.setLayout(null);
		
		JLabel uId = new JLabel("ID");
		uId.setBounds(23, 60, 77, 15);
		regPan.add(uId);
		
		uIdFeild = new JTextField();
		uId.setLabelFor(uIdFeild);
		uIdFeild.setColumns(10);
		uIdFeild.setBounds(138, 60, 223, 21);
		regPan.add(uIdFeild);
		
		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setBounds(23, 121, 77, 15);
		regPan.add(pw);
		
		uPwField = new JPasswordField();
		pw.setLabelFor(uPwField);
		uPwField.setBounds(138, 121, 223, 21);
		regPan.add(uPwField);
		
		JLabel pwCheck = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwCheck.setBounds(23, 182, 76, 15);
		regPan.add(pwCheck);
		
		uPwCheckField = new JPasswordField();
		pwCheck.setLabelFor(uPwCheckField);
		uPwCheckField.setBounds(137, 182, 223, 21);
		regPan.add(uPwCheckField);
		
		JLabel uName = new JLabel("\uC774\uB984");
		uName.setBounds(22, 241, 77, 15);
		regPan.add(uName);
		
		uNameField = new JTextField();
		uName.setLabelFor(uNameField);
		uNameField.setColumns(10);
		uNameField.setBounds(137, 241, 224, 21);
		regPan.add(uNameField);
		
		JLabel uTel = new JLabel("\uC804\uD654\uBC88\uD638");
		uTel.setBounds(23, 303, 77, 15);
		regPan.add(uTel);
		
		uTelField = new JTextField();
		uTel.setLabelFor(uTelField);
		uTelField.setColumns(10);
		uTelField.setBounds(138, 303, 224, 21);
		regPan.add(uTelField);
		
		JButton loginPageBtn = new JButton("\uCDE8\uC18C");
		loginPageBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmMain.SetLog(thispan);
			}
		});
		loginPageBtn.setForeground(Color.WHITE);
		loginPageBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		loginPageBtn.setBorder(UIManager.getBorder("TextField.border"));
		loginPageBtn.setBackground(Color.RED);
		loginPageBtn.setBounds(222, 376, 100, 25);
		regPan.add(loginPageBtn);
		
		JButton registBtn = new JButton("\uD68C\uC6D0 \uB4F1\uB85D");
		registBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			        socket = new Socket("127.0.0.1", 9000);
			        out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		        
			        String ia = "2";
			        out.println(ia);
			        
			        String userID = uIdFeild.getText();
			        out.println(userID);

			        String password = String.valueOf(uPwField.getPassword()); 
			        out.println(password);
			        
			        String name = uNameField.getText(); 
			        out.println(name);
			        
			        String tel = uTelField.getText(); 
			        out.println(tel);
			        
			        out.flush();
			        
			        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			        String response = in.readLine();
			        System.out.println(response);
			        if(response.equals("1")) {
				        frmMain.SetLog(thispan);
			        }
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					try {
						socket.close();
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} 
			}
		});
		registBtn.setForeground(Color.WHITE);
		registBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		registBtn.setBorder(UIManager.getBorder("TextField.border"));
		registBtn.setBackground(Color.RED);
		registBtn.setBounds(62, 376, 100, 25);
		regPan.add(registBtn);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(logoPan, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
				.addComponent(regPan, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(logoPan, GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(regPan, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
					.addGap(12))
		);
		setLayout(groupLayout);

	}
}
