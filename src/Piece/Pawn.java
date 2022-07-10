package Piece;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Graphics.Board;
import Graphics.Tile;

public class Pawn
       extends Piece
{	
	public static final ImageIcon WHITE_ICON=new ImageIcon(imagePath+"whitePawn.png");
	public static final ImageIcon BLACK_ICON=new ImageIcon(imagePath+"blackPawn.png");
	
	public static final Image WHITE_IMAGE=WHITE_ICON.getImage();
	public static final Image BLACK_IMAGE=BLACK_ICON.getImage();
	
	//static boolean enPassant=false;
	
	int startingCol;
	int startingRow;
	
	int col;
	int row;
	
	static JPanel knightPromotionPanel;
	static JPanel bishopPromotionPanel;
	static JPanel rookPromotionPanel;
	static JPanel queenPromotionPanel;
	
	Board board;
	
	public Pawn(Board board, Piece.Color color, int col, int row)
	{
		this.board=board;
		this.color=color;
		this.startingCol=col;
		this.startingRow=row;
		this.pieceType=Type.Pawn;
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
	
	//TODO Program enPassant
	public boolean isLegalMove(Tile[][] tile, int curCol, int curRow, int newCol, int newRow, Color color)
	{
		Piece piece=tile[newCol][newRow].getPiece();
		
		if(color.equals(Color.White))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				if(!tile[curCol][curRow].getPiece().getMoved())
				{
					if(newCol==curCol && newRow==curRow-2)
					{
						return true;
					}
				}
					
				if(newCol==curCol && newRow==curRow-1)
				{
					return true;
				}
			}
				
			if(tile[newCol][newRow].containsPiece() 
					&& !(piece.getColor().equals(color)))
			{
				if(newRow==curRow-1 && (newCol==curCol-1 || newCol==curCol+1))
				{
					if(piece.getPiece() instanceof King)
					{
						Board.captureKing(piece);
					}
					
					board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}
		
		if(color.equals(Color.Black))
		{
			if(!tile[newCol][newRow].containsPiece())
			{
				if(!tile[curCol][curRow].getPiece().getMoved())
				{
					if(newCol==curCol && newRow==curRow+2)
					{
						return true;
					}
				}
					
				if(newCol==curCol && newRow==curRow+1)
				{
					return true;
				}
			}
				
			if(tile[newCol][newRow].containsPiece() 
					&& !(tile[newCol][newRow].getPiece().getColor().equals(color)))
			{
				if(newRow==curRow+1 && (newCol==curCol-1 || newCol==curCol+1))
				{
					if(tile[newCol][newRow].getPiece().getPiece() instanceof King)
					{
						Board.captureKing(tile[newCol][newRow].getPiece());
					}
					
					board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}	
		
		return false;
	}
	
	public void pawnPromotion(Tile[][] tile ,int newCol, int newRow)
	{
		knightPromotionPanel=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				if(color==Color.White)
				   g2d.drawImage(Knight.WHITE_IMAGE, -20, -35, this);
				else
    			   g2d.drawImage(Knight.BLACK_IMAGE, -20, -35, this);
			}
		};
		
		knightPromotionPanel.setBackground(WHITE);
		knightPromotionPanel.setLayout(null);
		knightPromotionPanel.setVisible(true);
		knightPromotionPanel.setBorder(BorderFactory.createLineBorder(BLACK));
		
		if(tile[newCol][newRow].getPiece().getColor().equals(Color.White))
		{
			knightPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)-120, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals(Color.Black))
		{
			System.out.println("HI");
			System.out.println(Board.getEndingY());
			knightPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)-120, 
					Board.getEndingY(), 80, 50);
		}
		
		knightPromotionPanel.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Knight(board, color, newCol, newRow));
				
				setPromotionPanelVisible(false);
				
				Board.board.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				
			}
			
		});
		
		Board.board.add(knightPromotionPanel);
		
		bishopPromotionPanel=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				if(color==Color.White)
					   g2d.drawImage(Bishop.WHITE_IMAGE, -20, -35, this);
					else
	    			   g2d.drawImage(Bishop.BLACK_IMAGE, -20, -35, this);

			}
		};
		
		bishopPromotionPanel.setBackground(WHITE);
		bishopPromotionPanel.setLayout(null);
		bishopPromotionPanel.setVisible(true);
		bishopPromotionPanel.setBorder(BorderFactory.createLineBorder(BLACK));
		
		if(tile[newCol][newRow].getPiece().getColor().equals(Color.White))
		{
			bishopPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)-40, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
		{
			bishopPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)-40, 
					Board.getEndingY(), 80, 50);
		}
		
		bishopPromotionPanel.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Bishop(board, color,  newCol, newRow));
				
				setPromotionPanelVisible(false);
				
				Board.board.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				
			}
			
		});
		
		Board.board.add(bishopPromotionPanel);
		
		rookPromotionPanel=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				if(color==Color.White)
					   g2d.drawImage(Rook.WHITE_IMAGE, -20, -35, this);
					else
	    			   g2d.drawImage(Rook.BLACK_IMAGE, -20, -35, this);
			}
		};
		
		rookPromotionPanel.setBackground(WHITE);
		rookPromotionPanel.setLayout(null);
		rookPromotionPanel.setVisible(true);
		rookPromotionPanel.setBorder(BorderFactory.createLineBorder(BLACK));

		if(tile[newCol][newRow].getPiece().getColor().equals(Color.White))
		{
			rookPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)+40, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals(Color.Black))
		{
			rookPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)+40, 
					Board.getEndingY(), 80, 50);
		}
		
		rookPromotionPanel.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Rook(board, color, newCol, newRow));
				
				setPromotionPanelVisible(false);
				
				Board.board.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				
			}
			
		});
		
		Board.board.add(rookPromotionPanel);
		
		queenPromotionPanel=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				if(color==Color.White)
					   g2d.drawImage(Queen.WHITE_IMAGE, -20, -35, this);
					else
	    			   g2d.drawImage(Queen.BLACK_IMAGE, -20, -35, this);
			}
		};
		
		queenPromotionPanel.setBackground(WHITE);
		queenPromotionPanel.setLayout(null);
		queenPromotionPanel.setVisible(true);
		queenPromotionPanel.setBorder(BorderFactory.createLineBorder(BLACK));

		if(tile[newCol][newRow].getPiece().getColor().equals(Color.White))
		{
			queenPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)+120, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals(Color.Black))
		{
			queenPromotionPanel.setBounds(Board.getStartingX()+(newCol*80)+120, 
					Board.getEndingY(), 80, 50);
		}
		
		queenPromotionPanel.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Queen(board, color, newCol, newRow));
				
				setPromotionPanelVisible(false);
				
				Board.board.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseReleased(MouseEvent e) 
			{
				
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}

			@Override
			public void mouseExited(MouseEvent e) 
			{
				
			}
			
		});
		
		Board.board.add(queenPromotionPanel);
	}
	
	public static void setPromotionPanelVisible(boolean visible)
	{
		knightPromotionPanel.setVisible(false);
		bishopPromotionPanel.setVisible(false);
		rookPromotionPanel.setVisible(false);
		queenPromotionPanel.setVisible(false);
	}
	
	@Override
	public String toString()
	{
		return "PAWN";
	}
}
