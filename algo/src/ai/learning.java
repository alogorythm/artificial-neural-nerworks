package ai;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class learning {


	learning(){
		JFrame screen=new JFrame();
		JLabel title=new JLabel("~~~~~~~~ DIAGNOSIS ~~~~~~~~",JLabel.CENTER);
		screen.setSize(400,280);
		screen.setLocation(600, 40);
		title.setBounds(370,1, 100, 15);
		screen.getContentPane().add(title,"North");
		screen.setVisible(true);

	}

}
