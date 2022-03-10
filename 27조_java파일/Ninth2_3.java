import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Ninth2_3 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread you = new Thread(new ButtonSound());
    Thread you1 = new Thread(new ButtonSound());
    
    
    public Ninth2_3() {
    	    	   	
        icon = new ImageIcon("Ninth2-3.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    "+ Second.name.getText() +" : 오랜만에 운동하니까 머리도 맑아진 거 같다~~\n             다음 수업은 프라임관이었나 일단 짐 챙겨서 나가자!");
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
    	if(Sixth.fp == 1) {
    		you.start();
    		Ninth3 frame = new Ninth3();
        	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	frame.setSize(800, 500);
        	frame.setVisible(true);
        	dispose();	
    	}else{
    		you1.start();
			Tenth frame = new Tenth();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 500);
			frame.setVisible(true);
			dispose();
		}
    }
}
