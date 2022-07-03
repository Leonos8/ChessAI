package Piece;

import java.awt.Graphics;
import java.awt.Image;

import Graphics.Board;
import Graphics.Stopwatch;
import Graphics.Tile;

public class Piece
{
	 Object pieceType;
	
	String color;
	
	boolean moved=false;
	
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
		else if(tile[curCol][curRow].getPiece().getPiece() instanceof Bishop)
		{
			return Bishop.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		else if(tile[curCol][curRow].getPiece().getPiece() instanceof Queen)
		{
			return Queen.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		else if(tile[curCol][curRow].getPiece().getPiece() instanceof King)
		{
			return King.isLegalMove(tile, curCol, curRow, newCol, newRow, color);
		}
		
		return false;
	}
	
	public static void Move(Tile[][] tile, int curCol, int curRow, int newCol, int newRow,
			boolean capturedPiece)
	{
		System.out.println(capturedPiece);
		if(!tile[curCol][curRow].getPiece().getMoved())
		{	
			tile[curCol][curRow].getPiece().setMoved(true);
		}
		tile[newCol][newRow].setPiece(tile[curCol][curRow].getPiece());
			
		EmptyTile.createEmptyTile(tile, curCol, curRow);
		
		if(newRow==0)
		{
			if(tile[newCol][newRow].getPiece().getPiece() instanceof Pawn)
			{
				if(tile[newCol][newRow].getPiece().getColor().equals("WHITE"))
				{
					Pawn.pawnPromotion(tile, newCol, newRow);
				}
			}
		}
		
		if(newRow==7)
		{
			if(tile[newCol][newRow].getPiece().getPiece() instanceof Pawn)
			{
				if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
				{
					Pawn.pawnPromotion(tile, newCol, newRow);
				}
			}
		}
		
		
		
		if(Board.getTurn()%2==1)
		{
			Stopwatch.resumeClock("p2");
			Stopwatch.stopClock("p1");
		}
		else if(Board.getTurn()%2==0)
		{
			Stopwatch.resumeClock("p1");
			Stopwatch.stopClock("p2");
		}
		
		Board.incTurn();
		
		Board.board.repaint();
	}
	
	public String moveToString(Tile[][] tile, int curCol, int curRow, int newCol, int newRow,
			boolean capturedPiece) //TODO will get back to
	{
		String moveString="";
		
		if(!capturedPiece)
		{
			if(tile[curCol][curRow].getPiece().getPiece() instanceof Pawn)
			{
				if(tile[curCol][curRow].getPiece().getColor().equals("WHITE"))
				{
					if(newRow==0)
					{
						//PROMOTE labeled as a8=Q for pawn in a8 to promote to queen
					}
				}
				else if(tile[curCol][curRow].getPiece().getColor().equals("BLACK"))
				{
					if(newRow==7)
					{
						//PROMOTE labeled as a8=Q for pawn in a8 to promote to queen
					}
				}
				
				if(moveString.equals(""))
				{
					moveString=Tile.positionToString(newCol, newRow);
				}
			}
		}
		
		return moveString;
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
	
	public void setMoved(boolean moved)
	{
		this.moved=moved;
	}
	
	public boolean getMoved()
	{
		return moved;
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
