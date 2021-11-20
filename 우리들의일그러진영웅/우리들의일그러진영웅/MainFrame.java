package com.pjt.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Cursor;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	userLogin ul;
	userRegist ur;
	
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		ul = new userLogin(this);
		ur = new userRegist(this);
		SetLog(null);
	}
	
	public void SetLog(JPanel panCurr)	{
		if(panCurr != null) contentPane.remove(panCurr);
		contentPane.add(ul, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();

	}
	
	public void SetReg(JPanel panCurr)	{
		if(panCurr != null) contentPane.remove(panCurr);
		contentPane.add(ur, BorderLayout.CENTER);
		contentPane.revalidate();
		contentPane.repaint();

	}
}
