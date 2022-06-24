package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Bishop 
{
	static ImageIcon bishopIcon;
	
	static Image bishopImage;
	
	public Bishop()
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
			bishopIcon=new ImageIcon(imagePath+"blackBishop.png");
		}
		else
			bishopIcon=new ImageIcon(imagePath+"whiteBishop.png");
		
		bishopImage=bishopIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return bishopImage;
	}
	
	public String toString()
	{
		return "BISHOP";
	}
}
