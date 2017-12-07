import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class UI {
	public static void main(String[] args) {
		JFrame MyJFrame = new JFrame("GUI Exercise");
		MyJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MyJFrame.setBounds(200,400,500,600);
		MyJFrame.setLayout(new FlowLayout());
		String [] a = {"1","2","3","4","5"};
		String [] b = {"-------------------"};
		JLabel [] Label = new JLabel[19];
		JRadioButton[][] degrees = new JRadioButton[19][5];
		String [] numbers = {"1","2","3","4","5"};
		/*String [] symptomps = {"소화불량","복부팽창","가슴(명치)통증","울렁증","두통","발열","속쓰림","황달","구토","호흡곤란","기침","설사","신경마비"
				,"근육경련","복통","각혈","가래","위산역류","소변색변화"};*/
		 String[][] symptomps = {{"소화불량"},{"복부팽창"},{"가슴(명치)통증"},{"울렁증"},{"두통"},{"발열"},{"속쓰림"},{"황달"},{"구토"},{"호흡곤란"},{"기침"},{"설사"},{"신경마비"}
					,{"근육경련"},{"복통"},{"각혈"},{"가래"},{"위산역류"},{"소변색변화"}};
		ButtonGroup group = new ButtonGroup();
		JLabel [] some = new JLabel[19];
		Object ob[][] = new Object[19][0];
		DefaultTableModel model = new DefaultTableModel(ob,symptomps);
		JTable table;
		table = new JTable(model);
		MyJFrame.add(table);
		MyJFrame.setVisible(true);
		int i,j;
		/*for(j=0;j<19;j++)
		{
			//radioPanel[j] = new JPanel();
			//groupRd[j] = new ButtonGroup();
			//lb[j] = new JLabel(symptomps[j]);
			Label[j] = new JLabel(symptomps[j]);
			some[j] = new JLabel(b[0]);
			some[j].setHorizontalTextPosition(SwingConstants.TRAILING);
			MyJFrame.add(Label[j]);
			
		for(i=0;i<5;i++)
		{
			degrees[j][i] = new JRadioButton(a[i]);
			group.add(degrees[j][i]);
			MyJFrame.add(degrees[j][i]);
			MyJFrame.setVisible(true);
		}
		MyJFrame.add(some[j]);
		
			
		}
		*/
	}	
}
		/*Container[] ComboBox=  new Container[19];
		ButtonGroup[] groupRd = new ButtonGroup[19];
		JRadioButton[][] degrees = new JRadioButton[19][5];
		JPanel[] radioPanel = new JPanel[19];
		JLabel[] lb = new JLabel[19];
		String [] degree = {"1","2","3","4","5"};
		String [] symptomps = {"소화불량","복부팽창","가슴(명치)통증","울렁증","두통","발열","속쓰림","황달","구토","호흡곤란","기침","설사","신경마비"
				,"근육경련","복통","각혈","가래","위산역류","소변색변화"};		
		JLabel imageLabel = new JLabel();
	UI(){
		
	setTitle("Check the symptoms");
	
		
	
	//JPanel radioPanel = new JPanel();
	
	int i,j,temp=0;
	
	for(j=0;j<19;j++)
	{
		ComboBox[j] = new Container();
		ComboBox[j].setLayout(new BorderLayout());
		radioPanel[j] = new JPanel();
		groupRd[j] = new ButtonGroup();
		lb[j] = new JLabel(symptomps[j]);
	for(i=0;i<5;i++)
	{
		if(j==0)
			{
			degrees[j][i]=new JRadioButton(i+1+"");
			System.out.println(i);
			}
		else
			{degrees[j][i]=new JRadioButton(j*5+i+1+"");
			System.out.println(j*5+i);
			}
		//
		groupRd[j].add(degrees[j][i]);
		radioPanel[j].add(degrees[j][i]);
		ComboBox[j].add(radioPanel[j]);
		System.out.println("");
	}
	ComboBox[j].setVisible(true);
	this.add(radioPanel[j]);	
	}
	setSize(500,700);
	setVisible(true);	
	}
	public static void main(String[] args) {
	new UI();	
	}
	
}
*/