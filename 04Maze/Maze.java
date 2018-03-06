import java.util.*;
import java.io.*;

public class Maze{
	private char[][] maze;
	private boolean animate;
	private int rows;
	private int cols;
	
	public Maze(String filename){
		animate = false;
		int row = 0;
		int col = 0;
		
	}
	
    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    } 
  
	public String toString(){
    	String ans = "";
    	for (int r = 0; r < rows; r++){
      		for (int c = 0; c < cols; c++){
        	ans += maze[r][c];
      		}
      		ans += "\n";
    	}
    	return ans;
  	}
}