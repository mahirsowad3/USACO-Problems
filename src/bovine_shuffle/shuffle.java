package bovine_shuffle;

import java.util.*;
import java.io.*;

public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("shuffle.in"));
		int N = Integer.parseInt(infile.readLine());
		int[] pattern = new int[N];
		int[] ids = new int[N];
		String s1 = infile.readLine();
		String s2 = infile.readLine();
		for (int i = 0; i < N; i++) {
			pattern[i] = Integer.parseInt(s1.split(" ")[i]);
			ids[i] = Integer.parseInt(s2.split(" ")[i]);
		}
		
		infile.close();
		
		int[] originalOrder = reverseSwapThreeTimes(pattern, ids);
		
		PrintWriter outfile = new PrintWriter("shuffle.out");
		for (int i = 0; i < N; i++) {
			outfile.println(originalOrder[i]);
		}
		outfile.close();
	}
	
	public static int[] reverseSwap(int[] pattern, int[] ids) {
		int[] newOrder = new int[pattern.length];
		for (int i = 0; i < pattern.length; i++) {
			newOrder[i] = ids[pattern[i]-1];
		}
		return newOrder;
	}
	
	public static int[] reverseSwapThreeTimes(int[] pattern, int[] ids) {
		return reverseSwap(pattern, reverseSwap(pattern, reverseSwap(pattern, ids)));
	}
}
