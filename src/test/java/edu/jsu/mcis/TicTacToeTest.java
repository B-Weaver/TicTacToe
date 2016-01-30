package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	TicTacToeModel game = new TicTacToeModel();
	
	
	@Test
	public void newGameIsCreated() {
		TicTacToe newGame = new TicTacToe();
		newGame.game.setMark(1, 1);
		newGame.game.setMark(0, 0);
		boolean t = false;
		if(newGame.game.resultString().equals(""))
			t = true;
		assertTrue(t);
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		String m = "";
		boolean b = true;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				m = game.getMark(i , j);
				if(!m.equals(" "))
					b = false;
			}
		}
		assertTrue(b);
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		game.setMark(0, 2);
		
		String m = game.getMark(0, 2);
		boolean t = false;
		if(m.equals("X"))
			t = true;
		assertTrue(t);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		game.setMark(1, 1);
		game.setMark(2, 0);
		
		String m = game.getMark(2, 0);
		boolean t = false;
		if(m.equals("O"))
			t = true;
		assertTrue(t);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		game.setMark(2, 1);
		game.setMark(2, 1);
		String m = game.getMark(2, 1);
		boolean t = false;
		if(m.equals("X"))
			t = true;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(1, 1);
		String r = newGame.resultString();
		if(!r.equals(""))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(1, 0);
		newGame.setMark(0, 1);
		newGame.setMark(1, 1);
		newGame.setMark(0, 2);
		String r = newGame.resultString();
		if(!r.equals("X"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByOHorizontallyAcrossBottomRow() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(1, 0);
		newGame.setMark(2, 0);
		newGame.setMark(1, 1);
		newGame.setMark(2, 1);
		newGame.setMark(0, 2);
		newGame.setMark(2, 2);
		String r = newGame.resultString();
		if(!r.equals("O"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByXVerticallyDownLeftColumn() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(1, 1);
		newGame.setMark(1, 0);
		newGame.setMark(1, 2);
		newGame.setMark(2, 0);
		String r = newGame.resultString();
		if(!r.equals("X"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByOVerticallyDownRightColumn() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(0, 2);
		newGame.setMark(1, 1);
		newGame.setMark(1, 2);
		newGame.setMark(2, 0);
		newGame.setMark(2, 2);
		String r = newGame.resultString();
		if(!r.equals("O"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByXDiagonallyLeftToRight() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(2, 0);
		newGame.setMark(1, 1);
		newGame.setMark(2, 1);
		newGame.setMark(2, 2);
		String r = newGame.resultString();
		if(!r.equals("X"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByODiagonallyLeftToRight() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 1);
		newGame.setMark(0, 0);
		newGame.setMark(2, 0);
		newGame.setMark(1, 1);
		newGame.setMark(2, 1);
		newGame.setMark(2, 2);
		String r = newGame.resultString();
		if(!r.equals("O"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByODiagonallyRightToLeft() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(0, 2);
		newGame.setMark(0, 1);
		newGame.setMark(1, 1);
		newGame.setMark(2, 2);
		newGame.setMark(2, 0);
		String r = newGame.resultString();
		if(!r.equals("O"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsWonByXDiagonallyRightToLeft() {
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		
		newGame.setMark(0, 2);
		newGame.setMark(0, 1);
		newGame.setMark(1, 1);
		newGame.setMark(2, 2);
		newGame.setMark(2, 0);
		String r = newGame.resultString();
		if(!r.equals("X"))
			t = false;
		assertTrue(t);
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = true;
		newGame.setMark(0, 0);
		newGame.setMark(0, 1);
		newGame.setMark(0, 2);
		newGame.setMark(1, 1);
		newGame.setMark(1, 0);
		newGame.setMark(2, 0);
		newGame.setMark(2, 1);
		newGame.setMark(1, 2);
		newGame.setMark(2, 2);
		String r = newGame.resultString();
		if(!r.equals("TIE"))
			t = false;
		assertTrue(t);
	}	
	
	@Test
	public void testAllLocationsAreFilled() {
		
		TicTacToeModel newGame = new TicTacToeModel();
		boolean t = false;
		newGame.setMark(0, 0);
		newGame.setMark(0, 1);
		newGame.setMark(0, 2);
		newGame.setMark(1, 1);
		newGame.setMark(1, 0);
		newGame.setMark(1, 2);
		newGame.setMark(2, 1);
		newGame.setMark(2, 0);
		String r = newGame.toString();
		if(r.equals("X | O | X\n---------\nX | O | O\n---------\nO | X |  \n"))
			t = true;
		assertTrue(t);
	}
}
