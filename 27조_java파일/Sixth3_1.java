import java.awt.event.*;  
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sixth3_1 extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("misochan.png");
	Font font,font1; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b1;
	int count=0;
	Thread ad = new Thread(new ButtonSound());
	
	public Sixth3_1() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };
        
        txt1 = new JTextArea("\n    "+ Second.name.getText() +" : ³È³È À½ ¿ª½Ã ÇÐ½Ä ´ëÁ¸¸À");
		txt1.setOpaque(true);
		txt1.setBackground(new Color(217,217,217));
		txt1.setBounds(0,350,700,130);
		Font font1 = new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.BOLD, 20);
		txt1.setFont(font1);
		
		b1 = new JButton("Next");
		b1.setBackground(new Color(217,217,217));
		Font font = new Font("ÈÞ¸ÕÆíÁöÃ¼", Font.BOLD, 22);
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
    			ad.start();
    			Sixth3_4 frame = new Sixth3_4();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(800, 500);
        		frame.setVisible(true);
        		dispose();
    		} 
		}
		
	}

}
