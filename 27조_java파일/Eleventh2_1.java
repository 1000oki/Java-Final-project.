import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Eleventh2_1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JButton b2;
    int count = 0;
    Thread tree = new Thread(new ButtonSound());
    
    public Eleventh2_1() {
    	    	   	
        icon = new ImageIcon("flower.jpeg");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
		
	b2 = new JButton("Next");
	b2.setBackground(new Color(217,217,217));
	Font font = new Font("»ﬁ∏’∆Ì¡ˆ√º", Font.BOLD, 22);
	b2.setFont(font);
	b2.setForeground(Color.gray);
	b2.setBorder(null);
	b2.setBounds(700,350, 100, 130);
		
            
        
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);   
        getContentPane().add(b2);
        b2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) { 
    	tree.start();
    	Twelfth frame = new Twelfth();
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(800, 500);
    	frame.setVisible(true);
    	dispose();
    	
    	
    }
}
