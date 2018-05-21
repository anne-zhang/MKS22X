import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) throws FileNotFoundException{

		File text = new File(filename);
		Scanner scan = new Scanner(text);

		int row = scan.nextInt();
		int col = scan.nextInt();
		int finalE = scan.nextInt();
		int moves = scan.nextInt();

		int[][] lake = new int[row][col];
		for (int x = 0; x < row; x++) {
	    	for (int y = 0; y < col; y++) {
			lake[x][y] = scan.nextInt();
	    	}
		}

		for (int index = 0; index < moves; index++){
		int R = scan.nextInt() - 1;
		int C = scan.nextInt() - 1;
		int F = scan.nextInt();
		for (int counter = 0; counter < F; counter++){
		
		    int max = 0;
		    for (int rows = 0; rows < 3; rows++){
			for (int cols = 0; cols < 3; cols++){
			    if (lake[R + rows][C + cols] > max){
				max = lake[R + rows][C + cols];
			    }
			}
		    }

		    for (int rows = 0; rows < 3; rows++){
			for (int cols = 0; cols < 3; cols++){
			    if (lake[R + rows][C + cols] == max){
				lake[R + rows][C + cols]--;
			    }
			}
		    }
		}
	    }
		int depth = 0;
		for (int x = 0; x < row; x++) {
	    	for (int y = 0; y < col; y++) {
			if (finalE - lake[x][y] > 0) {
		    	depth = depth + (finalE - lake[x][y]);
			}
	    	}
		}
	
		return depth*72*72;
	
    	
    	}
    	
    public static int silver(String filename){
		int[][] current,old;
		char[][] map;
		try{
	    	File f = new File(filename);
	    	Scanner scan = new Scanner(f);

	    int row = scan.nextInt();
	    int col = scan.nextInt();
	    int moves = scan.nextInt();

	    map = new char[row][col];
	    current = new int[row][col];
	    old = new int[row][col];

	    for(int i = 0; i < row; i++){
			String line = scan.next();
			for(int j = 0; j < col; j++){
			    map[i][j] = line.charAt(j);
			}
	    }

	    old[scan.nextInt()-1][scan.nextInt()-1] = 1;

	    
	    for (int i = 0; i < moves; i++){
		for (int r = 0; r < row; r++){
		    for (int c = 0; c < col; c++){
			if (map[r][c] != '*'){
			    int ans = 0;
			    if(r+1 >= 0 && c >= 0 && r + 1 < row && c < col){
				ans += old[r+1][c];
			    }
			    if(r - 1 >= 0 && c >= 0 && r - 1  < row && c < col){
				ans += old[r-1][c];
			    }
			    if(r >= 0 && c + 1 >= 0 && r < row && c + 1 < col){
				ans += old[r][c+1];
			    }
			    if(r >= 0 && c - 1 >= 0 && r < row && c - 1 < col){
				ans += old[r][c-1];
			    }
			    current[r][c] = ans;
			}
		    }
		}
	        old = current;
		current = new int[row][col];
	    }
      
	    return old[scan.nextInt()-1][scan.nextInt()-1];
	}
	catch(FileNotFoundException e){
	    System.out.println("File not found: " + filename);
	    System.exit(1);
	}
	    
	return 0;
    }
    
 
}

