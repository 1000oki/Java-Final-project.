import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Fourth2_1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l2;
    JButton b2;
    int count = 0;
    Thread t1 = new Thread(new ButtonSound()); Thread t2 = new Thread(new ButtonSound());
    Thread t3 = new Thread(new ButtonSound()); Thread t4 = new Thread(new ButtonSound());
    Thread t5 = new Thread(new ButtonSound()); Thread t6 = new Thread(new ButtonSound());
    
    public Fourth2_1() {
    	    	   	
        icon = new ImageIcon("Fourth2.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JLabel("    교수님이 출석을 부르고 계신다.");
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
    	if (e.getSource() == b2) {
    		count++;
    		if (count == 1) {
    			t1.start();
    			l2.setText("    교수님 : "+Second.name.getText()+"학생 ...");
    		}else if (count == 2) {
    			t2.start();
    			l2.setText("    교수님 : "+Second.name.getText()+"학생 안 왔나요?");
    		}else if (count == 3) {
    			t3.start();
    			l2.setText("    "+Second.name.getText()+" : 헉 헉 교수님 저 왔어요!");
    		}else if (count == 4) {
    			t4.start();
    			l2.setText("    교수님 : 다음부터는 일찍 다니세요.");
    		}else if (count == 5) {
    			t5.start();
    			l2.setText("    "+Second.name.getText()+" : 네... 죄송합니다...");
    		}else {
    			t6.start();
    			Fifth frame = new Fifth();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
    		}
    	}
    }
}
