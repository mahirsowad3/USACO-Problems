package blocked_billboard;

import java.awt.geom.Point2D;
import java.util.*;
import java.io.*;

public class billboard {
	public static void main(String[] args) throws IOException {
		Scanner infile = new Scanner(new File("billboard.in"));
		//Billboard 1
		int x1 = infile.nextInt();
		int y1 = infile.nextInt();
		int x2 = infile.nextInt();
		int y2 = infile.nextInt();
		
		//BillBoard 2
		int x3 = infile.nextInt();
		int y3 = infile.nextInt();
		int x4 = infile.nextInt();
		int y4 = infile.nextInt();
		
		//Truck
		int x5 = infile.nextInt();
		int y5 = infile.nextInt();
		int x6 = infile.nextInt();
		int y6 = infile.nextInt();
		
		infile.close();
		
		int areaBillBoard1 = Math.abs(x1 - x2) * Math.abs(y1 - y2) - calculateOverlap(x1, y1, x2, y2, x5, y5, x6, y6);
		int areaBillBoard2 = Math.abs(x3 - x4) * Math.abs(y3 - y4) - calculateOverlap(x3, y3, x4, y4, x5, y5, x6, y6);
		
		int totalArea = 0;
		if (areaBillBoard1 > 0) {
			totalArea += areaBillBoard1;
		}
		if (areaBillBoard2 > 0) {
			totalArea += areaBillBoard2;
		}
		
		PrintWriter outfile = new PrintWriter("billboard.out");
		outfile.println(totalArea);
		outfile.close();
	}
	
	public static int calculateOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		if (Math.max(x1, x3) < Math.min(x2, x4) && Math.max(y1, y3) < Math.min(y2, y4)) {
			return Math.abs(Math.min(x2, x4) - Math.max(x1, x3))  * Math.abs(Math.min(y2, y4) - Math.max(y1, y3));
		}
		return 0;
	}
}
