package edu.jsu.mcis;

public class TicTacToeModel{
	public enum Mark {EMPTY, X, O};
    public enum Result {NONE, XWINS, OWINS, TIE};
    private Mark[][] grid;
    protected boolean xTurn;
	
	
	public TicTacToeModel(){
		grid = new Mark[3][3];
        reset();
	}
	
	private void reset() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = Mark.EMPTY;
            }
        }
        xTurn = true;
    }
    
    public void setMark(int r, int c) {
        if(r >= 0 && r < 3 && c >= 0 && c < 3) {
            if(grid[r][c] == Mark.EMPTY) {
                if(xTurn) grid[r][c] = Mark.X;
                else grid[r][c] = Mark.O;
                xTurn = !xTurn;
            }
        }
        
		
		
    }
	
	public String getMark(int r, int c){
		String m = "";
		if(grid[r][c] == Mark.X) m = "X";
        else if(grid[r][c] == Mark.O) m = "O";
        else m = " ";
		
		return m;
	}
	
	public String resultString(){
		Result result = getResult();
		String r = "";
		if(result == Result.XWINS)
			r = "X";
		else if(result == Result.OWINS)
			r = "O";
		else if(result == Result.TIE)
			r = "TIE";
		else
			r = "";
		
		return r;
	}
    
    public Result getResult() {
        Result r = checkResultHorizontally();
        if(r != Result.NONE) return r;
        r = checkResultVertically();
        if(r != Result.NONE) return r;
        r = checkResultDiagonally();
        if(r != Result.NONE) return r;
        if(isBoardFull()) return Result.TIE;        
        return Result.NONE;
    }
    
    private Result checkResultHorizontally() {
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] == grid[i][1] && 
               grid[i][1] == grid[i][2] &&
               grid[i][0] != Mark.EMPTY) {
                if(grid[i][0] == Mark.X) return Result.XWINS;
                else return Result.OWINS;
            }
        }
        return Result.NONE;
    }
    
    private Result checkResultVertically() {
        for(int i = 0; i < 3; i++) {
            if(grid[0][i] == grid[1][i] && 
               grid[1][i] == grid[2][i] &&
               grid[0][i] != Mark.EMPTY) {
                if(grid[0][i] == Mark.X) return Result.XWINS;
                else return Result.OWINS;
            }
        }
        return Result.NONE;
    }
    
    private Result checkResultDiagonally() {
        if(grid[0][0] == grid[1][1] &&
           grid[1][1] == grid[2][2] &&
           grid[0][0] != Mark.EMPTY) {
            if(grid[0][0] == Mark.X) return Result.XWINS;
            else return Result.OWINS;
        }
        if(grid[2][0] == grid[1][1] &&
           grid[1][1] == grid[0][2] &&
           grid[2][0] != Mark.EMPTY) {
            if(grid[2][0] == Mark.X) return Result.XWINS;
            else return Result.OWINS;
        }
        return Result.NONE;
    }
    
    protected boolean isBoardFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == Mark.EMPTY) return false;
            }
        }
        return true;
    }
    
	public String toString() {
        String s = "";
        for(int i = 0; i < 3; i++) {
			if(i == 1 || i == 2) s += "---------\n";
            for(int j = 0; j < 3; j++) {
                if(grid[i][j] == Mark.X) s += "X";
                else if(grid[i][j] == Mark.O) s += "O";
                else s += " ";
				if(j == 0 || j == 1) s += " | ";
				if(j == 2) s += "\n";
            }
        }
        return s;
    }
    
}