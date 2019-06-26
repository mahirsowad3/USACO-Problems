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
		for (int i = 1; i <= 100; i++) {
			int overLimit = 0;
			for (int j = 0; j < N; j++) {
				if (j == 1) {
					if (inBetween(cowSegments[i][0], 0, roadSegments[i][0])) {
						if (cowSegments[i][1] > roadSegments[i][1]) {
							overLimit = cowSegments[i][1] - roadSegments[i][1];
						}
					}
				} else {
					if (inBetween(cowSegments[i][0], roadSegments[i - 1][0], roadSegments[i][0])) {
						if (cowSegments[i][1] > roadSegments[i][1]) {
							overLimit = cowSegments[i][1] - roadSegments[i][1];
						}
					}
				}
				
				if (overLimit > maxOverLimit) {
					maxOverLimit = overLimit;
				}
			}
		}
		
		System.out.println(maxOverLimit);
	}
	
	public static boolean inBetween(int a, int b, int c) {
		if (a >= b && a <= c) {
			return true;
		}
		return false;
	}

}
