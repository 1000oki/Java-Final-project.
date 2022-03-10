import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Eleventh extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l, l2, l3;
	JTextArea l1;
    JButton b, b1, b2;
    Thread ele = new Thread(new ButtonSound());
    Thread ele1 = new Thread(new ButtonSound());
    Thread ele2 = new Thread(new ButtonSound());
    
    
    public Eleventh() {
    	    	   	
        icon = new ImageIcon("prime.jpeg");    
       
        l = new JLabel("오늘은 할만큼 했어 집에 가자 피곤해");
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
		
		l1 = new JTextArea("중간고사 끝난 지 얼마나 됐다고 나태해지지 말자\n도서관으로 간다");
		l1.setOpaque(true);
		l1.setFont(font);
		l1.setBackground(new Color(221, 235, 247));
		
		b1 = new JButton("선택");
		b1.setFont(font1);
		b1.setForeground(Color.white);
		b1.setBackground(new Color(221, 235, 247));
		b1.setBorder(null);
		
		l2 = new JLabel("날도 좋은데 백만송이랑 놀러 가야겠다");
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
                l1.setBounds(255, 143, 400, 50);
                b1.setBounds(660, 159, 70, 30);	 
                l2.setBounds(255, 253, 400, 30);
                b2.setBounds(660, 259, 70, 30);	 
                super.paintComponent(g);
            }
        };      
        
        l3 = new JLabel("    수업은 쏜살같이 지나갔고 선택의 시간이 왔다");
		l3.setOpaque(true);
		l3.setBackground(new Color(217,217,217));
		l3.setBounds(0,350,800,130);
		Font font2 = new Font("휴먼편지체", Font.BOLD, 20);
		l3.setFont(font2);
		
            
        
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l);	
        getContentPane().add(l1);	
        getContentPane().add(l2);	
        getContentPane().add(l3);
        getContentPane().add(b);	b.addActionListener(this);
        getContentPane().add(b1);	b1.addActionListener(this);
        getContentPane().add(b2); b2.addActionListener(this);

    }
    
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == b) {
    		ele.start();
    		Eleventh2 frame = new Eleventh2();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p = Fourth.p + 1;
		System.out.println(Fourth.p);
    	}else if (e.getSource() == b1) {
    		ele1.start();
    		Eleventh1 frame = new Eleventh1();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p = Fourth.p + 3;
    	}else if (e.getSource() == b2) {
    		ele2.start();
    		Eleventh3 frame = new Eleventh3();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p = Fourth.p + 0;
    	}
    }
}
