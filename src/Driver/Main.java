package Driver;

import javax.swing.SwingUtilities;

import Graphics.GUI;

public class Main 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						GUI gui=new GUI();
					}
				});
	}
}
