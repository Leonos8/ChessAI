package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu implements ActionListener
{
	JPanel menu=new JPanel();
	
	JButton player1Button=new JButton();
	JButton player2Button=new JButton();
	JButton trainingButton=new JButton();
	JButton settingsButton=new JButton();
	
	
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

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==player1Button)
		{
			
		}
		
		if(e.getSource()==player2Button)
		{
			
		}
		
		if(e.getSource()==trainingButton)
		{
			
		}
		
		if(e.getSource()==settingsButton)
		{
			
		}
	}
}
