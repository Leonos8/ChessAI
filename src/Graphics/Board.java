package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Piece.emptyTile;

public class Board implements MouseListener
{
	JFrame frame;
	
	JPanel board;
	
	Tile[][] tiles=new Tile[8][8];
	
	int[] selectedTile=new int[] {-1, -1};
	
	int tileX=80;
	int tileY=80;
	int startingX;
	int startingY;
	int endingX;
	int endingY;
	
	public Board()
	{
		frame=new JFrame("Chess");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//TODO make when screen minimized, it takes up the size of the board at the top left corner
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		startingX=(frame.getWidth()/2)-360;
		startingY=(frame.getHeight()/2)-360;
		endingX=startingX+640;
		endingY=startingY+640;
		
		board=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				int x=startingX;
				int y=startingY;
				
				for(int r=0; r<8; r++)
				{
					for(int c=0; c<8; c++)
					{
						if(r%2==c%2)
						{
							g.setColor(Color.white);
						}
						else
						{
							g.setColor(new Color(187, 142, 81));
						}
						g.fillRect(x, y, tileX, tileY);
						
						//////////////////////////////////////////////////////////////////////

						
						
						
						//////////////////////////////////////////////////////////////////////

						
						
						x+=tileX;
					}
					x=startingX;
					y+=tileY;
				}
				
				drawPieces(g);
				
				if(selectedTile[0]!=-1 && selectedTile[1]!=-1)
				{
					highlightTile(g);
				}
			}
		};
		board.setBackground(Color.lightGray);
		board.setLayout(null);
		board.setVisible(true);
		board.addMouseListener(this);
		frame.getContentPane().add(board);
		
		setupBoard();
		
		createLabels();
	}
	
	public void drawPieces(Graphics g)
	{
		Graphics2D g2d=(Graphics2D) g;
		
		for(int r=0; r<8; r++)
		{
			for(int c=0; c<8; c++)
			{
				g2d.drawImage(tiles[c][r].getPiece().getPieceImage(), startingX-20+(c*80), 
						startingY-20+(r*80), board);
			}
		}
	}
	
	public void highlightTile(Graphics g)
	{
		Color highlight=new Color(1, 1, 0, .3F); //.3F is alpha to make it more translucent
		g.setColor(highlight);
		
		g.fillRect(startingX+(selectedTile[0]*80), startingY+(selectedTile[1]*80), 80, 80);
	}
	
	public void setupBoard()
	{
		for(int r=0; r<8; r++)
		{
			for(int c=0; c<8; c++)
			{
				if(c==1)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Pawn(), "BLACK"));
				}
				else if(c==6)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Pawn(), "WHITE"));
				}
				else if(c==0 && (r==0 || r==7))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Rook(), "BLACK"));
				}
				else if(c==0 && (r==1 || r==6))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Knight(), "BLACK"));
				}
				else if(c==0 && (r==2 || r==5))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Bishop(), "BLACK"));
				}
				else if(c==0 && r==3)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Queen(), "BLACK"));
				}
				else if(c==0 && r==4)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new King(), "BLACK"));
				}	
				else if(c==7 && (r==0 || r==7))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Rook(), "WHITE"));
				}
				else if(c==7 && (r==1 || r==6))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Knight(), "WHITE"));
				}
				else if(c==7 && (r==2 || r==5))
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Bishop(), "WHITE"));
				}
				else if(c==7 && r==3)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new Queen(), "WHITE"));
				}
				else if(c==7 && r==4)
				{
					tiles[r][c]=new Tile(r, c, new Piece(new King(), "WHITE"));
				}
				else
				{
					tiles[r][c]=new Tile(r, c, new Piece(new emptyTile(), "NEUTRAL"));
				}
			}
		}
	}
	
	public void createLabels()
	{
		JLabel[] letterLabels=new JLabel[8];
		JLabel[] numberLabels=new JLabel[8];
		
		for(int i=0; i<letterLabels.length; i++) //For columns
		{
			char letterC=(char)(65+i);
			String letter=""+letterC;
			
			letterLabels[i]=new JLabel();
			letterLabels[i].setFont(new Font("ARIAL", Font.BOLD, 24));
			letterLabels[i].setText(letter);
			letterLabels[i].setBounds((startingX+28)+(80*i), startingY+610, 100, 100); //startingX+32
			letterLabels[i].setVisible(true);
			board.add(letterLabels[i]);
		}
		
		for(int i=0; i<letterLabels.length; i++) //For rows
		{
			numberLabels[i]=new JLabel();
			numberLabels[i].setFont(new Font("ARIAL", Font.BOLD, 24));
			numberLabels[i].setText(String.valueOf(i+1));
			numberLabels[i].setBounds(startingX-25, (startingY+550)-(80*i), 100, 100); //startingX+32
			numberLabels[i].setVisible(true);
			board.add(numberLabels[i]);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		int col;
		int row;
		if(e.getX()>=startingX && e.getX()<=startingX+640 && e.getY()>=startingY 
				&& e.getY()<=startingY+640)
		{
			col=(e.getX()-startingX)/80;
			row=(e.getY()-startingY)/80;
			
			//System.out.println(col+", "+row); //Should be outputted as rowxcol (aka c4)
			//System.out.println(tiles[col][row].toString());
			
			if(selectedTile[0]==-1 && selectedTile[1]==-1)
			{
				//System.out.println(tiles[col][row].toString());
				
				if(!tiles[col][row].getPieceString().equals("EMPTY"))
				{
					selectedTile[0]=col;
					selectedTile[1]=row;
				}
			}
			else
			{
				//System.out.println(tiles[col][row].getPiece().move());
				//legalMove();
				/*
				 * boolean isValidMove to determine if the move is valid
				 * then send it through a method to move that piece if the move is valid
				 * isValidMove is a method on every piece
				 * going to need location input and color input since pawn can only move in one dir
				 */
				selectedTile[0]=-1;
				selectedTile[1]=-1;
			}
		}
		
		board.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		
	}
}
