import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
 
public class Tenth1 extends JFrame implements ActionListener{
    JScrollPane scrollPane;
    ImageIcon icon;
    JTextArea l2;
    JButton b2;
    int count = 0;
    Thread ten2 = new Thread(new ButtonSound()); Thread ten3 = new Thread(new ButtonSound());
    Thread ten4= new Thread(new ButtonSound()); Thread ten5 = new Thread(new ButtonSound());
    Thread ten6 = new Thread(new ButtonSound()); Thread ten7 = new Thread(new ButtonSound());
    
    public Tenth1() {
    	    	   	
        icon = new ImageIcon("Tenth1.png");    
       
        JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(icon.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };      
        
        l2 = new JTextArea("\n    "+ Second.name.getText() +" : ���� ���� ���ǽ��� ���� ����� �� ����\n            ���� �Դ��� �ڸ��� ���� ����~");
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
    			ten2.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : �� �鸸���̴�! �鸸���̾� ���� �� ��� �Ծ�?");
    		}else if (count == 2) {
    			ten3.start();
    			l2.setText("\n\n    �鸸���� : �׷� �׷� �� ���ٰ� ����. �׷��� ���ῡ ����� �� ������ �þ�?");
    		}else if (count == 3) {
    			ten4.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : �� ����... �̹� ���� ������ ���� �� �����ٰ� ��¥�Τ���");
    		}else if (count == 4) {
    			ten5.start();
    			l2.setText("\n\n    �鸸���� : ���� �˾Ҿ� ���� ������ �˰���?");
    		}else if (count == 5) {
    			ten6.start();
    			l2.setText("\n\n    "+ Second.name.getText() +" : ������ ������ �� ������ ���̴�. �� �ɾ�");
    		}else{
    			ten7.start();
				Eleventh frame = new Eleventh();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setSize(800, 500);
    			frame.setVisible(true);
    			dispose();
			}
    	}
    }
}
