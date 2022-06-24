package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Queen 
{
	static ImageIcon queenIcon;
	
	static Image queenImage;
	
	public Queen()
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
			queenIcon=new ImageIcon(imagePath+"blackQueen.png");
		}
		else
			queenIcon=new ImageIcon(imagePath+"whiteQueen.png");
		
		queenImage=queenIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return queenImage;
	}
	
	public String toString()
	{
		return "QUEEN";
	}
}
