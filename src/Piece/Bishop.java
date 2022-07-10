package Piece;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Tile;
import Piece.Piece.Color;
import Piece.Piece.Type;

public class Bishop
       extends Piece
{
	public static final ImageIcon WHITE_ICON=new ImageIcon(imagePath+"whiteBishop.png");
	public static final ImageIcon BLACK_ICON=new ImageIcon(imagePath+"blackBishop.png");
	
	public static final Image WHITE_IMAGE=WHITE_ICON.getImage();
	public static final Image BLACK_IMAGE=BLACK_ICON.getImage();
	
	int startingCol;
	int startingRow;
	
	int col;
	int row;
	
	Board board;
	
	public Bishop(Board board, Piece.Color color, int col, int row)
	{
		this.board=board;
		this.color=color;
		this.startingCol=col;
		this.startingRow=row;
		this.pieceType=Type.Bishop;
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
	
	public boolean isLegalMove(Tile[][] tile, int curCol, int curRow, int newCol, int newRow, Color color)
	{
		Piece piece=tile[newCol][newRow].getPiece();
		
		if(Math.abs(curCol-newCol)==Math.abs(curRow-newRow))
		{
			if(!isObstructed(tile ,curCol, curRow, newCol, newRow))
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
		}
		
		return false;
	}
	
	public static boolean isObstructed(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow)
	{
		int dif=0;
		
		boolean obstruction=false;
		
		dif=Math.abs(curCol-newCol);
		
		for(int i=1; i<dif; i++)
		{
			if(newRow>curRow)
			{
				if(newCol>curCol)
				{
					if(tile[curCol+i][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
				if(newCol<curCol)
				{
					if(tile[curCol-i][curRow+i].containsPiece())
					{
						obstruction=true;
					}
				}
			}
			
			if(newRow<curRow)
			{
				if(newCol<curCol)
				{
					if(tile[curCol-i][curRow-i].containsPiece())
					{
						obstruction=true;
					}
				}
				if(newCol>curCol)
				{
					if(tile[curCol+i][curRow-i].containsPiece())
					{
						obstruction=true;
					}
				}
			}
		}
		
		return obstruction;
	}
	
	public String toString()
	{
		return "BISHOP";
	}
}
