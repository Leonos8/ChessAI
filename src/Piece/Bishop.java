package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Tile;

public class Bishop 
{
	static ImageIcon bishopIcon;
	
	static Image bishopImage;
	
	public Bishop()
	{
		
	}
	
	public static boolean isLegalMove(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		int s1=curCol-newCol;
		int s2=curRow-newRow;
		if(color.equals("WHITE"))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				
				if(!checkDiagonals(tile, curCol, curRow,  //Might remove once able to move bak
						newCol, newRow, color))
				{
					
					if(curCol-newCol==curRow-newRow)
					{
						return true;
					}
					//return true;
				}
			}
		}
		
		return false;
	}
	
	public static boolean checkDiagonals(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(curCol>newCol)
		{
			
		}
		
		return true;
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
