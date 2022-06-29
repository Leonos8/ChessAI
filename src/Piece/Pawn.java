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
	
	//static boolean enPassant=false;
	
	public Pawn()
	{
		
	}
	
	public static boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color) //TODO program en passant
	{
		if(color.equals("WHITE"))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				if(!tile[curCol][curRow].getPiece().getMoved())
				{
					if(newCol==curCol && newRow==curRow-2)
					{
						return true;
					}
				}
					
				if(newCol==curCol && newRow==curRow-1)
				{
					return true;
				}
			}
				
			if(tile[newCol][newRow].containsPiece() 
					&& !(tile[newCol][newRow].getPiece().getColor().equals(color)))
			{
				if(newRow==curRow-1 && (newCol==curCol-1 || newCol==curCol+1))
				{
					if(tile[newCol][newRow].getPiece().getPiece() instanceof King)
					{
						Board.captureKing(tile[newCol][newRow].getPiece());
					}
					
					Board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}
		
		if(color.equals("BLACK"))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				if(!tile[curCol][curRow].getPiece().getMoved())
				{
					if(newCol==curCol && newRow==curRow+2)
					{
						return true;
					}
				}
					
				if(newCol==curCol && newRow==curRow+1)
				{
					return true;
				}
			}
				
			if(tile[newCol][newRow].containsPiece() 
					&& !(tile[newCol][newRow].getPiece().getColor().equals(color)))
			{
				if(newRow==curRow+1 && (newCol==curCol-1 || newCol==curCol+1))
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
