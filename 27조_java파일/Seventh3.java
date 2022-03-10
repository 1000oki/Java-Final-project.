import java.awt.event.*;  
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Seventh3 extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("Seventh3.jpg");
	Font font,font1; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b1;
	int count=0;
	Thread ph = new Thread(new ButtonSound());
	
	public Seventh3() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };
        
        txt1 = new JTextArea("\n    (수업을 듣다 창 밖을 보니 맑은 하늘이 보였다 )\n");
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
    			ph.start();
    			Seventh4 frame = new Seventh4();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(800, 500);
        		frame.setVisible(true);
        		dispose();
    		}
		}
		
	}

}
