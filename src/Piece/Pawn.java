package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

public class Pawn
{
	static ImageIcon pawnIcon;
	
	static Image pawnImage;
	
	public Pawn()
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
			pawnIcon=new ImageIcon(imagePath+"blackPawn.png");
		}
		else
			pawnIcon=new ImageIcon(imagePath+"whitePawn.png");
		
		pawnImage=pawnIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return pawnImage;
	}
	
	@Override
	public String toString()
	{
		return "PAWN";
	}
}
