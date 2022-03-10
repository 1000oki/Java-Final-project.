import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Third extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l2;
    JButton b2;
    Thread third = new Thread(new ButtonSound());
    
    
    public Third() {
    	    	   	
        icon = new ImageIcon("back1.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };      
        
        l2 = new JLabel("    "+ Second.name.getText() +" : 헉 오늘 9시 수업인데 안 돼!!!!!");
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
		b2.addActionListener(this);
            
        
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l2);
        getContentPane().add(b2);
    }
    
    public void actionPerformed(ActionEvent e) {
    		third.start();
    		Fourth frame = new Fourth();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 500);
	        frame.setVisible(true);
			dispose();
	}   
}
