package edu.jsu.mcis;

import java.util.*;

public class TicTacToe {
		private TicTacToeModel game;
		private int turn;
		private int row;
		private int col;
		private String[] player;
		
		public TicTacToe(){
			game = new TicTacToeModel();
			player = new String[2];
			player[0] = "Player X";
			player[1] = "Player O";
			turn = 0;
			row = 0;
			col = 0;
		}
		
		public void runGame(){
			System.out.println("Welcome to TicTacToe.");
			
			Scanner choice = new Scanner(System.in);
			
			while(game.resultString().equals("NONE")){
				if(game.xTurn) turn = 0;
				else turn = 1;
				
				System.out.println(player[turn] + " choose a row 1-3.");
				row = choice.nextInt();
				System.out.println(player[turn] + " choose a column 1-3.");
				col = choice.nextInt();
				
				game.setMark(row-1, col-1);
				
				System.out.print("\n\n" + game.toString() + "\n\n");
				
				if(!game.resultString().equals("NONE"))
					System.out.println(game.resultString());
				
			}
		}
			
			
public static void main(String[] args) {
		TicTacToe newGame = new TicTacToe();
		newGame.runGame();
		
	}
}
