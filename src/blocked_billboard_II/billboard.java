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
		
		int minAreaTarp = 0; //calculateArea(x1, y1, x2, y2);
		
		int coveredCorners = 0;
		if (cornerCovered(x1, y1, x3, y3, x4, y4)) {
			coveredCorners++;
		}
		if (cornerCovered(x1, y2, x3, y3, x4, y4)) {
			coveredCorners++;
		}
		if (cornerCovered(x2, y1, x3, y3, x4, y4)) {
			coveredCorners++;
		}
		if (cornerCovered(x2, y2, x3, y3, x4, y4)) {
			coveredCorners++;
		}
		
		if (coveredCorners < 2) {
			minAreaTarp = calculateArea(x1, y1, x2, y2);
		} else if (coveredCorners == 2 || coveredCorners == 3) {
			minAreaTarp = calculateArea(x1, y1, x2, y2) - Math.abs(Math.min(x2, x4) - Math.max(x1, x3)) * Math.abs(Math.min(y2, y4) - Math.max(y1, y3));
		} else {
			minAreaTarp = 0;
		}
		
		
		PrintWriter outfile = new PrintWriter("billboard.out");
		outfile.println(minAreaTarp);
		outfile.close();
	}
	
	public static int calculateArea(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) * Math.abs(y1 - y2);
	}
	
	public static boolean inRange(int start, int stop, int x) {
		if (x >= start && x <= stop) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean cornerCovered(int x, int y, int x3, int y3, int x4, int y4) {
		if (inRange(x3, x4, x) && inRange(y3, y4, y)) {
			return true;
		} else {
			return false;
		}
	}
}
