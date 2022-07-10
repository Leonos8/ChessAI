package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;
import Piece.Piece.Color;
import Piece.Piece.Type;

public class King
extends Piece
{
	public static final ImageIcon WHITE_ICON=new ImageIcon(imagePath+"whiteKing.png");
	public static final ImageIcon BLACK_ICON=new ImageIcon(imagePath+"blackKing.png");
	public static final Image WHITE_IMAGE=WHITE_ICON.getImage();
	public static final Image BLACK_IMAGE=BLACK_ICON.getImage();
	
	int startingCol;
	int startingRow;
	
	int col;
	int row;
	
	Board board;
	
	public King(Board board, Piece.Color color, int col, int row)
	{
		this.board=board;
		this.color=color;
		this.startingCol=col;
		this.startingRow=row;
		this.pieceType=Type.King;
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
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
	
	public static boolean isCastling(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow)
	{
		boolean canCastle=false;
		
		if(newCol>curCol && newCol==curCol+2)
		{
			if(!tile[curCol+1][curRow].containsPiece() 
					&& !tile[curCol+2][curRow].containsPiece()
					&& tile[curCol+3][curRow].getPiece().getPiece() instanceof Rook
					&& !tile[curCol][curRow].getPiece().getMoved()
					&& !tile[curCol+3][curRow].getPiece().getMoved())
			{
				Move.movePiece(tile, 7, curRow, 5, newRow);
				canCastle=true;
			}
		}
		
		if(newCol<curCol && newCol==curCol-2)
		{
			System.out.println(tile[curCol+1][curRow].getPiece());
			if(!tile[curCol-1][curRow].containsPiece() 
					&& !tile[curCol-2][curRow].containsPiece()
					&& !tile[curCol-3][curRow].containsPiece()
					&& tile[curCol-4][curRow].getPiece().getPiece() instanceof Rook
					&& !tile[curCol][curRow].getPiece().getMoved()
					&& !tile[curCol-4][curRow].getPiece().getMoved())
			{
				Move.movePiece(tile, 0, curRow, 3, newRow);
				canCastle=true;
			}
		}
		
		return canCastle;
	}
	
	public boolean isLegalMove(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow, Color color)
	{
		Piece piece=tile[newCol][newRow].getPiece();
		
		if((newCol==curCol-1 && newRow==curRow) 
				|| (newCol==curCol+1 && newRow==curRow)
				|| (newCol==curCol && newRow==curRow-1) 
				|| (newCol==curCol && newRow==curRow+1)
				|| (Math.abs(curCol-newCol)==Math.abs(curRow-newRow) 
				&& Math.abs(curCol-newCol)==1))
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
		if(isCastling(tile, curCol, curRow, newCol, newRow))
		{
			return true;
		}
	
		return false;
	}
	
	public String toString()
	{
		return "KING";
	}
}
