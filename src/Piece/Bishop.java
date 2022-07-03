package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;

public class Bishop 
{
	static ImageIcon bishopIcon;
	
	static Image bishopImage;
	
	int startingCol;
	int startingRow;
	
	public Bishop(int col, int row)
	{
		this.startingCol=col;
		this.startingRow=row;
	}
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
	
	public static boolean isLegalMove(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(Math.abs(curCol-newCol)==Math.abs(curRow-newRow))
		{
			if(!isObstructed(tile ,curCol, curRow, newCol, newRow))
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
	
	public static boolean isObstructed(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow)
	{
		int dif=0;
		
		boolean obstruction=false;
		
		dif=Math.abs(curCol-newCol);
		
		for(int i=1; i<dif; i++)
		{
			if(newRow>curRow)
			{
				if(newCol>curCol)
				{
					if(tile[curCol+i][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
				if(newCol<curCol)
				{
					if(tile[curCol-i][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
			}
			
			if(newRow<curRow)
			{
				if(newCol<curCol)
				{
					if(tile[curCol-i][curRow-i].containsPiece())
					{
						obstruction=true;
					}
				}
				if(newCol>curCol)
				{
					if(tile[curCol+i][curRow-i].containsPiece())
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
