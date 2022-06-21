package Driver;

import javax.swing.SwingUtilities;

import Graphics.Board;

public class Main 
{
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
				{
					public void run()
					{
						Board board=new Board();
					}
				});
	}
}
