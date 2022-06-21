package Graphics;

import Piece.Piece;

public class Tile 
{	
	int col;
	int row;
	
	Piece piece;
	
	public Tile(int row, int col, Piece piece)
	{
		this.row=row;
		this.col=col;
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
