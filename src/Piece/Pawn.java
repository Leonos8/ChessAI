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
{
	static ImageIcon pawnIcon;
	
	static Image pawnImage;
	
	//static boolean enPassant=false;
	
	int startingCol;
	int startingRow;
	
	static JPanel promotionPanel1;
	static JPanel promotionPanel2;
	static JPanel promotionPanel3;
	static JPanel promotionPanel4;
	
	public Pawn()
	{
		
	}
	
	public Pawn(int col, int row)
	{
		this.startingCol=col;
		this.startingRow=row;
	}
	
	public String getStartingPosition()
	{
		return Tile.positionToString(startingCol, startingRow);
	}
	
	public static boolean isLegalMove(Tile[][] tile ,int curCol, int curRow, 
			int newCol, int newRow, String color) //TODO program en passant
	{
		if(color.equals("WHITE"))
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
					&& !(tile[newCol][newRow].getPiece().getColor().equals(color)))
			{
				if(newRow==curRow-1 && (newCol==curCol-1 || newCol==curCol+1))
				{
					if(tile[newCol][newRow].getPiece().getPiece() instanceof King)
					{
						Board.captureKing(tile[newCol][newRow].getPiece());
					}
					
					Board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}
		
		if(color.equals("BLACK"))
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
					
					Board.capturePiece(tile, curCol, curRow, newCol, newRow);
				}
			}
		}	
		
		return false;
	}
	
	public static void pawnPromotion(Tile[][] tile ,int newCol, int newRow)
	{
		promotionPanel1=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				g2d.drawImage(Knight.getImage(tile[newCol][newRow].getPiece().getColor()), 
						-20, -35, this);
			}
		};
		
		promotionPanel1.setBackground(Color.white);
		promotionPanel1.setLayout(null);
		promotionPanel1.setVisible(true);
		promotionPanel1.setBorder(BorderFactory.createLineBorder(Color.black));
		
		if(tile[newCol][newRow].getPiece().getColor().equals("WHITE"))
		{
			promotionPanel1.setBounds(Board.getStartingX()+(newCol*80)-120, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
		{
			System.out.println("HI");
			System.out.println(Board.getEndingY());
			promotionPanel1.setBounds(Board.getStartingX()+(newCol*80)-120, 
					Board.getEndingY(), 80, 50);
		}
		
		promotionPanel1.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Piece(new Knight(newCol, newRow), 
						tile[newCol][newRow].getPiece().getColor()));
				
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
		
		Board.board.add(promotionPanel1);
		
		promotionPanel2=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				g2d.drawImage(Bishop.getImage(tile[newCol][newRow].getPiece().getColor()), 
						-20, -35, this);
			}
		};
		
		promotionPanel2.setBackground(Color.white);
		promotionPanel2.setLayout(null);
		promotionPanel2.setVisible(true);
		promotionPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		if(tile[newCol][newRow].getPiece().getColor().equals("WHITE"))
		{
			promotionPanel2.setBounds(Board.getStartingX()+(newCol*80)-40, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
		{
			promotionPanel2.setBounds(Board.getStartingX()+(newCol*80)-40, 
					Board.getEndingY(), 80, 50);
		}
		
		promotionPanel2.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Piece(new Bishop(newCol, newRow), 
						tile[newCol][newRow].getPiece().getColor()));
				
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
		
		Board.board.add(promotionPanel2);
		
		promotionPanel3=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				g2d.drawImage(Rook.getImage(tile[newCol][newRow].getPiece().getColor()), 
						-20, -35, this);
			}
		};
		
		promotionPanel3.setBackground(Color.white);
		promotionPanel3.setLayout(null);
		promotionPanel3.setVisible(true);
		promotionPanel3.setBorder(BorderFactory.createLineBorder(Color.black));

		if(tile[newCol][newRow].getPiece().getColor().equals("WHITE"))
		{
			promotionPanel3.setBounds(Board.getStartingX()+(newCol*80)+40, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
		{
			promotionPanel3.setBounds(Board.getStartingX()+(newCol*80)+40, 
					Board.getEndingY(), 80, 50);
		}
		
		promotionPanel3.addMouseListener(new MouseListener()
		{

			@Override
			public void mouseClicked(MouseEvent e) 
			{
				tile[newCol][newRow].setPiece(new Piece(new Rook(newCol, newRow), 
						tile[newCol][newRow].getPiece().getColor()));
				
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
		
		Board.board.add(promotionPanel3);
		
		promotionPanel4=new JPanel()
		{
			public void paint(Graphics g)
			{
				super.paint(g);
				
				Graphics2D g2d=(Graphics2D) g;
				
				g2d.drawImage(Queen.getImage(tile[newCol][newRow].getPiece().getColor()), 
						-20, -35, this);
			}
		};
		
		promotionPanel4.setBackground(Color.white);
		promotionPanel4.setLayout(null);
		promotionPanel4.setVisible(true);
		promotionPanel4.setBorder(BorderFactory.createLineBorder(Color.black));

		if(tile[newCol][newRow].getPiece().getColor().equals("WHITE"))
		{
			promotionPanel4.setBounds(Board.getStartingX()+(newCol*80)+120, 
					Board.getStartingY()-50, 80, 50);
		}
		else if(tile[newCol][newRow].getPiece().getColor().equals("BLACK"))
		{
			promotionPanel4.setBounds(Board.getStartingX()+(newCol*80)+120, 
					Board.getEndingY(), 80, 50);
		}
		
		promotionPanel4.addMouseListener(new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.out.println(90);
				tile[newCol][newRow].setPiece(new Piece(new Queen(newCol, newRow), 
						tile[newCol][newRow].getPiece().getColor()));
				
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
		
		Board.board.add(promotionPanel4);
	}
	
	public static void setPromotionPanelVisible(boolean visible)
	{
		promotionPanel1.setVisible(false);
		promotionPanel2.setVisible(false);
		promotionPanel3.setVisible(false);
		promotionPanel4.setVisible(false);
	}
	
	public static void setImageIcon(String clr)
	{
		File currDir=new File(".");
		
		String path=currDir.getAbsolutePath();
		path=path.substring(0, path.length()-2);	
		
		String imagePath=path+File.separator+"PieceSprites"+File.separator;
		
		if(clr.equals("BLACK"))
		{
			pawnIcon=new ImageIcon(imagePath+"blackPawn.png");
		}
		else
			pawnIcon=new ImageIcon(imagePath+"whitePawn.png");
		
		pawnImage=pawnIcon.getImage();
	}
	
	public static Image getImage(String color)
	{
		setImageIcon(color);
		
		return pawnImage;
	}
	
	@Override
	public String toString()
	{
		return "PAWN";
	}
}
