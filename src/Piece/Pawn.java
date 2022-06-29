package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;

public class Pawn
{
	static ImageIcon pawnIcon;
	
	static Image pawnImage;
	
	static boolean firstMove=true;
	
	public Pawn()
	{
		
	}
	
	public static boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(color.equals("WHITE"))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				if(firstMove)
				{
					if(newRow==curRow-2)
					{
						return true;
					}
					
					if(newRow==curRow-1)
					{
						return true;
					}
				}
				
				//if(newRow==curRow-1 && tile[])
				{
					
				}
			}
		}
		
		return true;
		//return false; TODO will be changed once making this piece movable, but making test
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
