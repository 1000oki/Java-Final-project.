import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Eleventh3 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread pl = new Thread(new ButtonSound());
    Thread pl2 = new Thread(new ButtonSound());
    
    public Eleventh3() {
    	    	   	
        icon = new ImageIcon("play.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n   백만송이와 간이 학교 근처 식당으로 향했다. \n   이미 동기들은 모여서 한창 놀고있던 것 같다.");
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
    			pl.start();
    			l2.setText("\n\n  백만송이 : 다들 오늘 수고 많았어 재미있게 놀다 들어가서 푹 쉬자!!!!");
    		}else {
    			pl2.start();
    			Eleventh3_1 frame = new Eleventh3_1();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    		}
    	}
    }
}
