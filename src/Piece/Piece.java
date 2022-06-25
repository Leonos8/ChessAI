package Piece;

import java.awt.Image;

import Graphics.Board;
import Graphics.Tile;

public class Piece
{
	Object pieceType;
	
	String color;
	
	public Piece(Object pieceType, String color)
	{
		this.pieceType=pieceType;
		this.color=color;
	}
	
	public void setType(String type)
	{
		this.pieceType=type;
	}
	
	public String getPieceType()
	{
		return pieceType.toString();
	}
	
	public Object getPiece()
	{
		return pieceType;
	}
	
	public Image getPieceImage()
	{
		if(pieceType instanceof Pawn)
		{
			return Pawn.getImage(color);
		}
		else if(pieceType instanceof Rook)
		{
			return Rook.getImage(color);
		}
		else if(pieceType instanceof Knight)
		{
			return Knight.getImage(color);
		}
		else if(pieceType instanceof Bishop)
		{
			return Bishop.getImage(color);
		}
		else if(pieceType instanceof Queen)
		{
			return Queen.getImage(color);
		}
		else if(pieceType instanceof King)
		{
			return King.getImage(color);
		}
		else
			return null;
	}
	
	public static void Move(Tile[][] tile, int curCol, int curRow, int newCol, int newRow)
	{
		System.out.println(curCol+", "+newCol+", "+curRow+", "+newRow);
		if(curCol!=newCol || curRow!=newRow)
		{
			tile[newCol][newRow]=new Tile(newCol, newRow, 
					new Piece(tile[curCol][curRow].getPiece(), 
							tile[curCol][curRow].getPiece().getColor()));
			
			EmptyTile.createEmptyTile(tile, curCol, curRow);
		}
		
		Board.board.repaint();
	}
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return pieceType.toString();
	}
}
