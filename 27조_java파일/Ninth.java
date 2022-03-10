import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Ninth extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l, l1;
    JTextArea l2;
    JButton b, b1;
    Thread check = new Thread(new ButtonSound());
    Thread check1 = new Thread(new ButtonSound());
    
    public Ninth() {
    	    	   	
        icon = new ImageIcon("Ninth.png");    
       
        l = new JLabel("아냐 수업 열심히 듣고 밤에 푹 쉬자");
		l.setOpaque(true);
		Font font = new Font("휴먼편지체", Font.BOLD, 20);
		l.setFont(font);
		l.setBackground(new Color(255,230, 153));
		
		Font font1 = new Font("휴먼편지체", Font.BOLD, 15);
		b = new JButton("선택");
		b.setFont(font1);
		b.setForeground(Color.white);
		b.setBackground(new Color(255,230, 153));
		b.setBorder(null);
		
		l1 = new JLabel("어차피 이대로 있으면 잠들 거야 나가자!");
		l1.setOpaque(true);
		l1.setFont(font);
		l1.setBackground(new Color(221, 235, 247));
		
		b1 = new JButton("선택");
		b1.setFont(font1);
		b1.setForeground(Color.white);
		b1.setBackground(new Color(221, 235, 247));
		b1.setBorder(null);
		
        
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                g.setColor(new Color(255,230, 153));
                g.fillRoundRect(230, 80, 520, 70, 80, 80);
                g.setColor(new Color(221, 235, 247));
                g.fillRoundRect(230, 190, 520, 70, 80, 80);
                setOpaque(false); 
                l.setBounds(265, 103, 400, 30);
                b.setBounds(660, 109, 70, 30); 	 
                l1.setBounds(255, 213, 400, 30);
                b1.setBounds(660, 209, 70, 30);	 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    "+ Second.name.getText() +" : (아 너무 졸리다 지루해 지루해 살짝 나가서 바람 좀 쐬고 올까?\n          강의실에 사람이 많아서 더 졸린 거 같기도 하고)");
		l2.setOpaque(true);
		l2.setBackground(new Color(217,217,217));
		l2.setBounds(0,350,800,130);
		l2.setFont(font);  
        
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l);	
        getContentPane().add(l1);	
        getContentPane().add(l2);		
        getContentPane().add(b);	b.addActionListener(this);
        getContentPane().add(b1);	b1.addActionListener(this);
        
        setSize(800,500);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == b) {
    		check.start();
    		Ninth1 frame = new Ninth1();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p=Fourth.p+1;
    	}else if (e.getSource() == b1) {
    		check1.start();
    		Ninth2 frame = new Ninth2();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p=Fourth.p+0;
    	}
    }
}
