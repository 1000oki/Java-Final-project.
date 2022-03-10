import java.awt.event.*; 
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sixth extends JFrame implements ActionListener{
	JButton b1,b2;
	JPanel background;
	JLabel l1;
	ImageIcon backgroundimg;
	Font font,font1; 
	JTextArea txt1,txt2;
	JScrollPane scrollPane;
	public static int fp=0;
	Thread ab1 = new Thread (new ButtonSound()); Thread ab2 = new Thread(new ButtonSound());
	
	public Sixth() {
		
		backgroundimg = new ImageIcon("Fourth1.png");    
		
		l1 = new JLabel("�Ƴ� �ʹ� �����ϱ� ������ ���� ����..");
		l1.setOpaque(true);
		font = new Font("�޸�����ü", Font.BOLD, 20);
		l1.setFont(font);
		l1.setBackground(new Color(255,230, 153));  
		
		font1 = new Font("�޸�����ü", Font.BOLD, 15);
		b1 = new JButton("����");
		b1.setFont(font1);
		b1.setForeground(Color.white);
		b1.setBackground(new Color(255,230, 153));
		b1.setBorder(null);
		
		txt1 = new JTextArea("�ð��� ������ �н� �԰�����\n �鸸���̾�!! ���� ��~!");
		txt1.setOpaque(true);
		txt1.setFont(font);
		txt1.setBackground(new Color(221, 235, 247));
		
		b2 = new JButton("����");
		b2.setFont(font1);
		b2.setForeground(Color.white);
		b2.setBackground(new Color(221, 235, 247));
		b2.setBorder(null);
		
		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg.getImage(), 0, 0, 800, 350, null);
                g.setColor(new Color(255,230, 153));
                g.fillRoundRect(230, 83, 520, 70, 80, 80);
                g.setColor(new Color(221, 235, 247));
                g.fillRoundRect(230, 183, 520, 85, 80, 80);
                setOpaque(false); 
                l1.setBounds(265, 103, 400, 30);
                b1.setBounds(660, 109, 70, 30); 	 
                txt1.setBounds(255, 203, 400, 45);
                b2.setBounds(660, 215, 70, 30);	 
                super.paintComponent(g);
            }
		};
     
        
        txt2 = new JTextArea("\n    "+ Second.name.getText() + " : �� ���������� 12�ó�\n"
        		+ "         ������ 10�� 15���̴ϱ� �� �� ����������? ");
		txt2.setOpaque(true);
		txt2.setBackground(new Color(217,217,217));
		txt2.setBounds(0,350,800,130);
		Font font2 = new Font("�޸�����ü", Font.BOLD, 20);
		txt2.setFont(font2);
		
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l1);	
        getContentPane().add(txt1);	
        getContentPane().add(txt2);
        getContentPane().add(b1);	b1.addActionListener(this);
        getContentPane().add(b2);	b2.addActionListener(this);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			ab1.start();
    		GoLibrary frame = new GoLibrary();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		fp+=1;
    	}else if (e.getSource() == b2) {
    		ab2.start();
    		HaveLunch frame = new HaveLunch();
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
    		Fourth.p+=1;
    	}
	}

}
