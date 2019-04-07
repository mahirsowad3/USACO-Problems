package bucket_list;
import java.io.*;
import java.util.*;

public class blist {
	public static void main(String[] args) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("blist.in"));
		int N = Integer.parseInt(infile.readLine());
		ArrayList<Integer> sT = new ArrayList<>();
		ArrayList<Integer> eT = new ArrayList<>();
		ArrayList<Integer> cB = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String s = infile.readLine();
			sT.add(Integer.parseInt(s.split(" ")[0]));
			eT.add(Integer.parseInt(s.split(" ")[1]));
			cB.add(Integer.parseInt(s.split(" ")[2]));
		}
		
		infile.close();
		
		int maxTime = 0;
		for (int i = 0; i < N; i++) {
			if (eT.get(i) > maxTime) {
				maxTime = eT.get(i);
			}
		}
		
		int maxB = 0;
		for (int i = 0; i < maxTime; i++) {
			int curB = 0;
			for (int j = 0; j < N; j++) {
				if (between(sT.get(j), eT.get(j), i)) {
					curB += cB.get(j);
				}
			}
			if (curB > maxB) {
				maxB = curB;
			}
		}
		PrintWriter outfile = new PrintWriter("blist.out");
		outfile.println(maxB);
		outfile.close();
	}
	
	public static boolean between(int start, int end, int num) {
		if (num >= start && num <= end) {
			return true;
		} else {
			return false;
		}
	}
}
