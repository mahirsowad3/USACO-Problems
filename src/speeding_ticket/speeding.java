package speeding_ticket;

import java.util.*;
import java.io.*;

public class speeding {
	public static void main(String args[]) throws IOException {
		Scanner infile = new Scanner(new File("speeding.in"));
		int N = infile.nextInt();
		int M = infile.nextInt();
		int [][] roadSegments = new int[N][2];
		int[][] cowSegments = new int[M][2];
		
		
		for (int i = 0; i < N; i++) {
			roadSegments[i][0] = infile.nextInt();
			roadSegments[i][1] = infile.nextInt();
		}
		
		for (int i = 0; i < M; i++) {
			cowSegments[i][0] = infile.nextInt();
			cowSegments[i][1] = infile.nextInt();
		}
		
		int maxOverLimit = 0;
		for (int i = 0; i <= 100; i++) {
			int overLimit = 0;
			if (getSpeed(i, cowSegments) > getSpeed(i, roadSegments)) {
				overLimit = getSpeed(i, cowSegments) - getSpeed(i, roadSegments);
				if (overLimit > maxOverLimit) {
					maxOverLimit = overLimit;
				}
			}
		}
		
		infile.close();
		PrintWriter outfile = new PrintWriter("speeding.out");
		outfile.println(maxOverLimit);
		outfile.close();
	}
	
	public static int getSpeed(int x, int[][] speedSegments) {
		int mileSum = speedSegments[0][0];
		int currSpeed = speedSegments[0][1];
		for (int i = 1; i < speedSegments.length; i++) {
			if (x > mileSum) {
				mileSum += speedSegments[i][0];
				currSpeed = speedSegments[i][1];
			}
		}
		return currSpeed;
	}

}
