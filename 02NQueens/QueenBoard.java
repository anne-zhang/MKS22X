public class QueenBoard{
    private int[][] board;
    
    public QueenBoard(int size){
		board = new int[size][size];
	 	for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                board[r][c] = 0;
            }
        }
    }

    private boolean addQueen(int row, int col){
    	if (board[row][col] == 0) {
	    board[row][col] --;
        for(int i = col; i < board.length; i++){
            board[row][i] += 1;
        }
        for(int i = col, j = row; i < board.length && j < board.length; i++, j++){
            board[j][i] += 1;
        }
        for(int i = col, j = row; i < board.length && j >= 0; i++, j--){
            board[j][i] += 1;
        }
        board[row][col] = -1;
        return true;
        }
        return false;
    }
    
    private boolean removeQueen(int row, int col){
    	if (board[row][col] == -1) {
	    board[row][col] ++;
        for(int i = col; i < board.length; i++){
            board[row][i] -= 1;
        }
        for(int i = col, j = row; i < board.length && j < board.length; i++, j++){
            board[j][i] -= 1;
        }
        for(int i = col, j = row; i < board.length && j >= 0; i++, j--){
            board[j][i] -= 1;
        }
        board[row][col] = 0;
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
	    	str += "\n";
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
    


/*
// Crystal's Driver
    public static void main(String[]args){

		QueenBoard b = new QueenBoard(4);

		System.out.println(b.solve()); //prints true
		System.out.println(b); //prints a valid solution


		try{
	 	   b.solve();
		}catch(IllegalStateException e){
		    System.out.println("Error: The board contains non-zero values");
		} //prints "Error: The board contains non-zero values"


		try{
		    b.countSolutions();
		}catch(IllegalStateException e){
	 	   System.out.println("Error: The board contains non-zero values");
		} //prints "Error: The board contains non-zero values"

		for (int i = 0; i < 12; i++){
	  		QueenBoard a = new QueenBoard(i);
	     	System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
	  		/*          Expected Values
			i --> # of Solutions   i --> # of Solutions
			0 --> 1                      6 --> 4
			1 --> 1                      7 --> 40
			2 --> 0                      8 --> 92
			3 --> 0                      9 --> 352
			4 --> 2                    10 --> 724
			5 --> 10                  11 --> 2680
	    	*/
	    System.out.println(a); //prints out an empty i by i grid of underscores
		}


    }*/
}


    
