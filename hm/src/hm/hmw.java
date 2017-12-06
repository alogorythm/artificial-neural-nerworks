package hm;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class hmw {
	public static void main(String[] args) {
		System.out.println("켜짐");
		int y=70,i,j;
		String[] symptomps = {"소화가 잘 안된다.","배쪽이 부푸는 느낌이 있다","가슴(명치)에서 통증이 느껴진다","속이 자주 울렁거린다","두통이 있다","열이 난다","속이 쓰리다","홯달 증세가 있다","구토가 올라온다","호흡에 이상이 있다","기침이 나온다","설사가 나온다","신경마비가 일어난다"
				,"근육경련이 일어난다","배가 아프다","가래에 피가 섞여있다","가래가 나온다","위산이 역류 할 때가 있다","소변색에 변화가 있다"};
		String[] numStr= {"1","2","3","4","5"};
		JFrame pop=new JFrame();
		JRadioButton[] btn1 = new JRadioButton[19];
		JRadioButton[] btn2 = new JRadioButton[19];
         JRadioButton[] btn3 = new JRadioButton[19];
         JRadioButton[] btn4 = new JRadioButton[19];
         JRadioButton[] btn5 = new JRadioButton[19];
		pop.setTitle("");
		pop.setSize(440,200);
		pop.setLocation(470, 40);
		JPanel[] pan =new JPanel[19];        		//pan.setLayout();		//   위가 ()면 됨
		//버튼 그룹으로
		ButtonGroup[] bg=new ButtonGroup[19];       //묶어준 그룹안에서는 1개만 선택 가능
		for(i=0;i<19;i++)
		{
			bg[i]=new ButtonGroup();
			pan[i]= new JPanel();
			pan[i].setLayout(null);
			
			
				System.out.println(i);
				btn1[i]=new JRadioButton(numStr[0]);
				
				 btn2[i]=new JRadioButton(numStr[1]);
            btn3[i]=new JRadioButton(numStr[2]);
            btn4[i]=new JRadioButton(numStr[3]);
            btn5[i]=new JRadioButton(numStr[4]);
             bg[i].add(btn1[i]);
             bg[i].add(btn2[i]);
             bg[i].add(btn3[i]);
             bg[i].add(btn4[i]);
             bg[i].add(btn5[i]);
             
             System.out.println(i);
			
		}//각 증상마다 버튼 그룹화 시킴

		//btn1.setBounds(280, 30, 30,20);           
		for( i=0;i<19;i++) {
			
				btn1[i].setBounds(280,y,30,20);
			
				btn2[i].setBounds(310,y,30,20);
			
				btn3[i].setBounds(340,y,30,20);
			
				btn4[i].setBounds(370,y,30,20);
			
				btn5[i].setBounds(400,y,30,20);
			y=y+30;
			      
		}//모든 점 위치 설정
			//visionRaBtn.setContentAreaFilled(false); 
			JLabel[] label=new JLabel[19];
			for(j=0;j<19;j++) {
				label[j] = new JLabel();
				label[j].setText(symptomps[j]);
			}
			JLabel lay1=new JLabel("전혀 없다");
			JLabel lay2=new JLabel("조금 그렇다");
			JLabel lay3=new JLabel("꽤 그렇다");
			JLabel lay4=new JLabel("자주 그런다");
			JLabel lay5=new JLabel("항상 그런다");
			lay1.setBounds(280, 0, 30, 30);
			lay2.setBounds(310, 0, 30, 30);
			lay3.setBounds(340, 0, 30, 30);
			lay4.setBounds(370, 0, 30, 30);
			lay5.setBounds(400, 0, 30, 30);
			for(j=0;j<19;j++) {
				label[j].setBounds(10, 30, 70, 30);
			}
			for(j=0;j<19;j++) {
				pop.getContentPane().add(label[j]);
			}
			pop.getContentPane().add(lay1);
			pop.getContentPane().add(lay2);
			pop.getContentPane().add(lay3);
			pop.getContentPane().add(lay4);
			pop.getContentPane().add(lay5);
			for(i=0;i<19;i++) {

				
					pan[i].add(btn1[i]);
					pan[i].add(btn2[i]);
					pan[i].add(btn3[i]);
					pan[i].add(btn4[i]);
					pan[i].add(btn5[i]);


				
				pan[i].setVisible(true);
			}

			for(j=0;j<19;j++) {
				pop.getContentPane().add(pan[j],BorderLayout.CENTER);
			}
			pop.setVisible(true);
		}
	}