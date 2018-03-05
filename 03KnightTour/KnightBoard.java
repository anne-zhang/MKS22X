public class KnightBoard{
    private int[][] board;
    private int rows;
    private int cols;
    
    public KnightBoard(int startingRows, int startingCols){
        board = new int[startingCols][startingRows];
        if(startingRows < 0 || startingCols < 0){
	    	throw new IllegalArgumentException();
		}
    }
    
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
    
     public int countSolutions(int startingRow, int startingCol){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
          throw new IllegalStateException();
        }
      }
    }

    if (startingRow < 0 || startingCol < 0){
      throw new IllegalArgumentException();
    }
    return countHelp(startingRow, startingCol, 1);

  }

  public int countHelp(int row, int col, int level){
    int sol = 0;
    int[][] coordinates = {{2,1},{1,2},{-2,1},{-1,2},{2,-1},{1,-2},{-1,-2},{-2,-1}};
    if (level == board.length * board[0].length){
      return 1;
    }
    for(int[] x: coordinates){
      if(row + x[0] < board.length && row + x[0] >= 0 &&
         col + x[1] < board[0].length && col + x[1] >= 0){
        if (board[row + x[0]][col + x[1]] == 0){
          board[row][col] = level;
          sol += countHelp(row + x[0], col + x[1], level + 1);
          board[row][col] = 0;
          }
      }
    }
    return sol;
  }
  
  public String toString(){
    String result = "";
    for(int i = 0; i < board.length; i++){
	    for(int j = 0; j < board[i].length; j++){
        if(board[i][j] == 0){
          result += "  -";
        } else
          if(board[i][j] < 10){
            result += "  " + board[i][j];
          }else{
            result += " " + board[i][j];
          }
	    }
	    result += "\n";
    }
    return result;
	}
}