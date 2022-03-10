import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Fifth extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JLabel l2;
    JButton b2;
    int count = 0;
    Thread a1 = new Thread(new ButtonSound()); Thread a2 = new Thread(new ButtonSound());
    Thread a3 = new Thread(new ButtonSound()); Thread a4 = new Thread(new ButtonSound());
    Thread a5 = new Thread(new ButtonSound()); Thread a6 = new Thread(new ButtonSound());
    
    public Fifth() {
    	    	   	
        icon = new ImageIcon("Fourth2.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JLabel("    ������ : �� �κ��� ��¼�� ��¼�� �X�� �X�� ���⼭ �̷��� �̺�Ʈ�� ...");
		l2.setOpaque(true);
		l2.setBackground(new Color(217,217,217));
		l2.setBounds(0,350,700,130);
		Font font1 = new Font("�޸�����ü", Font.BOLD, 20);
		l2.setFont(font1);
		
		b2 = new JButton("Next");
		b2.setBackground(new Color(217,217,217));
		Font font = new Font("�޸�����ü", Font.BOLD, 22);
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
    			a1.start();
    			l2.setText("    ������ : �׷��� �̰� �̷���, �̷��� ����. �ٵ� �� ������� ����?");
    		}else if (count == 2) {
    			a2.start();
    			l2.setText("    ����....");
    		}else if (count == 3) {
    			a3.start();
    			l2.setText("    ������ : �� �ð��� �� �Ǿ��׿�. �ٵ� ����ϱ��� Ȩ��ũ �ؿ�����~");
    		}else if (count == 4) {
    			a4.start();
    			l2.setText("    �ٸ� �л��� : (��������) ��~ (����~)(��������~~) ");
    		}else if (count == 5) {
    			a5.start();
    			l2.setText("    "+Second.name.getText()+" : �� ���� ������~ �������� �ݹ� ������. ���� ������ �����?");
    		}else {
    			a6.start();
			Sixth frame = new Sixth();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
		}
    	}
    }
}
