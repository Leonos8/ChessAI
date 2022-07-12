package Piece;

import Graphics.Board;
import Graphics.Tile;
import Piece.Piece.Type;

public class EmptyTile extends Piece
{
	int startingCol;
	int startingRow;
	
	final int pointValue=0;
	
	int col;
	int row;
	
	static Board board;

	public EmptyTile(Board board, Piece.Color color, int col, int row)
	{
		this.board=board;
		this.color=color;
		this.startingCol=col;
		this.startingRow=row;
		this.pieceType=Type.Empty;

	}
	
	public static void createEmptyTile(Tile[][] tiles, int c, int r) //TODO
	{
		tiles[c][r]=new Tile(c, r, new EmptyTile(board, Piece.Color.Neutral, c, r));
	}
	
	@Override
	public void setPosition(int col, int row) 
	{
		this.col=col;
		this.row=row;
	}

	@Override
	public int getCol() 
	{
		return col;
	}

	@Override
	public int getRow() 
	{
		return row;
	}
	
	public int getPoints()
	{
		return pointValue;
	}

	@Override
	public boolean isLegalMove(Tile[][] tile, int curCol, int curRow, int newCol, int newRow, Color color)
	{
		return false;
	}
	
	public String toString()
	{
		return "EMPTY";
	}
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
}
