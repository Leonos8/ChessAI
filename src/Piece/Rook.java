package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Tile;

public class Rook 
{
	static ImageIcon rookIcon;
	
	static Image rookImage;
	
	public Rook()
	{
		
	}
	
	public static boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(!tile[newCol][newRow].containsPiece())
		{
			if(curCol==newCol || curRow==newRow)
			{
				if(!isObstructed(tile ,curCol, curRow, newCol, newRow, color))
				{
					return true;
				}
			}
		}
		
		if(tile[newCol][newRow].containsPiece())
		{
			
		}
		
		return false;
	}
	
	public static boolean isObstructed(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		int dif=0;
		
		boolean obstruction=false;
		
		if(curCol==newCol)
		{
			dif=newRow-curRow;
			dif=Math.abs(dif);
			
			for(int i=1; i<=dif; i++)
			{
				if(newRow>curRow)
				{
					if(tile[curCol][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
				else if(newRow<curRow)
				{
					if(tile[curCol][curRow-i].containsPiece())
					{
						obstruction=true;
					}
				}
			}
		}
		
		if(curRow==newRow)
		{
			dif=newCol-curCol;
			dif=Math.abs(dif);
			
			for(int i=1; i<=dif; i++)
			{
				if(newCol>curCol)
				{
					if(tile[curCol+i][curRow].containsPiece())
					{
						obstruction=true;
					}
				}
				else if(newCol<curCol)
				{
					if(tile[curCol-i][curRow].containsPiece())
					{
						obstruction=true;
					}
				}
			}
		}
		
		return obstruction;
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
