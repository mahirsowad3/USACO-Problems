package square_pasture;

import java.util.*;
import java.io.*;

public class square {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(new File("square.in"));
		
		//first rectangle
		int x1 = infile.nextInt();
		int y1 = infile.nextInt();
		int x2 = infile.nextInt();
		int y2 = infile.nextInt();
		
		//second rectangle
		int x3 = infile.nextInt();
		int y3 = infile.nextInt();
		int x4 = infile.nextInt();
		int y4 = infile.nextInt();
		
		int neededArea = (int)Math.pow(calculateLongestLength(x1, y1, x2, y2, x3, y3, x4, y4), 2);
		
		PrintWriter outfile = new PrintWriter("square.out");
		outfile.println(neededArea);
		outfile.close();
	}
	
	public static int calculateLongestLength(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		int[] x = {x1, x2, x3, x4};
		int[] y = {y1, y2, y3, y4};
		Arrays.sort(x);
		Arrays.sort(y);
		int maxXLength = Math.abs(x[3] - x[0]);
		int maxYLength = Math.abs(y[3] - y[0]);
		return Math.max(maxXLength, maxYLength);
	}

}
