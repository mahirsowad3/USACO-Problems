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
		
		int minMoves = 0;
		int maxMoves = 0;
		if (Math.abs(locations.get(0) - locations.get(1)) == 1 && Math.abs(locations.get(1)-locations.get(2)) == 1) {
			minMoves = 0;
			maxMoves = 0;
		}
		if (Math.abs(locations.get(0) - locations.get(1)) > 1 && Math.abs(locations.get(1)-locations.get(2)) == 1 || locations.get(0) - locations.get(1) == 1 && Math.abs(locations.get(1)-locations.get(2)) > 1) {
			minMoves = 1;
			maxMoves = 2;
		} 
		if (Math.abs(locations.get(0) - locations.get(1)) > 1 && Math.abs(locations.get(1)-locations.get(2)) > 1) {
			minMoves = 2;
			maxMoves = 2;
		}
		
		System.out.println(minMoves);
		System.out.println(maxMoves);
		
		
	}
}
