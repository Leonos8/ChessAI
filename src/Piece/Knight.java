package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;
import Piece.Piece.Color;
import Piece.Piece.Type;

public class Knight
       extends Piece
{
	public static final ImageIcon WHITE_ICON=new ImageIcon(imagePath+"whiteKnight.png");
	public static final ImageIcon BLACK_ICON=new ImageIcon(imagePath+"blackKnight.png");
	
	public static final Image WHITE_IMAGE=WHITE_ICON.getImage();
	public static final Image BLACK_IMAGE=BLACK_ICON.getImage();

	int startingCol;
	int startingRow;
	
	final int pointValue=3;
	
	int col;
	int row;
	
	Board board;
	
	public Knight(Board board, Piece.Color color, int col, int row)
	{
		this.board=board;
		this.color=color;
		this.startingCol=col;
		this.startingRow=row;
		this.pieceType=Type.Knight;
		this.icon=(color==Color.White ? WHITE_ICON : BLACK_ICON);
		this.image=this.icon.getImage();
		
		this.setPosition(col, row);
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
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
	
	public boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, int newCol, int newRow, Color color)
	{
		Piece piece=tile[newCol][newRow].getPiece();
		if(((newRow==curRow+2 || newRow==curRow-2) 
				&& (newCol==curCol+1 || newCol==curCol-1))
				|| ((newRow==curRow+1 || newRow==curRow-1) 
				&& (newCol==curCol+2 || newCol==curCol-2)))
			{
			if(!tile[newCol][newRow].containsPiece())
			{
				return true;
			}

			if(tile[newCol][newRow].containsPiece() 
					&& !(piece.getColor().equals(color)))
			{
				if(piece.getPiece() instanceof King)
				{
						Board.captureKing(piece);
				}
					
				board.capturePiece(tile, curCol, curRow, newCol, newRow);
			}
		}
		
		return false;
	}
	
	public String toString()
	{
		return "KNIGHT";
	}
}
