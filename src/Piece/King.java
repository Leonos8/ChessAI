package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;

public class King 
{
	static ImageIcon kingIcon;
	
	static Image kingImage;
	
	int startingCol;
	int startingRow;
	
	public King(int col, int row)
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
		if((newCol==curCol-1 && newRow==curRow) 
				|| (newCol==curCol+1 && newRow==curRow)
				|| (newCol==curCol && newRow==curRow-1) 
				|| (newCol==curCol && newRow==curRow+1)
				|| (Math.abs(curCol-newCol)==Math.abs(curRow-newRow) 
				&& Math.abs(curCol-newCol)==1))
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
		if(isCastling(tile, curCol, curRow, newCol, newRow))
		{
			return true;
		}
	
		return false;
	}
	
	public static boolean isCastling(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow)
	{
		boolean canCastle=false;
		
		if(newCol>curCol && newCol==curCol+2)
		{
			if(!tile[curCol+1][curRow].containsPiece() 
					&& !tile[curCol+2][curRow].containsPiece()
					&& tile[curCol+3][curRow].getPiece().getPiece() instanceof Rook
					&& !tile[curCol][curRow].getPiece().getMoved()
					&& !tile[curCol+3][curRow].getPiece().getMoved())
			{
				Piece.Move(tile, 7, curRow, 5, newRow, false);
				canCastle=true;
			}
		}
		
		if(newCol<curCol && newCol==curCol-2)
		{
			System.out.println(tile[curCol+1][curRow].getPiece());
			if(!tile[curCol-1][curRow].containsPiece() 
					&& !tile[curCol-2][curRow].containsPiece()
					&& !tile[curCol-3][curRow].containsPiece()
					&& tile[curCol-4][curRow].getPiece().getPiece() instanceof Rook
					&& !tile[curCol][curRow].getPiece().getMoved()
					&& !tile[curCol-4][curRow].getPiece().getMoved())
			{
				Piece.Move(tile, 0, curRow, 3, newRow, false);
				canCastle=true;
			}
		}
		
		return canCastle;
	}
	
	public static void setImageIcon(String clr)
	{
		File currDir=new File(".");
		
		String path=currDir.getAbsolutePath();
		path=path.substring(0, path.length()-2);	
		
		String imagePath=path+File.separator+"PieceSprites"+File.separator;
		
		if(clr.equals("BLACK"))
		{
			kingIcon=new ImageIcon(imagePath+"blackKing.png");
		}
		else
			kingIcon=new ImageIcon(imagePath+"whiteKing.png");
		
		kingImage=kingIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return kingImage;
	}
	
	public String toString()
	{
		return "KING";
	}
}
