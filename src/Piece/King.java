package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class King 
{
	static ImageIcon kingIcon;
	
	static Image kingImage;
	
	public King()
	{
		
	}
	
	public static void setImageIcon(String clr)
	{
		File currDir=new File(".");
		
		String path=currDir.getAbsolutePath();
		path=path.substring(0, path.length()-2);	
		
		String imagePath=path+File.separator+"PieceSprites"+File.separator;
		
		if(clr.equals("BLACK"))
		{
			kingIcon=new ImageIcon(imagePath+"blackKing.png");
		}
		else
			kingIcon=new ImageIcon(imagePath+"whiteKing.png");
		
		kingImage=kingIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return kingImage;
	}
	
	public String toString()
	{
		return "KING";
	}
}
