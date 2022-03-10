import java.awt.event.*; 
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class GoLibrary extends JFrame implements ActionListener{
	JPanel background;
	JLabel l1;
	ImageIcon backgroundimg1= new ImageIcon("Fourth1.png");
	Font font,font1; 
	JTextArea txt1,txt2;
	JScrollPane scrollPane;
	JButton b1;
	public int count=0;
	Thread bc = new Thread(new ButtonSound()); Thread bc1 = new Thread(new ButtonSound());
	
	public GoLibrary() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };
        
        l1 = new JLabel("    "+ Second.name.getText() +" : 너무 졸리니까 밥은 됐고.."
        		+ " 도서관 가서 잠이나 자자");
		l1.setOpaque(true);
		l1.setBackground(new Color(217,217,217));
		l1.setBounds(0,350,700,130);
		Font font1 = new Font("휴먼편지체", Font.BOLD, 20);
		l1.setFont(font1);
		
		b1 = new JButton("Next");
		b1.setBackground(new Color(217,217,217));
		Font font = new Font("휴먼편지체", Font.BOLD, 22);
		b1.setFont(font);
		b1.setForeground(Color.gray);
		b1.setBorder(null);
		b1.setBounds(700,350, 100, 130);
		
		scrollPane = new JScrollPane(background);
        setContentPane(scrollPane);
        getContentPane().add(l1);
        getContentPane().add(b1);
        b1.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			count++;
    		if (count == 1) {
    			bc.start();
    			l1.setText("    "+ Second.name.getText() +": 날씨가 좋으니까 더 졸리다… "
    					+ "(도서관이 생각보다 멀게 느껴진다)");
    		}else if (count==2) {
    			bc1.start();
    			GoLibrary2 frame = new GoLibrary2();
        		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(800, 500);
        		frame.setVisible(true);
        		dispose();
    		}
		}
		
	}

}
