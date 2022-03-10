import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Fourth extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l, l1, l2, l3;
    JButton b, b1, b2;
    public static int p;
    Thread fourth_1 = new Thread(new ButtonSound());
    Thread fourth_2 = new Thread(new ButtonSound());
    Thread fourth_3 = new Thread(new ButtonSound());
    
    
    public Fourth() {
    	    	   	
        icon = new ImageIcon("back1.png");    
       
        l = new JLabel("택시를 타고 가자!!! 10분이면 가능해");
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
		
		l1 = new JLabel("택시는 좀 오버지 그냥 버스타고 가 금방이야");
		l1.setOpaque(true);
		l1.setFont(font);
		l1.setBackground(new Color(221, 235, 247));
		
		b1 = new JButton("선택");
		b1.setFont(font1);
		b1.setForeground(Color.white);
		b1.setBackground(new Color(221, 235, 247));
		b1.setBorder(null);
		
		l2 = new JLabel("아 몰라 이미 늦은 거 아침 먹고 천천히 가자");
		l2.setOpaque(true);
		l2.setFont(font);
		l2.setBackground(new Color(226, 240, 217));
		
		b2 = new JButton("선택");
		b2.setFont(font1);
		b2.setForeground(Color.white);
		b2.setBackground(new Color(226, 240, 217));
		b2.setBorder(null);
        
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                g.setColor(new Color(255,230, 153));
                g.fillRoundRect(230, 30, 520, 70, 80, 80);
                g.setColor(new Color(221, 235, 247));
                g.fillRoundRect(230, 130, 520, 70, 80, 80);
                g.setColor(new Color(226, 240, 217));
                g.fillRoundRect(230, 230, 520, 70, 80, 80);
                setOpaque(false); 
                l.setBounds(265, 53, 400, 30);
                b.setBounds(660, 59, 70, 30); 	 
                l1.setBounds(255, 153, 400, 30);
                b1.setBounds(660, 159, 70, 30);	 
                l2.setBounds(255, 253, 400, 30);
                b2.setBounds(660, 259, 70, 30);	 
                super.paintComponent(g);
            }
        };      
        
        l3 = new JLabel("    "+ Second.name.getText() + " : 어떡하지?");
		l3.setOpaque(true);
		l3.setBackground(new Color(217,217,217));
		l3.setBounds(0,350,800,130);
		l3.setFont(font);
		
            
        
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l);	
        getContentPane().add(l1);	
        getContentPane().add(l2);	
        getContentPane().add(l3);
        getContentPane().add(b);	b.addActionListener(this);
        getContentPane().add(b1);	b1.addActionListener(this);
        getContentPane().add(b2); 	b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == b) {
    		fourth_1.start();
    		Fourth1 frame = new Fourth1();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		p=p+2;
    	}else if (e.getSource() == b1) {
    		fourth_2.start();
    		Fourth2 frame = new Fourth2();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		p=p+1;
    	}else if (e.getSource() == b2) {
    		fourth_3.start();
    		Fourth3 frame = new Fourth3();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		p=p+0;
    	}
    }
}
