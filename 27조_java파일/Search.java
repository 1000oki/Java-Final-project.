import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;

public class Search extends JFrame implements ActionListener {
	JFrame jf;
	JPanel  time,input, course, top, infoPanel;
	JLabel infoLabel;
	public static JPanel all;
	JTextField tf;
	JButton search, reset, back;
	Font fl, fc, fb;
	public static String[] c = {"�����ͱ���","��ü�������α׷���", "�����α׷��ֱ���", "������ ���� ���", "IT��ⱸ��"};
	public static String[] pn = {"�����ͱ���","<HTML>��ü����<br>���α׷���<HTML>", "<HTML>�����α׷���<br>����<HTML>", "<HTML>������<br>���� ���<HTML>", "<HTML>IT<BR>��ⱸ��<HTML>"};
	public static int a = c.length,b = 5,count=0;
	public static String[][] cn = {{"<HTML>�����ͱ���01�й�-�ڿ�ȣ <br>12�� ~ 1��15��<HTML>", "<HTML>�����ͱ���02�й�-�ڿ�ȣ <br>15�� ~ 16��15��<HTML>"},
			{"<HTML>��ü�������α׷���01�й�-������ <br>09�� ~ 10��15��<HTML>"},{"<HTML>�����α׷��ֱ���01�й�-���ڷ� <br>13�� ~ 14�� 45��<HTML>",
				"<HTML>�����α׷��ֱ���02�й�-������ <br>15�� ~ 16��15��<HTML>","<HTML>�����α׷��ֱ���03�й�-�Ӽ���, ������ <br>13��30�� ~ 14��45��<HTML>"},
			{"<HTML>������ ���� ���01�й�-���� <br>13�� ~ 14��50��<HTML>","<HTML>������ ���� ���02�й�-�ڿ��� <br>15�� ~ 16�� 50��<HTML>"},
			{"<HTML>IT��ⱸ��01�й�-��ö�� <br>15�� ~ 16��15��<HTML>"}};
 	JLabel[][] cl = new JLabel[a][b];
	public static JButton[][] cb = new JButton[a][b];
	JPanel[][] cp = new JPanel[a][b];
	JPanel[] choose = new JPanel[a];
	Color color = new Color(0x4472c4);
	Color framecolor = new Color(0x9DBAE1);
	public static int[][] day = {{0,2},{0,2},{0,2},{0},{1,3}};
	
	public Search() {
		jf = new JFrame("�˻� ���");
		fl = new Font("Dialog", Font.ITALIC, 15);
		fc = new Font("Dialog", Font.ITALIC, 13);
		fb = new Font("�޸� ����ü",Font.BOLD,20);
		all = new JPanel(new BorderLayout(5,5));
		top = new JPanel();
		time = new TimeTablePanel();
		tf = new JTextField(15);
		tf.setFont(fl);
		top.add(tf);
		search = new JButton("�˻�");
		search.setFocusPainted(false);
		search.setBackground(color);
		search.setForeground(Color.white);
		search.addActionListener(this);
		reset = new JButton("�ʱ�ȭ");
		reset.setForeground(Color.white);
		reset.setFocusPainted(false);
		reset.setBackground(color);
		reset.addActionListener(this);
		top.add(search);
		top.add(reset);
		top.setBackground(framecolor);
		
		
		for(int i=0;i<a;i++) {
			choose[i] = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
			for(int j=0;j<cn[i].length;j++) {
				cl[i][j] = new JLabel(cn[i][j]);
				cl[i][j].setFont(fc);
				cb[i][j] = new JButton("����");
				cb[i][j].setForeground(Color.white);
				cb[i][j].setBackground(color);
				cb[i][j].setFocusPainted(false);
				cb[i][j].setPreferredSize(new Dimension(80,30));
				cb[i][j].addActionListener(this);
				cp[i][j] = new JPanel();
				cp[i][j].setLayout(new FlowLayout(FlowLayout.CENTER, 10,5));
				cp[i][j].add(cl[i][j]);
				cp[i][j].add(cb[i][j]);
				cp[i][j].setBackground(Color.white);
				choose[i].add(cp[i][j]);
				choose[i].setBackground(framecolor);
			}
		}
		
		infoPanel = new JPanel(); infoPanel.setBackground(framecolor);
		infoPanel.setBounds(0,410,670,90);
		infoLabel = new JLabel("�� ��������  : ��ü�������α׷���, ������ ���� ���, IT��ⱸ��, �����ͱ���, �����α׷��ֱ���");
		infoLabel.setFont(fc); infoLabel.setForeground(Color.white);
		infoPanel.add(infoLabel); jf.add(infoPanel);
		
		back = new JButton("Back");
		back.setFont(fb);
		back.setBackground(framecolor);
		back.setForeground(color);
		back.setBounds(670,410,130,55);
		back.setBorder(null);
		back.addActionListener(this);
		jf.add(back);
		
		all.add(top, BorderLayout.NORTH);
		all.setBackground(framecolor);
		jf.getContentPane().setLayout(null);
		time.setBounds(0,0,400,410); jf.getContentPane().add(time);
		all.setBounds(400,0,400,410); jf.getContentPane().add(all);

		jf.setSize(800,500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {	
		for(int i=0;i<a;i++) {
			if(e.getSource()==search) {
				if(tf.getText().equals(c[i])) {
					all.add(choose[i],BorderLayout.CENTER);
					all.revalidate();
					all.repaint();
				}
			}
			if(e.getSource()==reset) {
				tf.setText("");
				all.remove(choose[i]);
				all.revalidate(); all.repaint();
			}
		}
		for(int i=0;i<a;i++) {
			for(int j=0;j<cn[i].length;j++) {
				if(e.getSource()==cb[i][j]) {
					for(int k=0;k<day[i].length;k++) {
						TimeTablePanel.classpanels[i][j][k].setVisible(true);
					}
				}
			}
		}
		if(e.getSource()==back) {
			First frame = new First(0);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	frame.setSize(800, 500);
	    	frame.setVisible(true);
	    	jf.dispose();
		}
	}
	
}
