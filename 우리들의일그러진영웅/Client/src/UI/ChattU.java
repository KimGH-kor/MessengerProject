package UI;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChattU extends JDialog {
   private JPanel contentPanel = new JPanel();
   public JTextField textField;
   public JTextArea textArea;
   private String reciuser;
   JScrollPane scrollPane;

   /**
    * Launch the application.
    */
   
   
   
   public void send() {
		try {
			PrintWriter out = new PrintWriter(new OutputStreamWriter(userLogin.socket.getOutputStream()));
			out.println("MSG");
			out.println(reciuser);
			System.out.println(reciuser);
			out.println(textField.getText());
			textField.setText("");
			out.flush();
			System.out.println("보낸 후");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
   /**
    * Create the dialog.
    */
   public ChattU(JFrame jframe, String title) {
      super(jframe, title, false);
      reciuser = title;
         setResizable(false);

         setModal(false);
         setBounds(500, 100, 396, 629);
         getContentPane().setLayout(null);

         JPanel panel = new JPanel();
         panel.setLayout(null);
         panel.setBounds(0, 0, 380, 510);
         getContentPane().add(panel);

         scrollPane = new JScrollPane(textField);
         scrollPane.setBounds(12, 10, 356, 500);
         panel.add(scrollPane);

         textArea = new JTextArea();
         textArea.setEditable(false);
         scrollPane.setViewportView(textArea);

         JPanel panel_1 = new JPanel();
         panel_1.setLayout(null);
         panel_1.setBounds(0, 520, 380, 70);
         getContentPane().add(panel_1);

         textField = new JTextField();
         textField.setColumns(10);
         textField.setBounds(12, 10, 306, 50);
         panel_1.add(textField);

         JButton btnNewButton = new JButton("\uC804\uC1A1");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	if(textField.getText().equals("")) {
            		System.out.println("내용이 없습니다.");
            	}else {
            		System.out.println("보내기");
                    send();
            	}
            }
         });
         btnNewButton.setMargin(new Insets(0, 0, 0, 0));
         btnNewButton.setBounds(323, 10, 45, 31);
         panel_1.add(btnNewButton);
         btnNewButton.setActionCommand("OK");
         getRootPane().setDefaultButton(btnNewButton);
   }
}