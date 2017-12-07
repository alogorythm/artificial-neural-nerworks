package ai;
import javax.swing.*;

import ai.learning;


import java.awt.*;                       //pop이 screen  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class diagnosis {

	 static double[] testresult = new double[8];
	diagnosis(){
		learning teach;
		JFrame screen=new JFrame();
		JPanel Submit = new JPanel();
		JButton submit = new JButton("teaching!!");
		String result="";
		Panel p;
		Panel pt;
		List list;
		//test에서 받아와야함 숫자 어레이를. 그걸 testresult에 저장 합시다. 바로 아래
		/*int[] testresult = null;*//*= {1,0,0,0,0,0,0,0}; */  //되는지보기위해 임의로
		int i=0,count=0;
		String[] disease= {"위염","간염","식도염","폐렴","장염","식중독","천식","결핵"};
		screen.setSize(400,280);
		screen.setLocation(470, 40);
		JLabel title=new JLabel("~~~~~~~~ DIAGNOSIS ~~~~~~~~",JLabel.CENTER);
		title.setBounds(370,1, 100, 15);
		submit.setBounds(370,1, 100, 15);
		screen.getContentPane().add(title,"North");
		for(i=0;i<8;i++) {
			if(testresult[i]==1.0) {
				result=result+disease[i]+" ";
				count++;
			}
		}
		if(count==0) {
			result=result+"건강합니다";
		}
		else if(count==8) {
			result="";
			result=result+"얼마 남지 않으셨습니다...";
		}
		else  {
			result=result+"에 걸리셨습니다";
		}
		p = new Panel();
		pt= new Panel();
		list = new List(10,true);
		list.add(" ");
		list.add(" ");
		list.add(" ");
		list.add("당신은");
		list.add(" ");
		list.add(result);
		p.add(list);
		pt.add(submit);
		screen.getContentPane().add(p,BorderLayout.CENTER);
		screen.getContentPane().add(pt,BorderLayout.SOUTH);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //거리순 을 클릭하고 비타, 복파, 동서울 을 클릭하면 서버에 필요한 정보를 주고 그거에 해당하는 가게 리스트 top4를 받을 꺼야
				learning teach= new learning();
			}
		});
		screen.setVisible(true);
	}
}
