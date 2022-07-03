package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;

public class Rook 
{
	static ImageIcon rookIcon;
	
	static Image rookImage;
	
	int startingCol;
	int startingRow;
	
	public Rook(int col, int row)
	{
		this.startingCol=col;
		this.startingRow=row;
	}
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
	
	public static boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(curCol==newCol || curRow==newRow)
		{
			if(!isObstructed(tile, curCol, curRow, newCol, newRow))
			{
				if(!tile[newCol][newRow].containsPiece())
				{
					return true;
				}
				
				if(tile[newCol][newRow].containsPiece() 
						&& !(tile[newCol][newRow].getPiece().getColor().equals(color)))
				{
					if(tile[newCol][newRow].getPiece().getPiece() instanceof King)
					{
						Board.captureKing(tile[newCol][newRow].getPiece());
					}
						
					Board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}
		
		return false;
	}
	
	public static boolean isObstructed(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow)
	{
		int dif=0;
		
		boolean obstruction=false;
		
		if(curCol==newCol)
		{
			dif=Math.abs(curRow-newRow);
			
			for(int i=1; i<dif; i++)
			{
				if(curRow>newRow)
				{
					if(tile[curCol][curRow-i].containsPiece())
					{
						obstruction=true;
					}
				}
				else if(curRow<newRow)
				{
					if(tile[curCol][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
			}
		}
		
		if(curRow==newRow)
		{
			dif=Math.abs(curCol-newCol);
			
			for(int i=1; i<dif; i++)
			{
				if(curCol>newCol)
				{
					if(tile[curCol-i][curRow].containsPiece())
					{
						obstruction=true;
					}
				}
				else if(curCol<newCol)
				{
					if(tile[curCol+i][curRow].containsPiece())
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
