package Graphics;

import javax.swing.JFrame;

public class GUI 
{
	static JFrame frame;
	public GUI()
	{
		frame=new JFrame("Chess");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Menu menu=new Menu();
	}
}
