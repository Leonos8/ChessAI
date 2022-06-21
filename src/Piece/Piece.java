package Piece;

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
	
	public String getColor()
	{
		return color;
	}
}
