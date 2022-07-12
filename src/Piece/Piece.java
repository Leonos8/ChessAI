package Piece;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;

import Graphics.Board;
import Graphics.Stopwatch;
import Graphics.Tile;
import Piece.Piece.Color;

public abstract class Piece
{
	public static enum Color
	  {
		Neutral,
		White,
		Black
	  };

    public static enum Type
		  {
    		Empty,
		    Pawn,
			Rook,
			Knight,
			Bishop,
			Queen,
			King
		  };

    public static final File currDir=new File(".");
	public static final String absolutePath=currDir.getAbsolutePath();
	public static final String path=absolutePath.substring(0, absolutePath.length()-2);	
	public static final String imagePath=path+File.separator+"PieceSprites"+File.separator;

	public static final java.awt.Color WHITE=java.awt.Color.white;
	public static final java.awt.Color BLACK=java.awt.Color.black;

	Color color;
	Type pieceType;
	ImageIcon icon;
	Image image;
		
	boolean moved=false;
	
	static int currentCol;
	static int currentRow;
	
	public Color getColor()
	{
		return color;
	}
	
    public Image getImage()
    {
    	return image;
    }
	
	public Object getPiece()
	{
		return pieceType;
	}
		
	public String getPieceType()
	{
		return pieceType.toString();
	}
	
	public abstract int getPoints();
	
	public abstract boolean isLegalMove(Tile[][] tile ,
            int curCol,
            int curRow, 
            int newCol,
            int newRow,
            Color color);
	
	public void setMoved(boolean moved)
	{
		this.moved=moved;
	}
	
	public boolean getMoved()
	{
		return moved;
	}
	
	public abstract void setPosition(int col, int row);
	
	public abstract int getCol();
	
	public abstract int getRow();
	
	public abstract String getStartingPosition();
	
	public void setType(Type type)
	{
		this.pieceType=type;
	}
	
	public String toString()
	{
		return pieceType.toString();
	}
}
