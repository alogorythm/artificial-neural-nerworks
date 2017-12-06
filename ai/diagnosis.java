package ai;
import javax.swing.*;
import java.awt.*;                       //pop이 screen  

import javax.swing.SwingConstants;
public class diagnosis {
	public static void main(String[] args) {
		JFrame screen=new JFrame();
		String result="";
		Panel p;
		List list;
		//test에서 받아와야함 숫자 어레이를. 그걸 testresult에 저장 합시다. 바로 아래
		int[] testresult= {1,0,0,0,0,0,0,0};   //되는지보기위해 임의로
		int i=0,count=0;
		String[] disease= {"위염","간염","식도염","폐렴","장염","식중독","천식","결핵"};
		screen.setSize(400,280);
		screen.setLocation(470, 40);
		JLabel title=new JLabel("---- DIAGNOSIS ----",JLabel.CENTER);
		title.setBounds(370,1, 100, 15);
		screen.getContentPane().add(title,"North");
		for(i=0;i<8;i++) {
			if(testresult[i]==1) {
				result=result+disease[i]+" ";
				count++;
			}
		}
		if(count==0) {
			result=result+"건강합니다";
		}
		else if(count==8) {
			result="";
			result=result+"사망하셨습니다...";
		}
		else  {
			result=result+"에 걸리셨습니다";
		}
		System.out.println(result);
		p = new Panel();
		list = new List(10,true);
		list.add(" ");
		list.add("당신은");
		list.add(" ");
		list.add(result);
		 p.add(list);
		screen.getContentPane().add(p,BorderLayout.CENTER);
		screen.setVisible(true);
	}
}
