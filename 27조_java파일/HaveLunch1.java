import java.awt.event.*;  
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HaveLunch1 extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("Fourth1.png");
	Font font=new Font("�޸�����ü", Font.BOLD, 15),font1,font2; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b,b1,b2,b3;
	JLabel l,l1,l2;
	public int count=0;
	Thread hl2 = new Thread(new ButtonSound()); Thread hl3 = new Thread(new ButtonSound());
	Thread hl4 = new Thread(new ButtonSound());
	
	public HaveLunch1() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
            	g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                g.setColor(new Color(255,230, 153));
                g.fillRoundRect(230, 30, 520, 70, 80, 80);
                g.setColor(new Color(221, 235, 247));
                g.fillRoundRect(230, 130, 520, 70, 80, 80);
                g.setColor(new Color(226, 240, 217));
                g.fillRoundRect(230, 230, 520, 70, 80, 80);
                setOpaque(false); 
                l.setBounds(265, 53, 400, 30);
                b1.setBounds(660, 59, 70, 30); 	 
                l1.setBounds(255, 153, 400, 30);
                b2.setBounds(660, 159, 70, 30);	 
                l2.setBounds(255, 253, 400, 30);
                b3.setBounds(660, 259, 70, 30);	 
                super.paintComponent(g);
            }
        };
        font = new Font("�޸�����ü", Font.BOLD, 15);

        txt1 = new JTextArea("\n    "+ "�鸸����: �� �ʶ� ���� ���� ��µ�? �н� ���� ��� ������?");
		txt1.setOpaque(true);
		txt1.setBackground(new Color(217,217,217));
		txt1.setBounds(0,350,700,130);
		Font font1 = new Font("�޸�����ü", Font.BOLD, 20);
		txt1.setFont(font1);
		
		b = new JButton("Next");
		b.setBackground(new Color(217,217,217));
		font2 = new Font("�޸�����ü", Font.BOLD, 22);
		b.setFont(font2);
		b.setForeground(Color.gray);
		b.setBorder(null);
		b.setBounds(700,350, 100, 130);
		
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(txt1);
        getContentPane().add(b);
        b.addActionListener(this);
        
        l = new JLabel("����� ��Ű� ���Ϸ� ���� ����");
        l.setOpaque(true);
		l.setFont(font1);
		l.setBackground(new Color(255,230, 153));  
        b1 = new JButton("����");
        b1.setFont(font);
        b1.setForeground(Color.white);
		b1.setBackground(new Color(255,230, 153));
		b1.setBorder(null);
        
		l1 = new JLabel("���� ���� ������ �Ĵ��� �?\r\n");
		l1.setOpaque(true);
		l1.setFont(font1);
		l1.setBackground(new Color(221, 235, 247));  
		b2 = new JButton("����");
		b2.setFont(font);
		b2.setForeground(Color.white);
		b2.setBackground(new Color(221, 235, 247));
		b2.setBorder(null);
		
		l2 = new JLabel("������ 5�� ���� �� �ѹ��� �� ���þ�!!!!\r\n");
		l2.setOpaque(true);
		l2.setFont(font1);
		l2.setBackground(new Color(226, 240, 217));  
		b3 = new JButton("����");
		b3.setFont(font);
		b3.setForeground(Color.white);
		b3.setBackground(new Color(226, 240, 217));
		b3.setBorder(null);
		
		
		getContentPane().add(l);	
		getContentPane().add(l1);	
		getContentPane().add(l2);	
		getContentPane().add(b1);	b1.addActionListener(this);
		getContentPane().add(b2);	b2.addActionListener(this);
		getContentPane().add(b3); 	b3.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		if (e.getSource() == b1) {
			hl2.start();
			Sixth3_1 frame = new Sixth3_1();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
		} else if (e.getSource() == b2) {
			hl3.start();
			Sixth3_2 frame = new Sixth3_2();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
		} else if (e.getSource() == b3) {
			hl4.start();
			Sixth3_3 frame = new Sixth3_3();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
		}
		
	}

}
