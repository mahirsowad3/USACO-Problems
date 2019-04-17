package blocked_billboard_II;

import java.util.*;
import java.io.*;

public class billboard {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(new File("billboard.in"));
		
		//lawnmower billboard
		int x1 = infile.nextInt();
		int y1 = infile.nextInt();
		int x2 = infile.nextInt();
		int y2 = infile.nextInt();
		
		//cow feed billboard
		int x3 = infile.nextInt();
		int y3 = infile.nextInt();
		int x4 = infile.nextInt();
		int y4 = infile.nextInt();
		
		int minAreaTarp = calculateArea(x1, y1, x2, y2);
		if (hasOverlap(x1, y1, x2, y2, x3, y3, x4, y4)) {
			minAreaTarp -= calculateOverlap(x1, y1, x2, y2, x3, y3, x4, y4);
		}
		PrintWriter outfile = new PrintWriter("billboard.out");
		outfile.println(minAreaTarp);
		outfile.close();
	}
	
	public static int calculateArea(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) * Math.abs(y1 - y2);
	}
	
	public static int calculateOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		return Math.abs(Math.min(x2, x4) - Math.max(x1, x3)) * Math.abs(Math.min(y2, y4) - Math.max(x1, x3)); 
	}
	
	public static boolean hasOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if (!inRange(x1, x2, x3) && !inRange(y1, y2, y3) || !inRange(x1, x2, x4) && !inRange(y1, y2, y4)) {
			return false;
		} else if (!inRange(x1, x2, x3) && !inRange(y1, y2, y4) || !inRange(x1, x2, x4) && !inRange(y1, y2, y3)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean inRange(int start, int stop, int x) {
		if (x >= start && x <= stop) {
			return true;
		} else {
			return false;
		}
	}
}
