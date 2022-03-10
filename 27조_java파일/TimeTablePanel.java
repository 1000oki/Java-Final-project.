import javax.swing.*;
import javax.swing.border.LineBorder;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.awt.event.*;
import java.awt.*;

public class TimeTablePanel extends JPanel {
	LocalDate current = LocalDate.now();
	Color frameColor = new Color(0x9DBAE1), buttonColor = new Color(0x4472c4);
	Font font1 = new Font("Dialog", Font.BOLD, 15);
	JPanel[][] gridpanels;
	JPanel[] dayPanel,timePanel; JLabel[] day,time;
	String[] days= {"월","화","수","목","금"}, times= {"9", "10","11","12","1","2","3","4"};
	LineBorder border = new LineBorder(Color.gray);
	JLabel today;
	String dayofweek;
	public static JLabel[][][] classlabels = new JLabel [Search.a][Search.b][2];
	public static JPanel[][][] classpanels = new JPanel [Search.a][Search.b][2];

	public TimeTablePanel() {
		setBackground(frameColor);
		setLayout(null);
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 M월 d일 ");
		String nowString = current.format(dateTimeFormatter);  
		today = new JLabel("● Today : " + nowString);
		
		dayPanel = new JPanel[5]; timePanel = new JPanel[8];
		day = new JLabel[5]; time = new JLabel[8];
        gridpanels = new JPanel[5][8];
        
        today.setFont(new Font("Dialog", Font.BOLD, 20));
        today.setForeground(Color.white);
        today.setBounds(35,10,350,50);
        add(today);
        for(int i=0;i<Search.a;i++) {
			for(int j=0;j<Search.cn[i].length;j++) {
					for(int k=0;k<Search.day[i].length;k++) {
						classpanels[i][j][k] = new JPanel();
						classlabels[i][j][k] = new JLabel(Search.pn[i]);
						classlabels[i][j][k].setFont(new Font("Dialog",Font.BOLD,10));
						classlabels[i][j][k].setForeground(Color.black);
						classpanels[i][j][k].add(classlabels[i][j][k]);
						classpanels[i][j][k].setBorder(border);
						if(i==3) {
							classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,90+(4+2*j)*40,60,70);
							classpanels[i][j][k].setBackground(new Color(248,203,173));
						}else if(i==1){
							classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,90,60,50);
							classpanels[i][j][k].setBackground(new Color(255,230,153));
						}else if(i==2) {
							classpanels[i][j][k].setBackground(new Color(197,224,180));
							if(j==2) {
								classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,270,60,50);
							}else {
								classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,90+(4+2*j)*40,60,50);
							}
						}else if(i==0) {
							classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,90+(j+1)*3*40,60,50);
							classpanels[i][j][k].setBackground(new Color(189,215,238));
						}else if(i==4) {
							classpanels[i][j][k].setBounds(50+2*Search.day[i][k]*62,90+6*40,60,50);
							classpanels[i][j][k].setBackground(new Color(143,170,220));
						}
						add(classpanels[i][j][k]);	
						classpanels[i][j][k].setVisible(false);
				}
			}
		}
        //시간표 본판
		for (int i=0 ; i<5 ; i++) {
			//요일
			day[i] = new JLabel(days[i]); dayPanel[i] = new JPanel();
			day[i].setFont(font1);
			dayPanel[i].setBackground(Color.white);
			dayPanel[i].setBounds(50+i*62,58,60,30);
			dayPanel[i].setBorder(border);
			dayPanel[i].add(day[i]); add(dayPanel[i]);
			
			for (int j=0 ; j<8 ; j++) {
				//시간표격자
				gridpanels[i][j] = new JPanel();
				gridpanels[i][j].setBackground(Color.white);
				gridpanels[i][j].setBounds(50+i*62,90+j*40,60,40); //격자한칸사이즈 60*40, 요일별간격2
				gridpanels[i][j].setBorder(border);
				add(gridpanels[i][j]);
			}
		
		//시간 : 9시, 10시, ...
		for( int j = 0 ; j<8 ; j++) {
			timePanel[j] = new JPanel();
			time[j] = new JLabel(times[j]);
			time[j].setFont(new Font("Dialog", Font.BOLD, 10));
			timePanel[j].setBounds(35,90+j*40,15,40);
			timePanel[j].setBorder(border);
			timePanel[j].add(time[j]); add(timePanel[j]);
			}
		
		}
		
		//요일 받아서 해당요일 패널 색 바꿈
		dayofweek = current.getDayOfWeek().name();
		switch(dayofweek) {
		case "MONDAY" : 
			dayPanel[0].setBackground(buttonColor); day[0].setForeground(Color.white); break;
		case "TUESDAY" :
			dayPanel[1].setBackground(buttonColor); day[1].setForeground(Color.white); break;
		case "WEDNESDAY" :
			dayPanel[2].setBackground(buttonColor); day[2].setForeground(Color.white); break;
		case "THURSDAY" :
			dayPanel[3].setBackground(buttonColor); day[3].setForeground(Color.white); break;
		case "FRIDAY" :
			dayPanel[4].setBackground(buttonColor); day[4].setForeground(Color.white); break;
		default :
			break;
		}
	}
}
