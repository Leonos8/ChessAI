package Piece;

import java.awt.Image;

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
	
	public String getColor()
	{
		return color;
	}
	
	public String toString()
	{
		return pieceType.toString();
	}
}
