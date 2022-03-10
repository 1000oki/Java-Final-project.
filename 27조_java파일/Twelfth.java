import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Twelfth extends JFrame implements ActionListener{
	JButton b1;
	JLabel l;
	JPanel panel;
	Thread st = new Thread(new ButtonSound());
	Thread st1 = new Thread(new ButtonSound());
	Thread st2 = new Thread(new ButtonSound());
	Thread st3 = new Thread(new ButtonSound());
	
	public Twelfth() {		
		setSize(800,500);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
		getContentPane().setBackground(new Color(0x9DBAE1));

		panel = new JPanel();
		l = new JLabel("기말고사가 끝나고 시험 결과가 나왔다.");
		Font font = new Font("휴먼편지체", Font.BOLD, 20);
		Color c = new Color(255,255,255);
		l.setFont(font);
		l.setForeground(c);
		
		l.setBounds(200, 180, 400, 60);
		getContentPane().add(l);
		
		
		b1 = new JButton("Next");
	
		
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		Color c1 = Color.WHITE;
		b1.setFont(font1);
		b1.setForeground(c1);
		
		
		EmptyBorder t1 = new EmptyBorder(5,3,5,3);
		b1.setBorder(t1);
		
		b1.setBounds(700,350, 100, 130);
		
		
		b1.setBackground(new Color(0x4472c4));
		
			
		getContentPane().add(b1);
		b1.addActionListener(this);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if (Fourth.p >= 7) {
				st.start();
    			Twelfth1 frame = new Twelfth1();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    			
    		}else if (Fourth.p<=6 && Fourth.p>=5) {
    			st1.start();
    			Twelfth2 frame = new Twelfth2();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    			
    		}else if (Fourth.p<=4 && Fourth.p>=3) {
    			st2.start();
    			Twelfth3 frame = new Twelfth3();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    		
    		}else if (Fourth.p<= 2) {
    			st3.start();
    			Twelfth4 frame = new Twelfth4();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
		}	
		
	}
}
