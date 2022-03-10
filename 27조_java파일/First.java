import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.IOException;

public class First extends JFrame implements ActionListener{
	JButton b1, b2;
	JLabel l, l2;
	JPanel p;
	Thread first1 = new Thread(new ButtonSound());
	Thread first2 = new Thread(new ButtonSound());
	Thread first = new Thread(new BackgroundMusic());
	public static int cou;
	public First(int i) {		
		cou = i;
		if(cou ==1 ) {
			first.start();
		}
		setSize(800,500);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null); 
		getContentPane().setBackground(new Color(0x9DBAE1));

		p = new JPanel();
		l = new JLabel("눈송이의 하루");
		Font font = new Font("휴먼편지체", Font.BOLD, 35);
		Color c = new Color(0x4472c4);
		l.setFont(font);
		l.setForeground(c);
		
		l.setBounds(380, 180, 200, 60);
		getContentPane().add(l);
		
		l2 = new JLabel();
		ImageIcon icon = new ImageIcon("song.png");
		l2.setIcon(icon);
		l2.setBounds(220, 130, 119, 160);
		getContentPane().add(l2);
		
		
		b1 = new JButton("시간표");
		b2 = new JButton("시작하기");
		
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		Color c1 = Color.WHITE;
		b1.setFont(font1);
		b1.setForeground(c1);
		b2.setFont(font1);
		b2.setForeground(c1);
		
		
		EmptyBorder t1 = new EmptyBorder(5,3,5,3);
		b1.setBorder(t1);
		EmptyBorder t2 = new EmptyBorder(5,3,5,3);
		b2.setBorder(t2);
		
		b1.setBounds(250, 320, 110, 30);
		b2.setBounds(450, 320, 110, 30);
		
		
		b1.setBackground(new Color(0x4472c4));
		b2.setBackground(new Color(0x4472c4));
		
			
		getContentPane().add(b1);
		b1.addActionListener(this);
		getContentPane().add(b2);
		b2.addActionListener(this);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			first1.start();
			Search frame = new Search();
			dispose();
		}else if (e.getSource() == b2) {
			first2.start();
			Second frame1 = new Second();
			dispose();
		}
	}
}
