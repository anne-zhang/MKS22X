public class KnightBoard{
    private int[][] board;
    
    public KnightBoard(int startingRows, int startingCols){
        board = new int[startingCols][startingRows];
    }
	public boolean solve(int startingRow, int startingCol){

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
}