package tutor;

import javax.swing.*;
import javax.swing.event.*;

public class class01 {         
    
    public static void main(String[] args) {   
        
        JFrame f = new JFrame("메인윈도우");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setSize(200,200);
        f.setVisible(true);
                
        DefaultListModel<String> m = new DefaultListModel<>();
        m.addElement("과자");
        m.addElement("햄버거");
        m.addElement("컵라면");      
        m.addElement("음료수");
        m.addElement("anj");
        
        JList l = new JList(m);     
        f.add(l);
        
        l.addListSelectionListener(new ListSelectionListener() {
            
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {                     
                    
                    System.out.println( l.getSelectedValuesList() );
                }
            }           
        });
    }      
}