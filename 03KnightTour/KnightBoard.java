public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
        board = new int[startingCols][startingRows];
        if(startingRows < 0 || startingCols < 0){
	    	throw new IllegalArgumentException();
		}
		//clear();
    }
    
    /*public void clear(){
    	for(int row = 0; row < board.length; row++){
    		for(int col = 0; col < board.length; col++){
    			board[row][col] = 0;
    		}
    	}
    }*/
	public boolean solve(int startingRow, int startingCol){
	if (startingRow >= board.length || startingRow < 0){
	    throw new IllegalArgumentException("Not a valid row");
	}

	if (startingCol >= board[0].length || startingCol < 0){
	    throw new IllegalArgumentException("Not a valid column");
	}
	
	for (int r = 0; r < board.length; r ++){
	    for (int c = 0; c < board.length; c++){
		if (board[r][c] != 0){
		    throw new IllegalStateException("Non-zero values!");
		}
	    }
	}
	return solver(startingRow, startingCol, 1);
    }
    
    public boolean solver(int row, int col, int level) {
		if(level > board.length * board.length){
            return true;
        }
        if(col >= board.length || col < 0 || row >= board.length || row < 0){
            return false;
        }
        if(board[col][row] == 0){
            board[col][row] = level;
            if(solver(row+2, col+1, level+1) 
            || solver(row+2, col-1, level+1) 
            || solver(row-2, col+1, level+1)  
            || solver(row-2, col-1, level+1) 
            || solver(row-1, col+2, level+1) 
            || solver(row-1, col-2, level+1) 
            || solver(row+1, col-2, level+1)
            || solver(row+1, col+2, level+1))
            {
                return true;
            }
            board[col][row] = 0;
        }
        return false;

	}
    
    public String toString(){
        String str = "";
        for(int i = 0; i < board.length; i++){
            for(int k = 0; k < board.length; k++){
                str = str + board[k][i] + " ";
            }
            str +="\n";
        }
        return str;
    }
    public static void main(String[] args){
	KnightBoard k = new KnightBoard(5, 5);
	System.out.println(k.solve(0,0));
	System.out.println(k);
    }
}