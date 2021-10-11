package com.pjt.main;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userLogin extends JPanel {
	private JTextField textField;
	private JTextField idFeild;
	private JPasswordField pwField;

	/**
	 * Create the panel.
	 */
	
	MainFrame frmMain;
	JPanel thispan = this;
	
	public userLogin(MainFrame frmMain) {
		this.frmMain = frmMain;
		
		setLayout(null);
		
		JPanel logoPan = new JPanel();
		logoPan.setLayout(null);
		logoPan.setBounds(0, 0, 380, 237);
		add(logoPan);
		
		textField = new JTextField();
		textField.setText("String");
		textField.setSelectionColor(Color.BLACK);
		textField.setSelectedTextColor(Color.WHITE);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("±¼¸²", Font.PLAIN, 30));
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
		uId.setFont(new Font("±¼¸²", Font.BOLD, 18));
		uId.setBounds(12, 74, 77, 32);
		regPan.add(uId);
		
		idFeild = new JTextField();
		uId.setLabelFor(idFeild);
		idFeild.setColumns(10);
		idFeild.setBounds(145, 74, 223, 35);
		regPan.add(idFeild);
		
		JLabel pw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("±¼¸²", Font.BOLD, 18));
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
		registPageBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		registPageBtn.setBorder(UIManager.getBorder("TextField.border"));
		registPageBtn.setBackground(Color.RED);
		registPageBtn.setBounds(215, 245, 100, 25);
		regPan.add(registPageBtn);
		
		JButton loginBtn = new JButton("\uB85C\uADF8\uC778");
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setFont(new Font("±¼¸²", Font.PLAIN, 15));
		loginBtn.setBorder(UIManager.getBorder("TextField.border"));
		loginBtn.setBackground(Color.RED);
		loginBtn.setBounds(55, 245, 100, 25);
		regPan.add(loginBtn);

	}

}
