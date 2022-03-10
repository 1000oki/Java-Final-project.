import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Eleventh3_1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread tree1 = new Thread(new ButtonSound());
    
    public Eleventh3_1() {
    	    	   	
        icon = new ImageIcon("nightview.jpeg");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    열심히 놀다 집에 들어가는 길에 올려다보니 저 멀리에 남산타워가 빛나고 있었다.\n    언제봐도 아름다운 야경이었다... ");
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
    	tree1.start();
    	Twelfth frame = new Twelfth();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(800, 500);
    	frame.setVisible(true);
    	dispose();
    		
    	
    }
}
