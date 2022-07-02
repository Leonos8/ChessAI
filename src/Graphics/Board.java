package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Piece.Bishop;
import Piece.EmptyTile;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;

public class Board implements MouseListener
{
	public static JPanel board;
	
	static Tile[][] tiles=new Tile[8][8];
	
	static ArrayList<Piece> capturedPieces=new ArrayList<Piece>();
	
	int[] selectedTile=new int[] {-1, -1};
	
	int tileX=80;
	int tileY=80;
	int startingX;
	int startingY;
	int endingX;
	int endingY;
	
	static int turn=1;
	
	static String player1Name="";
	static String player2Name="";
	static String player1Color="WHITE";
	static String player2Color="BLACK";
	
	JLabel player1Label=new JLabel();
	JLabel player2Label=new JLabel();
	static JLabel player1TimeLabel=new JLabel();;
	static JLabel player2TimeLabel;
	
	//public static Stopwatch s1=new Stopwatch("p1");
	
	public Board()
	{
		startingX=(GUI.frame.getWidth()/2)-360;
		startingY=(GUI.frame.getHeight()/2)-360;
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
						
						//////////////////////////////////////////////////////////////////

						
						
						
						//////////////////////////////////////////////////////////////////

						
						
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
		GUI.frame.getContentPane().add(board);
		
		setupBoard();
		
		createLabels();
		
		//////////////////////////////////////////////////////////////////////
		player1Label.setFont(new Font("ARIAL", Font.BOLD, 24));
		
		if(player1Name==null || player1Name.equals(""))
		{
			player1Label.setText("Player 1:");
		}
		else
			player1Label.setText(getPlayer1Text()+":");
		
		player1Label.setBounds(startingX, endingY+10, 100, 100);
		player1Label.setVisible(true);
		
		board.add(player1Label);
		
		//////////////////////////////////////////////////////////////////////
		player2Label.setFont(new Font("ARIAL", Font.BOLD, 24));
		
		if(player2Name==null || player2Name.equals(""))
		{
			player2Label.setText("Player 2:");
		}
		else
			player2Label.setText(getPlayer2Text()+":");
		
		player2Label.setBounds(endingX-100, endingY+10, 100, 100);
		player2Label.setVisible(true);
		
		board.add(player2Label);
		
		//////////////////////////////////////////////////////////////////////
		
		
		player1TimeLabel.setFont(new Font("ARIAL", Font.BOLD, 24));
		//playerTimeLabel.setText(Stopwatch.getTimeString());
		player1TimeLabel.setText("00:00");
		player1TimeLabel.setBounds(player1Label.getX()+player1Label.getWidth()+5, 
				endingY+10, 100, 100);
		player1TimeLabel.setVisible(true);
		
		//s1.t.start();
		
		board.add(player1TimeLabel);
		
		//////////////////////////////////////////////////////////////////////
		player2TimeLabel=new JLabel();
		
		player2TimeLabel.setFont(new Font("ARIAL", Font.BOLD, 24));
		//playerTimeLabel.setText(Stopwatch.getTimeString());
		player2TimeLabel.setText("00:00");
		player2TimeLabel.setBounds(player2Label.getX()+player2Label.getWidth()+5, 
				endingY+10, 100, 100);
		player2TimeLabel.setVisible(true);
		
		board.add(player2TimeLabel);
	}
	
	public static void updateTime(String player, String time)
	{
		if(player.equals("p1"))
		{
			player1TimeLabel.setText(time);
		}
		else if(player.equals("p2"))
		{
			player2TimeLabel.setText(time);
		}
	}
	
	public void drawPieces(Graphics g)
	{
		Graphics2D g2d=(Graphics2D) g;
		
		for(int c=0; c<8; c++)
		{
			for(int r=0; r<8; r++)
			{
				g2d.drawImage(tiles[c][r].getPiece().getPieceImage(), startingX-20+(c*80), 
						startingY-20+(r*80), board);
			}
		}
	}
	
	public void highlightTile(Graphics g)
	{
		Color highlight=new Color(1, 1, 0, .3F);
		g.setColor(highlight);
		
		g.fillRect(startingX+(selectedTile[0]*80), startingY+(selectedTile[1]*80), 80, 80);
	}
	
