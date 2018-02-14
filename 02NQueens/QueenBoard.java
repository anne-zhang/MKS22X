public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size){
		board = new int[size][size];
	}
    
    private boolean addQueen(int r,int c){
        if (board[r][c] == 0){
	    	board[r][c] = -1;
	    	int x = c + 1;
	    	for (int i = r - 1; (i > 0) && ((c+1) < board.length); i--){
	    		board[i][c+1] ++;
	    		x ++;
	    	}
	    	for (int i = r +1; i < board.length && ((c + 1) < board.length); i ++){
	    		board[i][c+1] ++;
	    		x ++;
	    	}
	    	for (int i = c + 1; i < board.length; i++){
	    		board[r][i] ++;
	    	}
	    	
	    	return true;  	
	}
	return false;
    }
    
    private boolean removeQueen(int r,int c){
		if (board[r][c] != -1){
	    	board[r][c] = 0;
	    int x = c + 1;
		for (int i = r - 1; (i > 0) && ((c+1) < board.length); i--){
	    		board[i][c+1] --;
	    		x ++;
	    	}
	    	for (int i = r +1; (i < board.length) && ((c + 1) < board.length); i ++){
	    		board[i][c+1] --;
	    		x ++;
	    	}
	    	for (int i = c + 1; i < board.length; i++){
	    		board[r][i] --;
	    	}
		
		return true;
    	}
    	return false;
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
	public boolean solve(){
		for(int x = 0; x < board.length; x++) {
	    	for(int y = 0; y < board[x].length; y++) {
			if(board[x][y] != 0) {
		    	throw new IllegalStateException();
		}
	    }
	}
	return solver(0);
    }
    
    
    
    public boolean solver(int col) {
	if(col >= board.length) {
	   return true;
	}
	for(int x = 0; x < board.length; x++) {
	    if(addQueen(x, col)) {
		if(solver(col+1)) {
		    return true;
		}
		else {
		    removeQueen(x, col);
		}
	    }
	}
	return false;
    }
    
    
    public int countSolutions() {
		for(int x = 0; x < board.length; x++) {
	    	for(int y = 0; y < board[x].length; y++) {
			if(board[x][y] != 0) {
		    	throw new IllegalStateException();
			}
	    	}
		}
		return countHelp(0);
    }


    public int countHelp(int col) {
		if(col >= board.length) {
	    	return 1;
		}
		int total = 0;
		for(int x = 0; x < board.length; x++) {
	    	if(addQueen(x, col)) {
			total += countHelp(col+1);
			removeQueen(x,col);
	    	}
		}
		return total;
    }
    

}


    
