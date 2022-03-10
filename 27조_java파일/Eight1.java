import java.awt.event.*; 
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Eight1 extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("Eight.jpg");
	Font font,font1; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b1;
	int count=0;
	Thread eight = new Thread(new ButtonSound());
	Thread eight2 = new Thread(new ButtonSound());
	
	public Eight1() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };
        
        txt1 = new JTextArea("\n    "+ Second.name.getText() +": 그래도 좀 일찍 도착한 줄 알았는데"
        		+ " 또 자리가 없네..\n    할 수 없지 저기 앞에 앉자");
		txt1.setOpaque(true);
		txt1.setBackground(new Color(217,217,217));
		txt1.setBounds(0,350,700,130);
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		txt1.setFont(font1);
		
		b1 = new JButton("Next");
		b1.setBackground(new Color(217,217,217));
		Font font = new Font("휴먼편지체", Font.BOLD, 22);
		b1.setFont(font);
		b1.setForeground(Color.gray);
		b1.setBorder(null);
		b1.setBounds(700,350, 100, 130);
		
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(txt1);
        getContentPane().add(b1);
        b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			count++;
    		if (count == 1) {
    			eight.start();
    			txt1.setText("\n    교수님: 다들 졸지 마시고 이 부분 잘 보세요. 어쩌구 여기가 이렇게 저쩌구…… ");
    		} else if (count==2) {
    			eight2.start();
    			Ninth frame = new Ninth();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(800, 500);
        		frame.setVisible(true);
        		dispose();
    		}
		}
		
	}

}
