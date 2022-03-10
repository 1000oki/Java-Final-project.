import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Ninth3_1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread you6 = new Thread(new ButtonSound());
    Thread you7 = new Thread(new ButtonSound());
    
    public Ninth3_1() {
    	    	   	
        icon = new ImageIcon("Ninth3_1.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    나는 힘없는 발걸음으로 집으로 향했고 엄청난 잔소리를 들었다...\n    다음부터는 점심은 꼭 챙겨 먹어야지 다짐을 하고 잠에 들었다.");
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
    			you6.start();
    			l2.setText("\n\n    기말고사에서 나의 성적은 바닥을 쳤고, 학사경고를 받았다.");
    		} else {
    			you7.start();
    			Ninth3_2 frame = new Ninth3_2();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    		}
    	}
    }
}
