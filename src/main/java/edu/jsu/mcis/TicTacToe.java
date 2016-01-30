package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class TicTacToe extends JPanel implements ActionListener{

		protected TicTacToeModel game;
		private JButton[][] gridButtons;
		private JLabel messageLabel;
		private JPanel board;
		
		private int turn;
		private int row;
		private int col;
		private String[] player;
		private boolean noWin = true;
		
		public TicTacToe(){
			game = new TicTacToeModel();
			board = new JPanel();
			messageLabel = new JLabel("X make your move");
			gridButtons = new JButton[3][3];
			
			board.setLayout(new GridLayout(3, 3));
			
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					gridButtons[i][j] = new JButton(" ");
					gridButtons[i][j].setFont(new Font("",Font.BOLD, 30));
					gridButtons[i][j].setPreferredSize(new Dimension(75, 75));
					gridButtons[i][j].addActionListener(this);
					gridButtons[i][j].setActionCommand(i + "" + j);
					board.add(gridButtons[i][j]);
				}
			}
			
			board.setSize(600, 600);
			add(board);
			
			messageLabel.setPreferredSize(new Dimension(300, 100));
			messageLabel.setFont(new Font("",Font.BOLD, 22));
			messageLabel.setVerticalAlignment(SwingConstants.CENTER);
			messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			add(messageLabel);
			
			player = new String[2];
			player[0] = "Player X";
			player[1] = "Player O";
			
		}
		
		private void checkForWin(){
			String r = game.resultString();
			if(r.length() > 0){
				noWin  = false;
				new Thread(new Runnable(){
					public void run(){
						JOptionPane.showMessageDialog(null, "The winner is " + r, "Game Over", JOptionPane.INFORMATION_MESSAGE);
					
					}}).start();
			}
				
		}
		
		public void actionPerformed(ActionEvent e){
			JButton b = (JButton)e.getSource();
			
			int r = Integer.parseInt(b.getActionCommand().substring(0, 1));
			int c = Integer.parseInt(b.getActionCommand().substring(1, 2));
				
			game.setMark(r, c);
			b.setText(game.getMark(r, c));
			if(game.xTurn){
				messageLabel.setText("Player X make your move");
				checkForWin();
				if(!noWin){
					toggleButtons();
					messageLabel.setText("Game Over!");
				}
			}
			else{
				messageLabel.setText("Player O make your move");
				checkForWin();
				if(!noWin){
					toggleButtons();
					messageLabel.setText("Game Over!");
				}
			}
		}
		
		
		 public void toggleButtons(){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					gridButtons[i][j].setEnabled(false);
				}
			}
		 }
		
			
			
public static void main(String[] args) {

		JFrame win = new JFrame();
		win.setTitle("Tic Tac Toe");
		win.setSize(400, 400);
		win.add(new TicTacToe());
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setVisible(true);

	}
}

