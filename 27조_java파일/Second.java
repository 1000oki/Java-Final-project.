import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Second extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
	JLabel l, l2;
	JPanel background, p;
	public static JTextField name;
	JButton b, b2;
	String str;
	Thread ts1 = new Thread(new ButtonSound());
 
    public Second() {
        icon = new ImageIcon("back1.png");
        
       
        JLabel l = new JLabel("이름을 입력하세요:");
		l.setOpaque(true);
		Font font = new Font("휴먼편지체", Font.BOLD, 22);
		l.setFont(font);
		l.setForeground(new Color(255,255,255));
		l.setBackground(new Color(255,230, 153));
		
		name = new JTextField(5);	
		name.setBackground(new Color(255,230, 153));
		name.setFont(font);
		name.setBorder(null);
		
		b= new JButton("입력");
		b.setBackground(Color.WHITE);
		b.setFont(font);
		b.setForeground(Color.gray);
		b.setBorder(null);
        
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                g.setColor(new Color(255,230, 153));
                g.fillRoundRect(120, 130, 550, 80, 50, 50);
                setOpaque(false); 
                l.setBounds(150, 154, 170, 30);
                name.setBounds(330, 154, 100, 30);
                b.setBounds(550,154, 60, 30);
                super.paintComponent(g);
            }
        };
		
		l2 = new JLabel("    "+"엄마 : ___, 넌 학교 안가니?");
		l2.setOpaque(true);
		l2.setBackground(new Color(217,217,217));
		l2.setBounds(0,350,700,130);
		Font font1 = new Font("휴먼편지체", Font.BOLD, 25);
		l2.setFont(font1);
		
		b2 = new JButton("Next");
		b2.setBackground(new Color(217,217,217));
		b2.setFont(font);
		b2.setForeground(Color.gray);
		b2.setBorder(null);
		b2.setBounds(700,350, 100, 130);
		
		background.add(l);
		background.add(name);
		background.add(b);
		b.addActionListener(this);
        scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l2);
        getContentPane().add(b2);
        b2.addActionListener(this);
        
        setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b) {
    	str = name.getText();
    	l2.setText("    "+"엄마 :" + str +", 넌 학교 안가니?");
    	b.setText("수정"); 
    	} else if (e.getSource() == b2) {
    		ts1.start();
			Third frame = new Third();
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800, 500);
	        frame.setVisible(true);
			dispose();
		}
    }
}
