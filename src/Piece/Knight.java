package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;

public class Knight 
{
	static ImageIcon knightIcon;
	
	static Image knightImage;
	
	int startingCol;
	int startingRow;
	
	public Knight(int col, int row)
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
		if(((newRow==curRow+2 || newRow==curRow-2) 
				&& (newCol==curCol+1 || newCol==curCol-1))
				|| ((newRow==curRow+1 || newRow==curRow-1) 
				&& (newCol==curCol+2 || newCol==curCol-2)))
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
		
		return false;
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
