public class QueenBoard{
    private int[][] board;
    public QueenBoard(int size){
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		board[i][j] = 0;
	    }
	}
    }
    private boolean addQueen(int r,int c){
        if (board[r][c] == 0){
	    board[r][c] = -1;
	    return true;
	}
	return false;
    }
    private boolean removeQueen(int r,int c){
	if (board[r][c] != -1){
	    return false;
	}
	board[r][c] = 0;
	return true;
    }
    public String toString(){
	String str = "";
	for (int i = 0;i<board.length;i++){
	    for (int j = 0;j<board.length;j++){
		if (board[i][j] == -1){
		    str += " Q";
		}else{
		    str += " _";
		}
	    }
	    str += "/n";
	}
	return str;
    }
    /*public solve(int current){
    	return solve(0)
    }
    public solveR(int current){
    }
    public threaten(int r, int c){
    }
    public int counter(int col, int count){
    int total = 0;
    if (count == board.length){
    	return 1; // one solution for no cols
    }
    if (col == board.length){
    }
    
    return total;
    }*/
}