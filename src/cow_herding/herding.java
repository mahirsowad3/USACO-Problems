package cow_herding;

import java.io.*;
import java.util.*;

public class herding {
	public static void main(String args[]) throws IOException {
		BufferedReader infile = new BufferedReader(new FileReader("herding.in"));
		ArrayList <Integer> locations = new ArrayList<>();
		String s = infile.readLine();
		locations.add(Integer.parseInt(s.split(" ")[0]));
		locations.add(Integer.parseInt(s.split(" ")[1]));
		locations.add(Integer.parseInt(s.split(" ")[2]));
		Collections.sort(locations);
		infile.close();
		
		int minMoves = 0;
		int maxMoves = 0;
		
		if (isConsecutive(locations.get(0), locations.get(1), locations.get(2))) {
			minMoves = 0;
			maxMoves = 0;
		}
		else {
			if (locations.get(1) - locations.get(0) == 2 || locations.get(2) - locations.get(1) == 2) {
				minMoves = 1;
			} else {
				minMoves = 2;
			}
			//calculating max
			maxMoves = Math.max(locations.get(1) - locations.get(0), locations.get(2) - locations.get(1)) - 1;
		}
		PrintWriter outfile = new PrintWriter("herding.out");
		outfile.println(minMoves);
		outfile.println(maxMoves);
		outfile.close();
	}
	
	public static boolean isConsecutive(int a, int b, int c) {
		if (b-a == 1 && c-b == 1) {
			return true;
		} 
		if ((b-a == 2 && c-b == 1) || (b-a == 1 && c-b == 2)) {
			return true;
		}
		else {
			return false;
		}
	}
}
