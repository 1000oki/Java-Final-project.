import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Ninth3 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread you3 = new Thread(new ButtonSound());
    Thread you4 = new Thread(new ButtonSound());
    
    public Ninth3() {
    	    	   	
        icon = new ImageIcon("Fourth1.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    "+ Second.name.getText() +" : 아 아까 점심을 안먹어서 배가 너무 고프다..\n             수업 하나 더 있긴 한데 어쩌지");
		l2.setOpaque(true);
		l2.setBackground(new Color(217,217,217));
		l2.setBounds(0,350,700,130);
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		l2.setFont(font1);
		
		b2 = new JButton("Next");
		b2.setBackground(new Color(217,217,217));
		Font font = new Font("휴먼편지체", Font.BOLD, 22);
		b2.setFont(font);
		b2.setForeground(Color.gray);
		b2.setBorder(null);
		b2.setBounds(700,350, 100, 130);
		
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l2);
        getContentPane().add(b2);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) { 
    	if (e.getSource() == b2) {
    		count++;
    		if (count == 1) {
    			you3.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : 어지러운거 같기도 하고 안되겠다... 이러다 나 죽겠어 집에 가자");
    		} else {
    			you4.start();
    			Ninth3_1 frame = new Ninth3_1();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    		}
    	}
    }
}
