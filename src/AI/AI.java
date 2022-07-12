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
	
	public void findNextMove(Tile[][] tile, ArrayList<Piece> pob)
	{
		ArrayList<Move> aiMoves=new ArrayList<Move>();
		boolean b=true;
		
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
							aiMoves.add(new Move(pob.get(i), col, row));
							
							/*if(b)
							{
								//Move.movePiece(tile, pob.get(i).getCol(), pob.get(i).getRow(), col, row);
								b=false;
							}*/
						}
					}
				}
			}
		}
		
		ArrayList<Integer> index=new ArrayList<>();
		int max=0;
		
		for(int i=0; i<aiMoves.size(); i++)
		{
			if(tile[aiMoves.get(i).getCol()][aiMoves.get(i).getRow()].getPiece().getPoints()>max)
			{
				max=aiMoves.get(i).getPiece().getPoints();
			}
		}
		
		for(int i=0; i<aiMoves.size(); i++)
		{
			if(tile[aiMoves.get(i).getCol()][aiMoves.get(i).getRow()].getPiece().getPoints()==max)
			{
				index.add(i);
			}
		}
		
		int rand=(int)(Math.random()*index.size());
		
		aiMoves.get(index.get(rand));
		
		if(tile[aiMoves.get(index.get(rand)).getCol()]
				[aiMoves.get(index.get(rand)).getRow()].containsPiece())
		{
			board.capturePiece(tile, aiMoves.get(index.get(rand)).getPiece().getCol(), 
					aiMoves.get(index.get(rand)).getPiece().getRow(), 
					aiMoves.get(index.get(rand)).getCol(), aiMoves.get(index.get(rand)).getRow());
		}
		else if(!tile[aiMoves.get(index.get(rand)).getCol()]
				[aiMoves.get(index.get(rand)).getRow()].containsPiece())
		{
			Move.movePiece(tile, aiMoves.get(index.get(rand)).getPiece().getCol(), 
				aiMoves.get(index.get(rand)).getPiece().getRow(), 
				aiMoves.get(index.get(rand)).getCol(), aiMoves.get(index.get(rand)).getRow());
		}
		
		
		
		
		for(int i=0; i<aiMoves.size(); i++)
		{
			System.out.println(aiMoves.get(i).getPiece().getPieceType());
		}
		
		
		//return null;//new Move();
	}
}
