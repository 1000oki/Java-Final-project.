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
	public static String[] c = {"데이터구조","객체지향프로그래밍", "웹프로그래밍기초", "비판적 사고와 토론", "IT기기구조"};
	public static String[] pn = {"데이터구조","<HTML>객체지향<br>프로그래밍<HTML>", "<HTML>웹프로그래밍<br>기초<HTML>", "<HTML>비판적<br>사고와 토론<HTML>", "<HTML>IT<BR>기기구조<HTML>"};
	public static int a = c.length,b = 5,count=0;
	public static String[][] cn = {{"<HTML>데이터구조01분반-박영호 <br>12시 ~ 1시15분<HTML>", "<HTML>데이터구조02분반-박영호 <br>15시 ~ 16시15분<HTML>"},
			{"<HTML>객체지향프로그래밍01분반-윤용익 <br>09시 ~ 10시15분<HTML>"},{"<HTML>웹프로그래밍기초01분반-최자령 <br>13시 ~ 14시 45분<HTML>",
				"<HTML>웹프로그래밍기초02분반-송유정 <br>15시 ~ 16시15분<HTML>","<HTML>웹프로그래밍기초03분반-임순범, 송유정 <br>13시30분 ~ 14시45분<HTML>"},
			{"<HTML>비판적 사고와 토론01분반-신희선 <br>13시 ~ 14시50분<HTML>","<HTML>비판적 사고와 토론02분반-박영욱 <br>15시 ~ 16시 50분<HTML>"},
			{"<HTML>IT기기구조01분반-김철연 <br>15시 ~ 16시15분<HTML>"}};
 	JLabel[][] cl = new JLabel[a][b];
	public static JButton[][] cb = new JButton[a][b];
	JPanel[][] cp = new JPanel[a][b];
	JPanel[] choose = new JPanel[a];
	Color color = new Color(0x4472c4);
	Color framecolor = new Color(0x9DBAE1);
	public static int[][] day = {{0,2},{0,2},{0,2},{0},{1,3}};
	
	public Search() {
		jf = new JFrame("검색 기능");
		fl = new Font("Dialog", Font.ITALIC, 15);
		fc = new Font("Dialog", Font.ITALIC, 13);
		fb = new Font("휴면 편지체",Font.BOLD,20);
		all = new JPanel(new BorderLayout(5,5));
		top = new JPanel();
		time = new TimeTablePanel();
		tf = new JTextField(15);
		tf.setFont(fl);
		top.add(tf);
		search = new JButton("검색");
		search.setFocusPainted(false);
		search.setBackground(color);
		search.setForeground(Color.white);
		search.addActionListener(this);
		reset = new JButton("초기화");
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
				cb[i][j] = new JButton("선택");
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
		infoLabel = new JLabel("※ 수강과목  : 객체지향프로그래밍, 비판적 사고와 토론, IT기기구조, 데이터구조, 웹프로그래밍기초");
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
