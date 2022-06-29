package Piece;

import java.awt.Graphics;
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
	
	public boolean pieceIsLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color)
	{
		if(tile[curCol][curRow].getPiece().getPiece() instanceof Pawn)
		{
			return Pawn.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		else if(tile[curCol][curRow].getPiece().getPiece() instanceof Rook)
		{
			return Rook.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		else if(tile[curCol][curRow].getPiece().getPiece() instanceof Knight)
		{
			return Knight.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		
		return false;
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
		tile[newCol][newRow].setPiece(tile[curCol][curRow].getPiece());
			
		EmptyTile.createEmptyTile(tile, curCol, curRow);
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
