package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Knight 
{
	static ImageIcon knightIcon;
	
	static Image knightImage;
	
	public Knight()
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
			knightIcon=new ImageIcon(imagePath+"blackKnight.png");
		}
		else
			knightIcon=new ImageIcon(imagePath+"whiteKnight.png");
		
		knightImage=knightIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return knightImage;
	}
	
	public String toString()
	{
		return "KNIGHT";
	}
}
