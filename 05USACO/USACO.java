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

		int[] doIt = new int[3];
		int i = 0;
		while (i < moves) {

	    	int max = 0;
	    	int tracker = 0;
	    
	    	for (int x = 0; x < 3; x++) {
			doIt[x] = scan.nextInt();
	    	}
	    	
	    	for (int x = doIt[0] - 1; x < doIt[0] + 2; x++){
			for (int y = doIt[1] - 1; y < doIt[1] + 2; y++) {
		    	if (lake[x][y] == max) {
				lake[x][y] = lake[x][y] - doIt[2];
				tracker = lake[x][y];
		    	}
			}
	    	}

	    	for (int x = doIt[0] - 1; x < doIt[0] + 2; x++){
			for (int y = doIt[1] - 1; y < doIt[1] + 2; y++) {
		    	if (lake[x][y] > max) {
				max = lake[x][y];
		    	}
			}
	    	}

	    	for (int x = doIt[0] - 1; x < doIt[0] + 2; x++){
			for (int y = doIt[1] - 1; y < doIt[1] + 2; y++) {
		    	if (lake[x][y] > tracker) {
				lake[x][y] = tracker;
		    	}
			}
	    	}

	    	i = i + 1;
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
}