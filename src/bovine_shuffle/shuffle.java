package bovine_shuffle;

import java.util.*;
import java.io.*;

public class shuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("shuffle.in"));
		int N = Integer.parseInt(infile.readLine());
		HashMap<Integer, Integer> pairs = new HashMap<>();
		String s1 = infile.readLine();
		String s2 = infile.readLine();
		for (int i = 0; i < N; i++) {
			pairs.put(Integer.parseInt(s1.split(" ")[i]), Integer.parseInt(s2.split(" ")[i]));
		}
		
		infile.close();
		PrintWriter outfile = new PrintWriter("shuffle.out");
		for (int i = 1; i <= N; i++) {
			outfile.println(pairs.get(i));
		}
		outfile.close();
	}
}
