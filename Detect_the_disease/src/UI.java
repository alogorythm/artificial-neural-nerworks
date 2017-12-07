import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class UI {
	static int[] data = new int[19];
	static int p=0;
	static int total=0;
   public static void main(String[] args) {
      int y=150,i,j;
      
      String[] symptomps = {"소화가 잘 안된다.","배쪽이 부푸는 느낌이 있다","가슴(명치)에서 통증이 느껴진다","속이 자주 울렁거린다","두통이 있다","열이 난다","속이 쓰리다","홯달 증세가 있다","구토가 올라온다","호흡에 이상이 있다","기침이 나온다","설사가 나온다","신경마비가 일어난다"
            ,"근육경련이 일어난다","배가 아프다","가래에 피가 섞여있다","가래가 나온다","위산이 역류 할 때가 있다","소변색에 변화가 있다"};
      String numStr=" ";
      JFrame pop=new JFrame();
      JRadioButton[] btn1 = new JRadioButton[19];
      JRadioButton[] btn2 = new JRadioButton[19];
      JRadioButton[] btn3 = new JRadioButton[19];
      JRadioButton[] btn4 = new JRadioButton[19];
      JRadioButton[] btn5 = new JRadioButton[19];
      JButton[] check = new JButton[19];
      JButton submit = new JButton("Submit");
      ButtonGroup is = new ButtonGroup();
      JPanel Submit = new JPanel();
      int some=150;
      pop.setTitle("");
      pop.setSize(1000,900);
      pop.setLocation(470, 40);
      JPanel[] pan =new JPanel[19];              //pan.setLayout();      //   위가 ()면 됨
      //버튼 그룹으로
      ButtonGroup[] bg=new ButtonGroup[20];       //묶어준 그룹안에서는 1개만 선택 가능
      for(i=0;i<19;i++)
      {
         bg[i]=new ButtonGroup();
         pan[i]= new JPanel();
         pan[i].setLayout(null);
         btn1[i]=new JRadioButton(numStr);
         btn1[i].addItemListener(new SelectItemListener1());
         btn2[i]=new JRadioButton(numStr);
         btn2[i].addItemListener(new SelectItemListener2());
         btn3[i]=new JRadioButton(numStr);
         btn3[i].addItemListener(new SelectItemListener3());
         btn4[i]=new JRadioButton(numStr);
         btn4[i].addItemListener(new SelectItemListener4());
         btn5[i]=new JRadioButton(numStr);
         btn5[i].addItemListener(new SelectItemListener5());
         check[i]=new JButton("correct");
         bg[i].add(btn1[i]);
         bg[i].add(btn2[i]);
         bg[i].add(btn3[i]);
         bg[i].add(btn4[i]);
         bg[i].add(btn5[i]);
         bg[i].add(check[i]);
      }//각 증상마다 버튼 그룹화 시킴    
      bg[19]= new ButtonGroup();
      bg[19].add(submit);
      
      //is.add(submit);
      for( i=0;i<19;i++) {
         btn1[i].setBounds(270,y,30,15);
         btn2[i].setBounds(370,y,30,15);
         btn3[i].setBounds(470,y,30,15);
         btn4[i].setBounds(570,y,30,15);
         btn5[i].setBounds(670,y,30,15);
         check[i].setBounds(770,y,100,15);
         y=y+35;   
       //  System.out.println(y);
      }            //모든 점 위치 설정
      submit.setBounds(1200, 1000, 100, 80);
      JLabel[] label=new JLabel[19];
      for(j=0;j<19;j++) {
         label[j] = new JLabel();
         label[j].setText(symptomps[j]);
         label[j].setBounds(10,some,200,15);
         some=some+35;
      }
      JLabel lay1=new JLabel("전혀 없다");
      JLabel lay2=new JLabel("조금 그렇다");
      JLabel lay3=new JLabel("꽤 그렇다");
      JLabel lay4=new JLabel("자주 그런다");
      JLabel lay5=new JLabel("항상 그런다");
      lay1.setBounds(250, 100, 100, 15);
      lay2.setBounds(350, 100, 100, 15);
      lay3.setBounds(450, 100, 100, 15);
      lay4.setBounds(550, 100, 100, 15);
      lay5.setBounds(650, 100, 100, 15);
      for(j=0;j<19;j++) {
         pop.getContentPane().add(label[j]);
      }
      pop.getContentPane().add(lay1);
      pop.getContentPane().add(lay2);
      pop.getContentPane().add(lay3);
      pop.getContentPane().add(lay4);
      pop.getContentPane().add(lay5);
      for(i=0;i<19;i++) {
         pop.getContentPane().add(btn1[i]);
         pop.getContentPane().add(btn2[i]);
         pop.getContentPane().add(btn3[i]);
         pop.getContentPane().add(btn4[i]);
         pop.getContentPane().add(btn5[i]);
         pop.getContentPane().add(check[i]);
      }
      pop.getContentPane().add(submit,"South");
      for(j=0;j<19;j++) {
         pop.getContentPane().add(pan[j],BorderLayout.CENTER);
      }
      
      submit.setLocation(100, 200);
      //Submit.add(submit);
      //pop.getContentPane().add(submit);
      pop.setVisible(true);
   }
	public static class SelectItemListener1 implements ItemListener
	{	      
		public void itemStateChanged(ItemEvent e)
	      {			
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             		int j;   
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	            	 			
	                         data[p]=1;
	                       	 System.out.println("data[j] is "+data[p]);
	             }
	      }
	}
	public static class SelectItemListener2 implements ItemListener
	{
	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             int j;
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {	            	
	                         data[p]=2;
	                         System.out.println("data[j] is "+data[p]);
	             }
	      }
	}
	public static class SelectItemListener3 implements ItemListener
	{
	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             int j;
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	                   
	                         data[p]=3;
	                         System.out.println("data[j] is "+data[p]);
	             }
	      }
	}
	public static class SelectItemListener4 implements ItemListener
	{
	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             int j;
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	            	
	                         data[p]=4;
	                         System.out.println("data[j] is "+data[p]);
	             }
	      }
	}
	public static class SelectItemListener5 implements ItemListener
	{
	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             int j;
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	            	 
	                         data[p]=5;
	                         System.out.println("data[j] is "+data[p]);
	             }
	      }
	}
	public static class checking implements ItemListener
	{	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	            	 total=total+data[p];
	            	 p++;
	             }
	      }
	}
	public static class Submit implements ItemListener
	{	      
		public void itemStateChanged(ItemEvent e)
	      {
	             AbstractButton sel = (AbstractButton)e.getItemSelectable();
	             
	             
	             if(e.getStateChange() == ItemEvent.SELECTED)
	             {
	            	 
	             }
	      }
	}
}
	