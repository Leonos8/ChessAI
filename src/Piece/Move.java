package Piece;

import Graphics.Board;
import Graphics.Stopwatch;
import Graphics.Tile;
import Piece.Piece.Color;

public class Move 
{
	Piece piece;
	
	int col;
	int row;
	
	public Move(Piece piece, int col, int row)
	{
		this.piece=piece;
		
		this.col=col;
		this.row=row;
	}
	
	public int getCol()
	{
		return col;
	}
	
	public int getRow()
	{
		return row;
	}
	
	public Piece getPiece()
	{
		return piece;
	}
	
	public static void movePiece(Tile[][] tile, int curCol, int curRow, int newCol, int newRow)
	{
		System.out.println(Board.getTurn());
		//TODO figure out why game runs an infinite loop in some moves, and why when 
		//AI can attack a piece, it moves two turns
		
		Piece piece=tile[curCol][curRow].getPiece();

		if(!piece.getMoved())
		{	
			piece.setMoved(true);
		}
		tile[newCol][newRow].setPiece(piece);
		tile[newCol][newRow].getPiece().setPosition(newCol, newRow);
			
		EmptyTile.createEmptyTile(tile, curCol, curRow);
		
		if(newRow==0)
		{
			if(piece instanceof Pawn)
			{
				if(piece.getColor().equals(Color.White))
				{
					((Pawn)piece).pawnPromotion(tile, newCol, newRow);
				}
			}
		}
		
		if(newRow==7)
		{
			if(piece instanceof Pawn)
			{
				if(piece.getColor().equals(Color.Black))
				{
					((Pawn)piece).pawnPromotion(tile, newCol, newRow);
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
	
	/*public String moveToString(Tile[][] tile, int curCol, int curRow, int newCol, int newRow,
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
	}*/
}
