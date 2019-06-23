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
	}

}
