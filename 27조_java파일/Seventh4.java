import java.awt.event.*;  
import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Seventh4 extends JFrame implements ActionListener{
	JPanel background;
	ImageIcon backgroundimg1= new ImageIcon("Seventh2.jpg");
	Font font,font1; 
	JTextArea txt1;
	JScrollPane scrollPane;
	JButton b1;
	int count=0;
	Thread ph1 = new Thread(new ButtonSound()); Thread ph2 = new Thread(new ButtonSound());
	Thread ph3 = new Thread(new ButtonSound()); Thread ph4 = new Thread(new ButtonSound());
	Thread ph5 = new Thread(new ButtonSound());
	
	public Seventh4() {

		JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
                g.drawImage(backgroundimg1.getImage(), 0, 0, 800, 350, null);
                setOpaque(false); 
                super.paintComponent(g);
            }
        };
        
        txt1 = new JTextArea("\n    �鸸����: �ߡ� �ߡ� "+Second.name.getText()+"��"
        		+ "\n    ���� ���ῡ ���� ���ִ� �� ������ ����? ���� ������ �Ʊ��ݾ�~ (�ұټұ�)");
		txt1.setOpaque(true);
		txt1.setBackground(new Color(217,217,217));
		txt1.setBounds(0,350,700,130);
		Font font1 = new Font("�޸�����ü", Font.BOLD, 20);
		txt1.setFont(font1);
		
		b1 = new JButton("Next");
		b1.setBackground(new Color(217,217,217));
		Font font = new Font("�޸�����ü", Font.BOLD, 22);
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
    			ph1.start();
    			txt1.setText("\n    "+Second.name.getText()+": �� �׷���?"
    					+ "\n    �׷�  �����غ��� ���� ���� ������ ���� �����ٰ� (�ұټұ�)\r\n");
    		} else if (count==2) {
    			ph2.start();
    			txt1.setText("\n    "+Second.name.getText()+": �� ���� �����١� �ʹ� ����� �����̾��� "
    					+ "\n    ���� ������ ���� �� �¾� ����\r\n");
    		} else if (count==3) {
    			ph3.start();
    			txt1.setText("\n    �鸸����: �� ���� �ٸ� ���� ������ ���� �׷� ������~\r\n");
    		} else if (count==4) {
    			ph4.start();
    			txt1.setText("\n    "+Second.name.getText()+":������ �ϴ� ������ ���� ����~\r\n");
    		} else if (count==5) {
    			ph5.start();
    			Eight frame = new Eight();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		frame.setSize(800, 500);
        		frame.setVisible(true);
        		dispose();
    		}
		}
		
	}

}

