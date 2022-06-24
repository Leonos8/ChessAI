package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Rook 
{
	static ImageIcon rookIcon;
	
	static Image rookImage;
	
	public Rook()
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
			rookIcon=new ImageIcon(imagePath+"blackRook.png");
		}
		else
			rookIcon=new ImageIcon(imagePath+"whiteRook.png");
		
		rookImage=rookIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return rookImage;
	}
	
	public String toString()
	{
		return "ROOK";
	}
}
