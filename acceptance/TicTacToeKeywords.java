import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToeModel game;
	
	public void startNewGame() {
		game = new TicTacToeModel();
	}
	public void startApplication(){
		TicTacToe gameApp = new TicTacToe();
	}
	
	public void markLocation(int row, int col) {
		game.setMark(row, col);
	}
	
	public String getMark(int row, int col) {
		String m = game.getMark(row, col);
		if(m == "X") return "X";
		else if (m == "O") return "O";
		else return m;
	}
    
	public String getWinner() {
		String w = game.resultString();
		return w;
	}
}
