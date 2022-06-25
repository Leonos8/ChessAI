package Piece;

import Graphics.Tile;

public class EmptyTile 
{
	public EmptyTile()
	{
		
	}
	
	public static void createEmptyTile(Tile[][] tiles, int c, int r)
	{
		tiles[c][r]=new Tile(c, r, new Piece(new EmptyTile(), "NEUTRAL"));
	}
	
	public String toString()
	{
		return "EMPTY";
	}
}
