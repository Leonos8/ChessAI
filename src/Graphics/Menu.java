package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu implements ActionListener
{
	JPanel menu=new JPanel();
	
	JPanel player1Panel=new JPanel();
	JPanel player2Panel=new JPanel();
	JPanel trainingPanel=new JPanel();
	JPanel settingsPanel=new JPanel();
	
	JButton player1Button=new JButton();
	JButton player2Button=new JButton();
	JButton trainingButton=new JButton();
	JButton settingsButton=new JButton();
	JButton backButton=new JButton();
	JButton startGameButton=new JButton();
	
	JTextField player1NameInput=new JTextField();
	JTextField player2NameInput=new JTextField();
	
	public Menu()
	{
		menu.setBackground(Color.cyan);
		menu.setLayout(null);
		menu.setVisible(true);
		
		GUI.frame.getContentPane().add(menu);
		
		////////////////////////////////////////////////		
		player1Button.setFont(new Font("Arial", Font.PLAIN, 24));
		player1Button.setText("1-Player");
		player1Button.setBounds(GUI.frame.getWidth()/2-75, 25, 150, 50);
		player1Button.addActionListener(this);
		player1Button.setVisible(true);
		
		menu.add(player1Button);
		
		////////////////////////////////////////////////
		player2Button.setFont(new Font("Arial", Font.PLAIN, 24));
		player2Button.setText("2-Player");
		player2Button.setBounds(GUI.frame.getWidth()/2-75, 100, 150, 50);
		player2Button.addActionListener(this);
		player2Button.setVisible(true);
		
		menu.add(player2Button);
		
		////////////////////////////////////////////////		
		trainingButton.setFont(new Font("Arial", Font.PLAIN, 24));
		trainingButton.setText("Train");
		trainingButton.setBounds(GUI.frame.getWidth()/2-75, 175, 150, 50);
		trainingButton.addActionListener(this);
		trainingButton.setVisible(true);
		
		menu.add(trainingButton);
		
		////////////////////////////////////////////////		
		settingsButton.setFont(new Font("Arial", Font.PLAIN, 24));
		settingsButton.setText("Settings");
		settingsButton.setBounds(GUI.frame.getWidth()/2-75, 250, 150, 50);
		settingsButton.addActionListener(this);
		settingsButton.setVisible(true);
		
		menu.add(settingsButton);
	}
	
	public void create1PlayerPanel()
	{	
		menu.setVisible(false);
		
		player1Panel.setBackground(Color.cyan);
		player1Panel.setLayout(null);
		player1Panel.setVisible(true);
		
		GUI.frame.getContentPane().add(player1Panel);
		
		/////////////////////////////////////////////////////////				
		backButton.setFont(new Font("Arial", Font.PLAIN, 24));
		backButton.setText("Back");
		backButton.setBounds(25, 25, 150, 50);
		backButton.addActionListener(this);
		backButton.setVisible(true);
		
		player1Panel.add(backButton);
		
		/////////////////////////////////////////////////////////		
		JLabel playerName=new JLabel();
		
		playerName.setFont(new Font("Arial", Font.PLAIN, 24));
		playerName.setText("Player:");
		playerName.setBounds(GUI.frame.getWidth()/2-80, 25, 150, 50);
		playerName.setVisible(true);
		
		player1Panel.add(playerName);
		
		/////////////////////////////////////////////////////////		
		player1NameInput.setFont(new Font("Arial", Font.PLAIN, 24));
		player1NameInput.setBounds(GUI.frame.getWidth()/2+5, 40, 150, 25);
		player1NameInput.setVisible(true);
		
		player1Panel.add(player1NameInput);
		
		/////////////////////////////////////////////////////////		
		JLabel computerName=new JLabel();

		computerName.setFont(new Font("Arial", Font.PLAIN, 24));
		computerName.setText("Computer:");
		computerName.setBounds(GUI.frame.getWidth()/2-120, 75, 150, 50);
		computerName.setVisible(true);

		player1Panel.add(computerName);

		/////////////////////////////////////////////////////////		
		player2NameInput.setFont(new Font("Arial", Font.PLAIN, 24));
		player2NameInput.setBounds(GUI.frame.getWidth()/2+5, 90, 150, 25);
		player2NameInput.setVisible(true);

		player1Panel.add(player2NameInput);
		
		/////////////////////////////////////////////////////////		
		JLabel difficultyName=new JLabel();

		difficultyName.setFont(new Font("Arial", Font.PLAIN, 24));
		difficultyName.setText("Difficulty:");
		difficultyName.setBounds(GUI.frame.getWidth()/2-108, 125, 150, 50);
		difficultyName.setVisible(true);

		player1Panel.add(difficultyName);
		
		//TODO Add difficult guage for AI, and allow player to choose color
		
		/////////////////////////////////////////////////////////		
		startGameButton.setFont(new Font("Arial", Font.PLAIN, 24));
		startGameButton.setText("Start");
		startGameButton.setBounds(GUI.frame.getWidth()-175, 25, 150, 50);
		startGameButton.addActionListener(this);
		startGameButton.setVisible(true);

		player1Panel.add(startGameButton);
	}
	
	public void create2PlayerPanel()
	{		
		menu.setVisible(false);
		
		player2Panel.setBackground(Color.cyan);
		player2Panel.setLayout(null);
		player2Panel.setVisible(true);
		
		GUI.frame.getContentPane().add(player2Panel);
		
		/////////////////////////////////////////////////////////				
		backButton.setFont(new Font("Arial", Font.PLAIN, 24));
		backButton.setText("Back");
		backButton.setBounds(25, 25, 150, 50);
		backButton.addActionListener(this);
		backButton.setVisible(true);
		
		player2Panel.add(backButton);
		
		/////////////////////////////////////////////////////////		
		JLabel player1Name=new JLabel();
		
		player1Name.setFont(new Font("Arial", Font.PLAIN, 24));
		player1Name.setText("Player 1:");
		player1Name.setBounds(GUI.frame.getWidth()/2-100, 25, 150, 50);
		player1Name.setVisible(true);
		
		player2Panel.add(player1Name);
		
		/////////////////////////////////////////////////////////				
		player1NameInput.setFont(new Font("Arial", Font.PLAIN, 24));
		player1NameInput.setBounds(GUI.frame.getWidth()/2+5, 40, 150, 25);
		player1NameInput.setVisible(true);
		
		player2Panel.add(player1NameInput);
		
		/////////////////////////////////////////////////////////		
		JLabel player2Name=new JLabel();

		player2Name.setFont(new Font("Arial", Font.PLAIN, 24));
		player2Name.setText("Player 2:");
		player2Name.setBounds(GUI.frame.getWidth()/2-100, 75, 150, 50);
		player2Name.setVisible(true);

		player2Panel.add(player2Name);

		/////////////////////////////////////////////////////////		
		player2NameInput.setFont(new Font("Arial", Font.PLAIN, 24));
		player2NameInput.setBounds(GUI.frame.getWidth()/2+5, 90, 150, 25);
		player2NameInput.setVisible(true);

		player2Panel.add(player2NameInput);
		
		//TODO allow player to choose color
		
		/////////////////////////////////////////////////////////		
		startGameButton.setFont(new Font("Arial", Font.PLAIN, 24));
		startGameButton.setText("Start");
		startGameButton.setBounds(GUI.frame.getWidth()-175, 25, 150, 50);
		startGameButton.addActionListener(this);
		startGameButton.setVisible(true);
		
		player2Panel.add(startGameButton);
	}
	
	public void createTrainingPanel()
	{
		
	}
	
	public void createSettingsPanel()
	{
		
	}
	
	public void togglePanelVisibility(boolean visible)
	{
		menu.setVisible(visible);
		
		player1Panel.setVisible(visible);
		player2Panel.setVisible(visible);
		trainingPanel.setVisible(visible);
		settingsPanel.setVisible(visible);
	}
	
	public void toggleBackButtonVisibility(boolean visible)
	{
		backButton.setVisible(visible);
	}
	
	public void eraseLabelText()
	{
		player1NameInput.setText("");
		player2NameInput.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==player1Button)
		{
			create1PlayerPanel();
		}
		
		if(e.getSource()==player2Button)
		{
			create2PlayerPanel();
		}
		
		if(e.getSource()==trainingButton)
		{
			createTrainingPanel();
		}
		
		if(e.getSource()==settingsButton)
		{
			createSettingsPanel();
		}
		
		if(e.getSource()==backButton)
		{
			togglePanelVisibility(false);
			
			backButton.setVisible(false);
			menu.setVisible(true);
			
			eraseLabelText();
		}
		
		if(e.getSource()==startGameButton)
		{
			togglePanelVisibility(false);
			
			Board.setPlayer1Text(player1NameInput.getText());
			Board.setPlayer2Text(player2NameInput.getText());
			
			new Board();
			
			eraseLabelText();
		}
	}
}
