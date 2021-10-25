package UI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChattU extends JDialog {
	private final JPanel contentPanel = new JPanel();
	public static JTextField textField;
	static JTextArea textArea;
	static String reciuser;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ChattU dialog = new ChattU(MainFrame.frame,ChattU.reciuser);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ChattU(JFrame jframe, String title) {
		super(jframe,title);
		setTitle(reciuser+"과의 채팅방입니다.");
		setBounds(500, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 222, 436, 31);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				textField = new JTextField();
				textField.setBounds(12, 6, 359, 21);
				buttonPane.add(textField);
				textField.setColumns(10);
			}
			JPanel panel = new JPanel();
			panel.setBounds(12, 10, 412, 202);
			contentPanel.add(panel);
			panel.setLayout(null);

			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setBounds(0, 0, 412, 202);
			panel.add(textArea);
			{
				JButton okButton = new JButton("\uC804\uC1A1");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("보내기");
						Client.send();
					}
				});
				okButton.setBounds(376, 5, 55, 23);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}