import java.awt.event.*;  
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HaveLunch extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("Fourth1.png");
	Font font=new Font("휴먼편지체", Font.BOLD, 15),font1,font2; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b;
	JLabel l,l1,l2;
	public int count=0;
	Thread hl = new Thread(new ButtonSound());
	
	public HaveLunch() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
            	g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
            	setOpaque(false);
                super.paintComponent(g);
            }
        };
        font = new Font("휴먼편지체", Font.BOLD, 15);

        txt1 = new JTextArea("\n    "+ Second.name.getText() +" :백만송이!! 너 다음 수업 몇시야? 같이 학식ㄱ?");
		txt1.setOpaque(true);
		txt1.setBackground(new Color(217,217,217));
		txt1.setBounds(0,350,700,130);
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		txt1.setFont(font1);
		
		b = new JButton("Next");
		b.setBackground(new Color(217,217,217));
		font2 = new Font("휴먼편지체", Font.BOLD, 22);
		b.setFont(font2);
		b.setForeground(Color.gray);
		b.setBorder(null);
		b.setBounds(700,350, 100, 130);
		
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(txt1);
        getContentPane().add(b);
        b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		if (e.getSource() == b) {
			hl.start();
			HaveLunch1 frame = new HaveLunch1();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setSize(800, 500);
    		frame.setVisible(true);
    		dispose();
		} 
		
	}

}
