package com.pjt.main;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Insets;

public class chattUI extends JPanel {

	/**
	 * Create the panel.
	 */
	MainFrame frmMain;
	JPanel thispan = this;
	private JTextField textField;
	public chattUI() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 380, 520);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 530, 380, 70);
		add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(12, 10, 306, 50);
		panel_1.add(textField);
		
		JButton btnNewButton = new JButton("\uC804\uC1A1");
		btnNewButton.setMargin(new Insets(0, 0, 0, 0));
		btnNewButton.setBounds(330, 10, 38, 24);
		panel_1.add(btnNewButton);

	}

}
