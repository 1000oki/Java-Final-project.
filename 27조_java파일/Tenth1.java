import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Tenth1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread ten2 = new Thread(new ButtonSound()); Thread ten3 = new Thread(new ButtonSound());
    Thread ten4= new Thread(new ButtonSound()); Thread ten5 = new Thread(new ButtonSound());
    Thread ten6 = new Thread(new ButtonSound()); Thread ten7 = new Thread(new ButtonSound());
    
    public Tenth1() {
    	    	   	
        icon = new ImageIcon("Tenth1.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    "+ Second.name.getText() +" : 역시 여기 강의실이 제일 깔끔한 거 같아\n            일찍 왔더니 자리도 많네 유후~");
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
    			ten2.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : 어 백만송이다! 백만송이야 수업 잘 듣고 왔어?");
    		}else if (count == 2) {
    			ten3.start();
    			l2.setText("\n\n    백만송이 : 그럼 그럼 잘 졸다가 왔지. 그래서 저녁에 놀러가는 거 생각해 봤어?");
    		}else if (count == 3) {
    			ten4.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : 아 아직... 이번 수업 끝나기 전에 꼭 말해줄게 진짜로ㅎㅎ");
    		}else if (count == 4) {
    			ten5.start();
    			l2.setText("\n\n    백만송이 : 어휴 알았어 빨리 정해줘 알겠지?");
    		}else if (count == 5) {
    			ten6.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : 오케이 오케이 오 교수님 오셨다. 얼른 앉아");
    		}else{
    			ten7.start();
				Eleventh frame = new Eleventh();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
			}
    	}
    }
}
