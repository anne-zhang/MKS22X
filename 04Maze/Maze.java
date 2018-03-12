import java.util.*;
import java.io.*;

public class Maze{
	private char[][] maze;
	private boolean animate;
	private int rows;
	private int cols;
	
    public Maze(String filename) throws FileNotFoundException{
	animate = false;

	String str = "";
	int col = 0;
	int row = 0;

	File text = new File(filename);
	Scanner inputFile = new Scanner(text);
	while(inputFile.hasNextLine()){
	    String line = inputFile.nextLine();
	    str += line + "\n";
	    col = line.length();
	    row++;
	}
        

	maze = new char[row][col];

	int count = 0;
	int start = 0;
	int end = 0;
	for (int r = 0; r < row; r++){
	    for (int c = 0; c < col; c++){
		if (str.charAt(count)=='S'){
		    start++;
		}
		if (str.charAt(count)=='E'){
		    end++;
		}

		if (str.charAt(count)=='\n'){
		    count++;
		}
		maze[r][c] = str.charAt(count);
		count++;
	    }
	}
	if (start != 1 || end != 1){
	    throw new IllegalArgumentException("Needs exactly one S and one E");
	}
    }

    
    public void setAnimate(boolean b){
        animate = b;
    }

    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    } 
    
    
    public int solve(){
	for(int i  = 0; i < maze.length; i++){
            for(int j  = 0; j < maze[i].length; j++){
		if(maze[i][j] == 'S'){
		    maze[i][j] = ' ';
		    return solve(i, j, 0);
		}
	    }
	}
	return -1;
    }

    private int solve(int row, int col, int steps){
	if(maze[row][col] == 'E'){
	    return steps;
	}
	if(maze[row][col] != ' '){
	    return -1;
	}
	maze[row][col] = '@';
        if(animate){
            clearTerminal();
            System.out.println(this);
	    System.out.println(steps);
            wait(20);
        }
	if((solve(row, col + 1, steps + 1)  == -1 && solve(row + 1, col, steps + 1) == -1) 
	&& (solve(row, col - 1, steps + 1) == -1 && solve(row - 1, col, steps + 1) == -1)){
	    maze[row][col] = '.';
	    return -1;
	}
	int ret = 0;
	if(solve(row, col + 1, steps + 1) != -1){
	    ret = solve(row, col + 1, steps + 1);
	}
	if(solve(row + 1, col, steps + 1) != -1){
            ret = solve(row + 1, col, steps + 1);
	}
	if(solve(row, col - 1, steps + 1) != -1){
            ret = solve(row, col - 1, steps + 1);
	}  if(solve(row - 1, col, steps + 1) != -1){
            ret = solve(row - 1, col, steps + 1);
	}
	return ret;
    }

    public String toString(){
        String str = "";
        for(int i  = 0; i < maze.length; i++){
            for(int j  = 0; j < maze[i].length; j++){
                str += maze[i][j];
            }
            str += "\n";
        }
        return str;
    }

  	
  	public static void main(String[]args){
      try{
	     Maze test = new Maze("data3.dat");
	     System.out.println(test);
         test.setAnimate(true);
         System.out.println(test.solve());
         System.out.println(test);
      }catch(FileNotFoundException e){
	  System.out.println("File not found!");
	      }
    }
}