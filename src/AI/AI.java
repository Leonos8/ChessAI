package AI;

import java.util.ArrayList;

import Graphics.Board;
import Graphics.Tile;
import Piece.Move;
import Piece.Piece;
import Piece.Piece.Color;

public class AI extends Thread
{
	Thread AIThread;
	
	boolean gameRunning=true;
	
	Board board;
	
	public void setBoard(Board board)
	{
		this.board=board;
	}
	
	@Override
	public void run()
	{
		System.out.println("AI Running");
		
		while(gameRunning)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException ex) 
			{
				ex.printStackTrace();
			}
			
			
		}
	}
	
	public Move findNextMove(Tile[][] tile, ArrayList<Piece> pob)
	{
		//ArrayList<>
		for(int i=0; i<pob.size(); i++)
		{
			if(pob.get(i).getColor().equals(Piece.Color.Black))
			{
				for(int col=0; col<8; col++)
				{
					for(int row=0; row<8; row++)
					{
						if(pob.get(i).isLegalMove(tile, pob.get(i).getCol(), pob.get(i).getRow(), col, row, 
								Piece.Color.Black))
						{
							Move.movePiece(tile, pob.get(i).getCol(), pob.get(i).getRow(), col, row);	
						}
					}
				}
			}
		}
		
		return null;//new Move();
	}
}
