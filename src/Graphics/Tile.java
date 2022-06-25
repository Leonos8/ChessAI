package Graphics;

import Piece.Piece;

public class Tile 
{	
	int col;
	int row;
	
	Piece piece;
	
	public Tile(int col, int row, Piece piece)
	{
		this.col=col;
		this.row=row;
		this.piece=piece;
	}
	
	public boolean containsPiece()
	{
		if(piece!=null)
		{
			return true;
		}
		else
			return false;
	}
	
	public String getPieceString()
	{
		return piece.toString();
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public String toString()
	{
		return row+", "+col+", "+ piece.getPieceType()+", "+piece.getColor();
	}
}
