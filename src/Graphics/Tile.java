package Graphics;

import Piece.EmptyTile;
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
	
	public Tile(int col, int row, Tile tile)
	{
		this.col=col;
		this.row=row;
		this.piece=piece;
	}
	
	public boolean containsPiece()
	{
		if(piece!=null && !(piece.getPiece() instanceof EmptyTile))
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
	
	public void setPiece(Piece piece)
	{
		this.piece=piece;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public static String positionToString(int col, int row)
	{
		String position="";
		
		if(col==0)
		{
			position="a";
		}
		else if(col==1)
		{
			position="b";
		}
		else if(col==2)
		{
			position="c";
		}
		else if(col==3)
		{
			position="d";
		}
		else if(col==4)
		{
			position="e";
		}
		else if(col==5)
		{
			position="f";
		}
		else if(col==6)
		{
			position="g";
		}
		else if(col==7)
		{
			position="h";
		}
		
		if(row==0)
		{
			position+="8";
		}
		else if(row==1)
		{
			position+="7";
		}
		else if(row==2)
		{
			position+="6";
		}
		else if(row==3)
		{
			position+="5";
		}
		else if(row==4)
		{
			position+="4";
		}
		else if(row==5)
		{
			position+="3";
		}
		else if(row==6)
		{
			position+="2";
		}
		else if(row==7)
		{
			position+="1";
		}
		
		return position;
	}
	
	public String toString()
	{
		return row+", "+col+", "+ piece.getPieceType()+", "+piece.getColor();
	}
}