	public int getCol(int x)
	{
		return (x-startingX)/80;
	}
	
	public int getRow(int y)
	{
		return (y-startingY)/80;
	}
	
	public void setupBoard()
	{
		for(int c=0; c<8; c++)
		{
			for(int r=0; r<8; r++)
			{
				if(r==1)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Pawn(), "BLACK"));
				}
				else if(r==6)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Pawn(), "WHITE"));
				}
				else if(r==0 && (c==0 || c==7))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Rook(), "BLACK"));
				}
				else if(r==0 && (c==1 || c==6))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Knight(), "BLACK"));
				}
				else if(r==0 && (c==2 || c==5))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Bishop(), "BLACK"));
				}
				else if(r==0 && c==3)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Queen(), "BLACK"));
				}
				else if(r==0 && c==4)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new King(), "BLACK"));
				}	
				else if(r==7 && (c==0 || c==7))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Rook(), "WHITE"));
				}
				else if(r==7 && (c==1 || c==6))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Knight(), "WHITE"));
				}
				else if(r==7 && (c==2 || c==5))
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Bishop(), "WHITE"));
				}
				else if(r==7 && c==3)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new Queen(), "WHITE"));
				}
				else if(r==7 && c==4)
				{
					tiles[c][r]=new Tile(c, r, new Piece(new King(), "WHITE"));
				}
				else
				{
					tiles[c][r]=new Tile(c, r, new Piece(new EmptyTile(), "NEUTRAL"));
				}
			}
		}
	}
	
	public static void capturePiece(Tile[][] tile, int curCol, int curRow, 
			int newCol, int newRow)
	{
		tiles=tile;
		
		capturedPieces.add(tiles[newCol][newRow].getPiece());
		
		Piece.Move(tile, curCol, curRow, newCol, newRow);
		
		/*for(int i=0; i<capturedPieces.size(); i++)
		{
			System.out.println(capturedPieces.get(i).getPieceType());
		}*/
	}
	
	public static void captureKing(Piece king)
	{
		System.out.println("CHECKMATE");
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
			letterLabels[i].setBounds((startingX+28)+(80*i), startingY+610, 100, 100);
			letterLabels[i].setVisible(true);
			board.add(letterLabels[i]);
		}
		
		for(int i=0; i<letterLabels.length; i++) //For rows
		{
			numberLabels[i]=new JLabel();
			numberLabels[i].setFont(new Font("ARIAL", Font.BOLD, 24));
			numberLabels[i].setText(String.valueOf(i+1));
			numberLabels[i].setBounds(startingX-25, (startingY+550)-(80*i), 100, 100); 
			numberLabels[i].setVisible(true);
			board.add(numberLabels[i]);
		}
	}
	
	public static void setPlayer1Text(String text)
	{
		player1Name=text;
	}
	
	public String getPlayer1Text()
	{
		return player1Name;
	}
	
	public static void setPlayer2Text(String text)
	{
		player2Name=text;
	}
	
	public String getPlayer2Text()
	{
		return player2Name;
	}
	
	public static void incTurn()
	{
		turn++;
	}
	
	public static int getTurn()
	{
		return turn;
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
			
			if(selectedTile[0]==-1 && selectedTile[1]==-1)
			{
				if(!tiles[col][row].getPieceString().equals("EMPTY"))
				{
					if(getTurn()%2==1)
					{
						if(tiles[col][row].getPiece().getColor()=="WHITE")
						{
							selectedTile[0]=col;
							selectedTile[1]=row;
						}
					}
					
					if(getTurn()%2==0)
					{
						if(tiles[col][row].getPiece().getColor()=="BLACK")
						{
							selectedTile[0]=col;
							selectedTile[1]=row;
						}
					}
				}
			}
			else
			{
				if(tiles[col][row].getPiece().pieceIsLegalMove(tiles, selectedTile[0], 
						selectedTile[1], getCol(e.getX()), getRow(e.getY()),
						tiles[selectedTile[0]][selectedTile[1]].getPiece().getColor()))
				{
					Piece.Move(tiles, selectedTile[0], selectedTile[1], 
							getCol(e.getX()), getRow(e.getY()));	
				}
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
